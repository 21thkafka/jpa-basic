package hellojpa;

import RoleType.RoleType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        //데이터를 변경할때 트랜젝션 설정을 꼭 해야 jpa가 작동함
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //insert 할때
    /*        Member member = new Member();
            member.setId(2L);
            member.setName("이영한");
            em.persist(member);*/

            //update 할때
  /*          Member findMember = em.find(Member.class, 1L);
            System.out.println("findMember id : " + findMember.getId());
            System.out.println("findMember name : " + findMember.getName());
            findMember.setName("신명현");*/

            //delete 할때
//            em.remove(findMember);

            //목록 조회할때 - jpql 사용
  /*          List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(1)  //페이징 - 첫번째부터
                    .setMaxResults(10)  //페이징 - 열번째까지 조회
                    .getResultList();

            for(Member member : result){
                System.out.println("member = " + member.getName());
            }*/

            Member member = new Member();
        //    member.setId(12L);
            member.setUsername("HelloJPA3");
            member.setRoleType(RoleType.GUEST);
            em.persist(member);

            Member anotherMember = em.find(Member.class, 1L);
            System.out.println("anotherMember id : " + anotherMember.getId());
            System.out.println("anotherMember name : " + anotherMember.getUsername());
            System.out.println("anotherMember getRoleType : " + anotherMember.getRoleType());

            Member member1 = new Member();
            member1.setUsername("a");
            member1.setRoleType(RoleType.GUEST);
            Member member2 = new Member();
            member2.setUsername("b");
            member2.setRoleType(RoleType.GUEST);

            em.persist(member1);
            em.persist(member2);
            //버퍼링 기능 사용 가능

 //           Member member = em.find(Member.class, 150L);
 //           member.setName("zzzzz");    //기존 데이터 값 변경할때는 persist 할 필요 없음
                                        //최초 db 값을 읽어 스냇샷을 생성, commit 전에 스냇샷과 엔티티를 비교하고 변경된 것을 감지하여 변경

            //플러쉬 발생 : 변경감지, 수정된 엔티티 쓰기 지연 sql 저장소에 등록, 쓰기지연sql 저장소의 쿼리를 데이터베이스에 전송
            //em.flush() - 직접 호출 / 트랜잭션 커밋 - 플러시 자동 호출 / jpql 쿼리 실행 - 플러시 지동호출
        /*    Member member = new Member(200L, "shin0808");
            em.persist(member);
            em.flush(); //플러쉬는 영송석 컨텍스트를 비우지 않음, 영속성 컨텍스트의 변경 내용을 데이터베이스에 동기화시킴

            Member member2 = em.find(Member.class, 200L);
            member2.setName("AAAAAA"); //영속

            em.detach(member2); //준영속 - commit을 해도 db에 반영 안됨, member2 name은 계속 shin0808임
            em.close(); // 영속성 컨테스트를 초기화함
         */

            System.out.println("======================");

            tx.commit();    //여기에서 직접 db에 쿼리가 날아감. 그 이전에는 캐시에만 저장되어 있고 실질적인 쿼리 실행 X

        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}

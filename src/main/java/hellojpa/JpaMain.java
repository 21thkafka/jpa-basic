package hellojpa;

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
/*            Member member = new Member();
            member.setId(2L);
            member.setName("이영한");
            em.persist(member);*/

            //update 할때
            Member findMember = em.find(Member.class, 1L);
            System.out.println("findMember id : " + findMember.getId());
            System.out.println("findMember name : " + findMember.getName());
            findMember.setName("신명현");

            //delete 할때
//            em.remove(findMember);

            //목록 조회할때 - jpql 사용
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(1)  //페이징 - 첫번째부터
                    .setMaxResults(10)  //페이징 - 열번째까지 조회
                    .getResultList();

            for(Member member : result){
                System.out.println("member = " + member.getName());
            }

            tx.commit();

        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}

import domain.Address;
import domain.AddressEntity;
import domain.Member;
import domain.Period;
import hellojpa.Child;
import hellojpa.Parent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class JpaMain {

    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
/*            Order order = new Order();
//            order.addOrderItem(new OrderItem);
            em.persist(order);

            OrderItem orderItem = new OrderItem();  //양방향 안해도 이렇게 해도 가능
            orderItem.setOrder(order);              //그러나 실무에서는 복잡한 jpql 작성하다  양방향 필요한 경우가 많음.
                                                    //그래도 최대한 단방향으로 만드는 게 이상적


            em.persist(orderItem);*/

    /*        Movie movie = new Movie();
            movie.setDirector("놀란");
            movie.setActor("제시카 차스테인");
            movie.setName("인터 스텔라");
            movie.setPrice(10000);

            em.persist(movie);

            em.flush();
            em.clear();

            Movie findMovie = em.find(Movie.class, movie.getId());
            System.out.println("findMovie : " + findMovie);*/


    /*        Product product = new Product();
            product.setName("testProduct");
            product.setRegId("testId");
            product.setRegDate(LocalDateTime.now());

            em.persist(product);

            em.flush();
            em.clear(); */

    /*        Book book = new Book();
            book.setName("JPA");
            book.setAuthor("신명현");

            em.persist(book);

            em.flush();
            em.clear();

            Book findBook = em.find(Book.class, book.getId());
            System.out.println("findBookId : " + findBook.getId());
            System.out.println("findBookName : " + findBook.getName());*/

      /*      Child child1 = new Child();
            Child child2 = new Child();

            Parent parent = new Parent();
            parent.addChild(child1);
            parent.addChild(child2);

            em.persist(parent);
            em.persist(child1);     //cascade를 사용하면 parent 객체 persist할 때 연관된 child도 영속화 시킬 수 있음
            em.persist(child2);     //cascade를 사용하면 이부분 생략 가능
                                      //하나의 부모 엔티티에 완전히 종속적일때 쓸 수 있음 ex)첨부파일, 다른 엔티티에서 자식 엔티티를 관여하면 쓸 수 없음
            em.flush();
            em.clear();

            Parent findParent = em.find(Parent.class, parent.getId());
            findParent.getChildList().remove(0);    //orphanRemoval = true가 설정 되면 부모 객체와 끊어질때 지워짐
                                                          //db cascade 설정과 같음, 부모 엔티티가 단독으로 자식 엔티티 관리할때만 사용

            em.remove(findParent);*/

            //임베디드값 타입 연습
   /*         Member member = new Member();
            member.setName("hellouser");
            LocalDateTime afterTime = LocalDateTime.now().plusDays(2);
            member.setPeriod(new Period(LocalDateTime.now(), afterTime));

            em.persist(member);*/

            //값타입 컬렉션 연습
    /*        Member member = new Member();
            member.setName("member1");
            member.setHomeAddress(new Address("homeCity1", "street2", "111-222"));
            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("초밥");
            member.getFavoriteFoods().add("피자");

        //    member.getAddressHistory().add(new Address("oldCity1", "street2", "111-222"));
        //    member.getAddressHistory().add(new Address("oldCity2", "street3", "111-222"));
            //member만 persist해도 homeAddress, addressHistory, favoriteFood 같이 persist 됨, member에 종속됨
            //값타입 컬렉션 대신 addressEntity로 1대다 사용시 아래와 같이 수정
            member.getAddressHistory().add(new AddressEntity("oldCity1", "street2", "111-222"));
            member.getAddressHistory().add(new AddressEntity("oldCity2", "street3", "111-222"));

            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("================ START =============");
            Member findMember = em.find(Member.class, member.getId());*/
            //컬렉션들은 지연로딩
        /*    List<Address> addressesHistory = findMember.getAddressHistory();
            for (Address address : addressesHistory){
                System.out.println("address = " + address.getCity());
            }
            Set<String> favoriteFoods = findMember.getFavoriteFoods();
            for (String favoriteFood : favoriteFoods){
                System.out.println("favoriteFood = " + favoriteFood);
            }*/
            //homeCity -> newCity
//            findMember.getHomeAddress().setCity("newCity"); //이렇게 수정하면 안됨
    /*        Address old = findMember.getHomeAddress();
            findMember.setHomeAddress(new Address("newCity", old.getStreet(), old.getZipcode()));

            //치킨 -> 한식
            findMember.getFavoriteFoods().remove("치킨");
            findMember.getFavoriteFoods().add("한식");*/

            //old1 -> new1, member 도메인에 equals가 제대로 구현되어 있어야함, 해당 member_id인 address 데이터를 다 지우고 insert 방식
            //findMember.getAddressHistory().remove(new Address("oldCity1", "street2", "111-222"));
            //findMember.getAddressHistory().add(new Address("newCity1", "street2", "111-222"));
            //다루기 까다로우므로 실무에서 값타입 컬렉션 대신 1 대 다 엔티티 관계를 고려


            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}

import domain.Member;
import domain.Period;
import hellojpa.Child;
import hellojpa.Parent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

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

            Member member = new Member();
            member.setName("hellouser");
            LocalDateTime afterTime = LocalDateTime.now().plusDays(2);
            member.setPeriod(new Period(LocalDateTime.now(), afterTime));

            em.persist(member);

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}

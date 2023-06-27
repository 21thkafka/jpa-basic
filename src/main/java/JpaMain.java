import domain.Member;
import domain.Order;
import domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Order order = new Order();
//            order.addOrderItem(new OrderItem);
            em.persist(order);

            OrderItem orderItem = new OrderItem();  //양방향 안해도 이렇게 해도 가능
            orderItem.setOrder(order);              //그러나 실무에서는 복잡한 jpql 작성하다  양방향 필요한 경우가 많음.
                                                    //그래도 최대한 단방향으로 만드는 게 이상적

            em.persist(orderItem);

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}

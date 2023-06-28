package hellojpa;

import javax.persistence.*;

//상속관계 매핑
@Entity
@Inheritance(strategy = InheritanceType.JOINED) //기본 전략이 단일 테이블 생성, 조인 전략으로 지정해야 함.
                                                  // 조인 전략이 정석. 정규화, 공간 효율화 증가, 조인쿼리로 성능 저하 올 수 있음
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // 단일 테이블 전략 : 성능이 잘 나옴, 디폴트로 D_TYPE 컬럼 포함, 그러나 자식 컬럼 모두 null 허용해야함
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)    //각 서브 타입 엔티티 테이블만 생성, 매우 비권장 전략
                                                            // insert할때는 간편하지만 부모 클래스로 조회할때 union 사용하는 복잡한 쿼리 생성
@DiscriminatorColumn(name = "DIS_TYPE")    //D_TYPE 서브 타입 엔티티 명이 들어감. 넣어주는 것이 좋음, 이름 지정 가능, TABLE_PER_CLASS 전략에선 필요없음
public class Product {
//public abstract class Product {     //TABLE_PER_CLASS 전략으로 하면 추상 클래스로 변경해야함
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

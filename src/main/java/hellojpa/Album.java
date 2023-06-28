package hellojpa;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")    //수퍼 엔티티에 들어갈 서브 엔티티 명의 별칭을 지정할 수 있음
public class Album extends Product {
    private String artist;
}

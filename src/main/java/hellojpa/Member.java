package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MBR")  //맵핑할 테이블 명칭
public class Member {

    @Id
    private Long id;

    @Column(unique = true, length = 10) //유니크 키 설정, 길이 제한 설정 가능
    private String name;


    public Member(){

    }

    public Member(Long id, String name){
        this.id = id;
        this.name = name;
    }

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
}

package hellojpa;

import RoleType.RoleType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
//@Table(name="MBR")  //맵핑할 테이블 명칭, uniqueConstraints 설정으로 유니크키 설정 가능
public class Member {

    @Id
    private Long id;

 //   @Column(unique = true, length = 10) //유니크 키 설정, 길이 제한 설정 가능
    @Column(name = "name")    //insertable, updatable 변경 가능
    private String username;  //nullable  null 값 허용 여부 설정

    private Integer age;

    @Column(precision = 10)
    private BigDecimal viewCount;   // 큰 숫자의 소수점 포함한 자릿 수를 지정

    @Enumerated(EnumType.STRING)    // enum 타입 매핑
 //  @Enumerated
    private RoleType roleType;     //EnumType.ORDINAL : enum 순서를 db에 저장 , enum에 새로운 것을 추가하는 순간 버그가 됨 - 매우 위험
                                    //EnumType.STRING : enum 이름을 db에 저장 - 사용 권장

    @Temporal(TemporalType.TIMESTAMP)  // 날짜 타입 매핑
    private Date createDate;

    //@Temporal은 LocalDate, LocalDateTime을 사용할 경우 생략 가능
    private LocalDate testLocalDate;
    private LocalDateTime testLocalDateTime;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public Integer getAge() {
      return age;
   }

   public void setAge(Integer age) {
      this.age = age;
   }

   public RoleType getRoleType() {
      return roleType;
   }

   public void setRoleType(RoleType roleType) {
      this.roleType = roleType;
   }

   @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob    //blob, clob 매핑
    private String description;

    @Transient // db와 상관없이 메모리에서만 쓰고 싶을 때 사용
    private int temp;

    public Member(){

    }


}

package domain;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass   //MappedSuperclass 상속관계 매핑이 아님, 엔티티 아님, 테이블과 매빙 아님,
                    // 부모클래스를 상속받는 자식 클래스에 매핑 정보만 제공, 추상클래스로 사용 권장
public abstract class BaseEntity {

    private String regId;
    private LocalDateTime regDate;
    private String modifyId;
    private LocalDateTime modifyDate;

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    public String getModifyId() {
        return modifyId;
    }

    public void setModifyId(String modifyId) {
        this.modifyId = modifyId;
    }

    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }
}

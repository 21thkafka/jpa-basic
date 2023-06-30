package domain;

import hellojpa.Product;

import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("A")    //수퍼 엔티티에 들어갈 서브 엔티티 명의 별칭을 지정할 수 있음
public class Album extends Item {
    private String artist;
    private String etc;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }
}

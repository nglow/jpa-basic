package me.nglow.springjpabasic.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ALBUM")
public class Album  extends Item {

    private String artist;
    private String etc;

    public String getArtist() {
        return artist;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}

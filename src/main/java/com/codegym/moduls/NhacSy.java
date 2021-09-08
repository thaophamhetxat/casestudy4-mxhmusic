package com.codegym.moduls;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NhacSy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idNhacSy;
    String nameNhacSy;
    String musicianPhoto;

    public NhacSy() {
    }

    public NhacSy(int idNhacSy, String nameNhacSy, String musicianPhoto) {
        this.idNhacSy = idNhacSy;
        this.nameNhacSy = nameNhacSy;
        this.musicianPhoto = musicianPhoto;
    }

    public String getMusicianPhoto() {
        return musicianPhoto;
    }

    public void setMusicianPhoto(String musicianPhoto) {
        this.musicianPhoto = musicianPhoto;
    }

    public int getIdNhacSy() {
        return idNhacSy;
    }

    public void setIdNhacSy(int idNhacSy) {
        this.idNhacSy = idNhacSy;
    }

    public String getNameNhacSy() {
        return nameNhacSy;
    }

    public void setNameNhacSy(String nameNhacSy) {
        this.nameNhacSy = nameNhacSy;
    }
}

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

    public NhacSy() {
    }

    public NhacSy(int idNhacSy, String nameNhacSy) {
        this.idNhacSy = idNhacSy;
        this.nameNhacSy = nameNhacSy;
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

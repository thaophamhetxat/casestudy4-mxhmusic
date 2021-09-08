package com.codegym.moduls;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CaSy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idCaSy;
    String nameCaSy;

    public CaSy(int idCaSy, String nameCaSy) {
        this.idCaSy = idCaSy;
        this.nameCaSy = nameCaSy;
    }

    public CaSy() {
    }

    public int getIdCaSy() {
        return idCaSy;
    }

    public void setIdCaSy(int idCaSy) {
        this.idCaSy = idCaSy;
    }

    public String getNameCaSy() {
        return nameCaSy;
    }

    public void setNameCaSy(String nameCaSy) {
        this.nameCaSy = nameCaSy;
    }
}
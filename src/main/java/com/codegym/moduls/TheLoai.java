package com.codegym.moduls;

import javax.persistence.*;
import java.util.List;

@Entity
public class TheLoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idTheLoai;
    String nameTheLoai;



    public TheLoai() {
    }

    public TheLoai(int idTheLoai, String nameTheLoai) {
        this.idTheLoai = idTheLoai;
        this.nameTheLoai = nameTheLoai;
    }

    public int getIdTheLoai() {
        return idTheLoai;
    }

    public void setIdTheLoai(int idTheLoai) {
        this.idTheLoai = idTheLoai;
    }

    public String getNameTheLoai() {
        return nameTheLoai;
    }

    public void setNameTheLoai(String nameTheLoai) {
        this.nameTheLoai = nameTheLoai;
    }

}

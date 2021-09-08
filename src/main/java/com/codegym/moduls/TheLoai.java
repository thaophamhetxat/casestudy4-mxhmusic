package com.codegym.moduls;

import javax.persistence.*;
import java.util.List;

@Entity
public class TheLoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String nameTheLoai;

    @OneToMany(fetch = FetchType.EAGER)
    private List<BlogMusic> blogMusics;


    public TheLoai() {
    }

    public TheLoai(int id, String nameTheLoai, List<BlogMusic> blogMusics) {
        this.id = id;
        this.nameTheLoai = nameTheLoai;
        this.blogMusics = blogMusics;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameTheLoai() {
        return nameTheLoai;
    }

    public void setNameTheLoai(String nameTheLoai) {
        this.nameTheLoai = nameTheLoai;
    }

    public List<BlogMusic> getBlogMusics() {
        return blogMusics;
    }

    public void setBlogMusics(List<BlogMusic> blogMusics) {
        this.blogMusics = blogMusics;
    }
}

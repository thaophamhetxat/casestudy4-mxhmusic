package com.codegym.moduls;

import javax.persistence.*;

@Entity
public class DanhGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idDanhGia;
    int rate;  //số sao
    int idPerson;
    int idBlog;

    @ManyToOne
    private Person person;
    @ManyToOne
    private BlogMusic blogMusic;

    public DanhGia() {
    }

    public DanhGia(int idDanhGia, int rate, int idPerson, int idBlog, Person person, BlogMusic blogMusic) {
        this.idDanhGia = idDanhGia;
        this.rate = rate;
        this.idPerson = idPerson;
        this.idBlog = idBlog;
        this.person = person;
        this.blogMusic = blogMusic;
    }

    public int getIdDanhGia() {
        return idDanhGia;
    }

    public void setIdDanhGia(int idDanhGia) {
        this.idDanhGia = idDanhGia;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public int getIdBlog() {
        return idBlog;
    }

    public void setIdBlog(int idBlog) {
        this.idBlog = idBlog;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public BlogMusic getBlogMusic() {
        return blogMusic;
    }

    public void setBlogMusic(BlogMusic blogMusic) {
        this.blogMusic = blogMusic;
    }
}

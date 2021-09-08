package com.codegym.moduls;

import javax.persistence.*;

@Entity
public class YeuThich {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idYeuThich;
    int idPerson;
    int idBlog;

    @ManyToOne
    private Person person;
    @ManyToOne
    private BlogMusic blogMusic;

    public YeuThich(int idYeuThich, int idPerson, int idBlog, Person person, BlogMusic blogMusic) {
        this.idYeuThich = idYeuThich;
        this.idPerson = idPerson;
        this.idBlog = idBlog;
        this.person = person;
        this.blogMusic = blogMusic;
    }

    public YeuThich() {
    }

    public int getIdYeuThich() {
        return idYeuThich;
    }

    public void setIdYeuThich(int idYeuThich) {
        this.idYeuThich = idYeuThich;
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

package com.codegym.moduls;

import javax.persistence.*;

@Entity
public class BlogMusic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idBlog;
    String tenBaiHat;
    String fileMusic;
    String fileImage;
    private double price;
    int views;
    int likes;
    int dislike;

    @ManyToOne
    private NhacSy nhacSy;
    @ManyToOne
    private CaSy caSy;
    @ManyToOne
    private TheLoai theLoai;
    @ManyToOne
    private Person person;


    public BlogMusic() {
    }

    public BlogMusic(int idBlog, String tenBaiHat, String fileMusic, String fileImage, double price, int views, int likes,
                     int dislike, NhacSy nhacSy, CaSy caSy, TheLoai theLoai, Person person) {
        this.idBlog = idBlog;
        this.tenBaiHat = tenBaiHat;
        this.fileMusic = fileMusic;
        this.fileImage = fileImage;
        this.price = price;
        this.views = views;
        this.likes = likes;
        this.dislike = dislike;
        this.nhacSy = nhacSy;
        this.caSy = caSy;
        this.theLoai = theLoai;
        this.person = person;
    }

    public int getIdBlog() {
        return idBlog;
    }

    public void setIdBlog(int idBlog) {
        this.idBlog = idBlog;
    }

    public String getFileMusic() {
        return fileMusic;
    }

    public void setFileMusic(String fileMusic) {
        this.fileMusic = fileMusic;
    }

    public String getFileImage() {
        return fileImage;
    }

    public void setFileImage(String fileImage) {
        this.fileImage = fileImage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    public NhacSy getNhacSy() {
        return nhacSy;
    }

    public void setNhacSy(NhacSy nhacSy) {
        this.nhacSy = nhacSy;
    }

    public CaSy getCaSy() {
        return caSy;
    }

    public void setCaSy(CaSy caSy) {
        this.caSy = caSy;
    }

    public TheLoai getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(TheLoai theLoai) {
        this.theLoai = theLoai;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getTenBaiHat() {
        return tenBaiHat;
    }

    public void setTenBaiHat(String tenBaiHat) {
        this.tenBaiHat = tenBaiHat;
    }
}

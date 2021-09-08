package com.codegym.moduls;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idComment;
    String comments;

    @ManyToOne
    private Person person;
    @ManyToOne
    private BlogMusic blogMusic;

    public Comment() {
    }

    public Comment(int idComment, String comments, Person person, BlogMusic blogMusic) {
        this.idComment = idComment;
        this.comments = comments;
        this.person = person;
        this.blogMusic = blogMusic;
    }

    public int getIdComment() {
        return idComment;
    }

    public void setIdComment(int idComment) {
        this.idComment = idComment;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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

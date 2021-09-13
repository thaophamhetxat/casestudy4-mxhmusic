package com.codegym.moduls;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idComment;
    String comments;

    public Comment() {
    }

    public Comment(int idComment, String comments) {
        this.idComment = idComment;
        this.comments = comments;
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
}

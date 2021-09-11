package com.codegym.moduls;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idComment;
    String comments;
    String nameUser;



    public Comment() {
    }

    public Comment(int idComment, String comments, String nameUser) {
        this.idComment = idComment;
        this.comments = comments;
        this.nameUser = nameUser;
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

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }
}

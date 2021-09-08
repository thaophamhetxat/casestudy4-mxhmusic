package com.codegym.service;

import com.codegym.moduls.BlogMusic;
import com.codegym.moduls.Comment;
import com.codegym.moduls.TheLoai;

import java.util.Optional;

public interface ICommentService {
    Comment save(Comment comment);
    Iterable<Comment> findAll();
    Optional<Comment> findById(int idComment);
    void editComment(Comment comment);
}

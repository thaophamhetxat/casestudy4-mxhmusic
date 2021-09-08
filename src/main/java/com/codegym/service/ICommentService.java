package com.codegym.service;

import com.codegym.moduls.Comment;
import com.codegym.moduls.TheLoai;

import java.util.Optional;

public interface ICommentService {
    Iterable<Comment> findAll();

    Optional<Comment> findById(int idComment);
}

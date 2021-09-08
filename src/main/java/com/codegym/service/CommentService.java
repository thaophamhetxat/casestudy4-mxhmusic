package com.codegym.service;

import com.codegym.moduls.Comment;

import java.util.Optional;

public class CommentService implements ICommentService{
    @Override
    public Iterable<Comment> findAll() {
        return null;
    }

    @Override
    public Optional<Comment> findById(int idComment) {
        return Optional.empty();
    }
}

package com.codegym.service;

import com.codegym.moduls.Comment;
import com.codegym.repository.ICommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CommentService implements ICommentService{
    @Autowired
    ICommentRepo iCommentRepo;

    @Override
    public Comment save(Comment comment) {
        return iCommentRepo.save(comment);
    }

    @Override
    public Iterable<Comment> findAll() {
        return iCommentRepo.findAll();
    }

    @Override
    public Optional<Comment> findById(int idComment) {
        return iCommentRepo.findById(idComment);
    }

    @Override
    public void editComment(Comment comment) {
        iCommentRepo.save(comment);
    }
}

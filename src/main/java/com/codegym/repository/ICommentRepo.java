package com.codegym.repository;

import com.codegym.moduls.CaSy;
import com.codegym.moduls.Comment;
import org.springframework.data.repository.CrudRepository;

public interface ICommentRepo extends CrudRepository<Comment,Integer> {
}

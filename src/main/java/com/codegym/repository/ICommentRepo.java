package com.codegym.repository;

import com.codegym.moduls.BlogMusic;
import com.codegym.moduls.CaSy;
import com.codegym.moduls.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface ICommentRepo extends PagingAndSortingRepository<Comment,Integer> {

//    @Query(value = "select c from Comment c where c.blogMusic.idBlog=?1")
//    ArrayList<Comment> findAllCommentByBlog(int idBlog);
}

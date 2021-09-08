package com.codegym.repository;

import com.codegym.moduls.BlogMusic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;


public interface IBlogMusicRepo extends PagingAndSortingRepository<BlogMusic, Integer> {
    @Query(value = "select c from BlogMusic c where c.tenBaiHat like concat('%',:tenBaiHat,'%')")
    ArrayList<BlogMusic> findAllByName(@Param("tenBaiHat") String tenBaiHat);




}
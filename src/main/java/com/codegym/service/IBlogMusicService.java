package com.codegym.service;

import com.codegym.moduls.BlogMusic;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.Optional;

public interface IBlogMusicService {
    BlogMusic save(BlogMusic blogMusic);
    BlogMusic findById(int idBlog);
    Optional<BlogMusic> findByIdo(int idBlog);

    ArrayList<BlogMusic> findAll();

    ArrayList<BlogMusic> findAllByName(String tenBaiHat);

    Page<BlogMusic> findAll(Pageable pageable);

    void delete(BlogMusic blogMusic);
    void edit(BlogMusic blogMusic);

    void views(int idBlog);

//    ArrayList<BlogMusic> SortMaxViews();

    ArrayList<BlogMusic> findAllByNameRemix();
    ArrayList<BlogMusic> findAllByNamePop();
    ArrayList<BlogMusic> findAllByNameUs();

}

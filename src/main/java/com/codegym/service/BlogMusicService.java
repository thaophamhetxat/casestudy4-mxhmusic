package com.codegym.service;

import com.codegym.moduls.BlogMusic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.codegym.repository.IBlogMusicRepo;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Optional;
@Transactional

public class BlogMusicService implements IBlogMusicService {
    @Autowired
    IBlogMusicRepo iBlogMusicRepo;
    @Autowired
    EntityManager entityManager;

    @Override
    public BlogMusic save(BlogMusic blogMusic) {
        return iBlogMusicRepo.save(blogMusic);
    }

    @Override
    public BlogMusic findById(int idBlog) {
        return iBlogMusicRepo.findById(idBlog).get();
    }

    @Override
    public Optional<BlogMusic> findByIdo(int idBlog) {
        return iBlogMusicRepo.findById(idBlog);
    }

    @Override
    public ArrayList<BlogMusic> findAll() {
        return (ArrayList<BlogMusic>) iBlogMusicRepo.findAll();
    }

    @Override
    public ArrayList<BlogMusic> findAllByName(String tenBaiHat) {
        return iBlogMusicRepo.findAllByName(tenBaiHat);
    }

    @Override
    public Page<BlogMusic> findAll(Pageable pageable) {
        return iBlogMusicRepo.findAll(pageable);
    }

    @Override
    public void delete(BlogMusic blogMusic) {
        iBlogMusicRepo.delete(blogMusic);
    }

    @Override
    public void edit(BlogMusic blogMusic) {
        iBlogMusicRepo.save(blogMusic);
    }





    @Override
    public void views(int idBlog) {
        Optional<BlogMusic> view = iBlogMusicRepo.findById(idBlog);
        view.get().setViews(view.get().getViews() + 1);
        iBlogMusicRepo.save(view.get());
    }


    @Override
    public ArrayList<BlogMusic> findAllByNameRemix() {
        String queryStr = "select b from BlogMusic b  where b.theLoai.nameTheLoai like '%remix%'";
        TypedQuery<BlogMusic> query = entityManager.createQuery(queryStr, BlogMusic.class);
        return (ArrayList<BlogMusic>) query.getResultList();
    }


    @Override
    public ArrayList<BlogMusic> findAllByNamePop() {
        String queryStr = "select b from BlogMusic b  where b.theLoai.nameTheLoai like '%pop%'";
        TypedQuery<BlogMusic> query = entityManager.createQuery(queryStr, BlogMusic.class);
        return (ArrayList<BlogMusic>) query.getResultList();
    }

    @Override
    public ArrayList<BlogMusic> findAllByNameUs() {
        String queryStr = "select b from BlogMusic b  where b.theLoai.nameTheLoai like '%us%'";
        TypedQuery<BlogMusic> query = entityManager.createQuery(queryStr, BlogMusic.class);
        return (ArrayList<BlogMusic>) query.getResultList();
    }


}


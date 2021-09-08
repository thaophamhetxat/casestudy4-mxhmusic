package com.codegym.service;

import com.codegym.moduls.TheLoai;
import org.springframework.beans.factory.annotation.Autowired;

import com.codegym.repository.ITheLoaiRepo;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Transactional
public class TheLoaiService implements ITheLoaiService{
    @Autowired
    ITheLoaiRepo iTheLoaiRepo;

    @Override
    public Iterable<TheLoai> findAll() {
        return iTheLoaiRepo.findAll();
    }

    @Override
    public Optional<TheLoai> findById(int idTheLoai) {
        return iTheLoaiRepo.findById(idTheLoai);
    }
}

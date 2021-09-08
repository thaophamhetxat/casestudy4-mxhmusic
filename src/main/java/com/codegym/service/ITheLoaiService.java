package com.codegym.service;

import com.codegym.moduls.TheLoai;

import java.util.Optional;

public interface ITheLoaiService {
    Iterable<TheLoai> findAll();

    Optional<TheLoai> findById(int idTheLoai);

}

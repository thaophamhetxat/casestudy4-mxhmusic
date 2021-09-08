package com.codegym.service;

import com.codegym.moduls.DanhGia;
import com.codegym.moduls.TheLoai;

import java.util.Optional;

public interface IDanhGiaService {
    Iterable<DanhGia> findAll();

    Optional<DanhGia> findById(int idDanhGia);
}

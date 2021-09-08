package com.codegym.service;

import com.codegym.moduls.DanhGia;

import java.util.Optional;

public class DanhGiaService implements IDanhGiaService{
    @Override
    public Iterable<DanhGia> findAll() {
        return null;
    }

    @Override
    public Optional<DanhGia> findById(int idDanhGia) {
        return Optional.empty();
    }
}

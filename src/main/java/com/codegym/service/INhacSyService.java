package com.codegym.service;

import com.codegym.moduls.NhacSy;
import com.codegym.moduls.TheLoai;

import java.util.Optional;

public interface INhacSyService {
    Iterable<NhacSy> findAll();

    Optional<NhacSy> findById(int idNhacSy);
}

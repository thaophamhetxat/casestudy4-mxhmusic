package com.codegym.service;

import com.codegym.moduls.TheLoai;
import com.codegym.moduls.YeuThich;

import java.util.Optional;

public interface IYeuThichService {
    Iterable<YeuThich> findAll();

    Optional<YeuThich> findById(int idYeuThich);
}

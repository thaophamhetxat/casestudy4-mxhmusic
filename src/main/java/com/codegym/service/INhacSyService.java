package com.codegym.service;

import com.codegym.moduls.BlogMusic;
import com.codegym.moduls.NhacSy;
import com.codegym.moduls.TheLoai;
import com.codegym.repository.INhacSyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface INhacSyService {

    Iterable<NhacSy> findAll();
    Page<NhacSy> findAll(Pageable pageable);
    Optional<NhacSy> findById(int idNhacSy);
}

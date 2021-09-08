package com.codegym.service;

import com.codegym.moduls.BlogMusic;
import com.codegym.moduls.CaSy;
import com.codegym.moduls.TheLoai;
import com.codegym.repository.ICaSyRepo;
import com.codegym.repository.ITheLoaiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICaSyService {
    Iterable<CaSy> findAll();
    Page<CaSy> findAll(Pageable pageable);
    Optional<CaSy> findById(int idCaSy);

}

package com.codegym.service;

import com.codegym.moduls.CaSy;
import com.codegym.moduls.TheLoai;
import com.codegym.repository.ICaSyRepo;
import com.codegym.repository.ITheLoaiRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public interface ICaSyService {
    Iterable<CaSy> findAll();

    Optional<CaSy> findById(int idCaSy);

}

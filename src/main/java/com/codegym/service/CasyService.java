package com.codegym.service;

import com.codegym.moduls.CaSy;
import com.codegym.repository.ICaSyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CasyService implements ICaSyService {
    @Autowired
    ICaSyRepo iCaSyRepo;

    @Override
    public Iterable<CaSy> findAll() {
        return iCaSyRepo.findAll();
    }

    @Override
    public Page<CaSy> findAll(Pageable pageable) {
        return iCaSyRepo.findAll(pageable);
    }

    @Override
    public Optional<CaSy> findById(int idCaSy) {
        return iCaSyRepo.findById(idCaSy);
    }
}

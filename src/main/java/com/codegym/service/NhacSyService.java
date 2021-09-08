package com.codegym.service;

import com.codegym.moduls.NhacSy;
import com.codegym.repository.INhacSyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NhacSyService implements INhacSyService {
    @Autowired
    INhacSyRepo iNhacSyRepo;

    @Override
    public Iterable<NhacSy> findAll() {
        return iNhacSyRepo.findAll();
    }

    @Override
    public Page<NhacSy> findAll(Pageable pageable) {
        return iNhacSyRepo.findAll(pageable);
    }

    @Override
    public Optional<NhacSy> findById(int idNhacSy) {
        return iNhacSyRepo.findById(idNhacSy);
    }

    @Override
    public NhacSy save(NhacSy nhacSy) {
        return iNhacSyRepo.save(nhacSy);
    }

    @Override
    public void delete(NhacSy nhacSy) {
        iNhacSyRepo.delete(nhacSy);
    }

    @Override
    public void edit(NhacSy nhacSy) {
        iNhacSyRepo.save(nhacSy);
    }
}

package com.codegym.service;

import com.codegym.moduls.NhacSy;

import java.util.Optional;

public class NhacSyService implements INhacSyService{
    @Override
    public Iterable<NhacSy> findAll() {
        return null;
    }

    @Override
    public Optional<NhacSy> findById(int idNhacSy) {
        return Optional.empty();
    }
}

package com.codegym.service;

import com.codegym.moduls.CaSy;

import java.util.Optional;

public class CasyService implements ICaSyService{

    @Override
    public Iterable<CaSy> findAll() {
        return null;
    }

    @Override
    public Optional<CaSy> findById(int idCaSy) {
        return Optional.empty();
    }
}

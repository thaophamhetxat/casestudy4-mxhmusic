package com.codegym.service;

import com.codegym.moduls.Role;

import java.util.Optional;

public interface IRoleService {
    Iterable<Role> findAll();

    Optional<Role> findById(int idRole);
}

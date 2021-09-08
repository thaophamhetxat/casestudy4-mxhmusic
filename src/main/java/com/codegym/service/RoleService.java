package com.codegym.service;

import com.codegym.moduls.Role;
import org.springframework.beans.factory.annotation.Autowired;
import com.codegym.repository.IRoleRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Transactional
public class RoleService implements IRoleService{
@Autowired
    IRoleRepo iRoleRepo;
    @Override
    public Iterable<Role> findAll() {
        return iRoleRepo.findAll();
    }

    @Override
    public Optional<Role> findById(int idRole) {
        return iRoleRepo.findById(idRole);
    }
}

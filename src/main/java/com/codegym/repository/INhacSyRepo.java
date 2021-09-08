package com.codegym.repository;

import com.codegym.moduls.CaSy;
import com.codegym.moduls.DanhGia;
import org.springframework.data.repository.CrudRepository;

public interface INhacSyRepo extends CrudRepository<DanhGia,Integer> {
}

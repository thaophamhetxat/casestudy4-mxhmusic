package com.codegym.repository;

import com.codegym.moduls.CaSy;
import com.codegym.moduls.DanhGia;
import com.codegym.moduls.NhacSy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface INhacSyRepo extends PagingAndSortingRepository<NhacSy,Integer> {
}

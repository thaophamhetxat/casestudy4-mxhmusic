package com.codegym.repository;

import com.codegym.moduls.CaSy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICaSyRepo extends PagingAndSortingRepository<CaSy,Integer> {
}

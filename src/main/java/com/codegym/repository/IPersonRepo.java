package com.codegym.repository;

import com.codegym.moduls.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.ArrayList;

public interface IPersonRepo extends PagingAndSortingRepository<Person, Integer> {

   ArrayList<Person> findByUserNameContaining(String userName);

   Person findByUserName(String userName);



}

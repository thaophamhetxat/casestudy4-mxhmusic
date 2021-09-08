package com.codegym.repository;

import com.codegym.moduls.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IPersonRepo extends PagingAndSortingRepository<Person, Integer> {
    Person findByUserName(String userName);


}

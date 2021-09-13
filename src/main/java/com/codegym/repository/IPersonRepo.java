package com.codegym.repository;

import com.codegym.moduls.BlogMusic;
import com.codegym.moduls.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface IPersonRepo extends PagingAndSortingRepository<Person, Integer> {
    Person findByUserName(String userName);

    ArrayList<Person> findByUserNameContaining(String userName);

    @Query(value = "select c from Person c where c.userName like concat('%',:userName,'%')")
    ArrayList<Person> findAllByUserName(@Param("userName") String userName);
}

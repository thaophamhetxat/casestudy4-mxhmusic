package com.codegym.service;

import com.codegym.moduls.BlogMusic;
import com.codegym.moduls.Person;

import java.util.ArrayList;
import java.util.Optional;

public interface IPersonService {
    Iterable<Person> findAllPerson();

    Optional<Person> findByIdPerson(int idPerson);

    Person savePerson(Person person);

    void removePerson(int idPerson);


    ArrayList<Person> findAllByNameAdmin();
    ArrayList<Person> findAllByNamePerson();
    ArrayList<Person> findAllByUserName(String userName);

    void  register(Person person);
}

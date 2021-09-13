package com.codegym.service;

import com.codegym.moduls.Person;

import java.util.ArrayList;

public interface IPersonService {
    Iterable<Person> findAllPerson();

   Person findByIdPerson(int idPerson);

    Person savePerson(Person person);

    void removePerson(int idPerson);


    ArrayList<Person> findAllByNameAdmin();
    ArrayList<Person> findAllByNamePerson();
   ArrayList<Person> findByUserNameContaining(String userName);
   void  register(Person person);
}

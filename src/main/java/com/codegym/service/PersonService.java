package com.codegym.service;

import com.codegym.moduls.Person;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.codegym.repository.IPersonRepo;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements  IPersonService, UserDetailsService {
    @Autowired
    IPersonRepo iPersonRepo;


    @Override
    public Iterable<Person> findAllPerson() {
        return iPersonRepo.findAll();
    }

    @Override
    public Optional<Person> findByIdPerson(int idPerson) {
        return iPersonRepo.findById(idPerson);
    }

    @Override
    public Person savePerson(Person person) {
        return iPersonRepo.save(person);
    }

    @Override
    public void removePerson(int idPerson) {
        iPersonRepo.deleteById(idPerson);
    }



    @Autowired
    EntityManager entityManager;
    @Override
    public ArrayList<Person> findAllByNameAdmin() {

        String queryStr = "select  p  from Person p where p.role.nameRole like '%admin%'";
        TypedQuery<Person> query = entityManager.createQuery(queryStr, Person.class);
        return (ArrayList<Person>) query.getResultList();
    }



    @Override
    public ArrayList<Person> findAllByNamePerson() {
        String queryStr = "select p from Person p  where p.role.nameRole like '%user%'";
        TypedQuery<Person> query = entityManager.createQuery(queryStr, Person.class);
        return (ArrayList<Person>) query.getResultList();
    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Person user = iPersonRepo.findByUserName(userName);
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(user.getRole());

        UserDetails userDetails = new User(
                user.getUserName(),
                user.getPassWord(),
                authorities
        );

        return userDetails ;
    }
}

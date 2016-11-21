package com.bukaczewski.service;

import com.bukaczewski.model.entity.Person;
import com.bukaczewski.model.repository.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonDAO personDAO;

    @Transactional
    public void createPerson(Person p) {
        this.personDAO.createPerson(p);
    }

    @Transactional
    public void updatePerson(Person p) {
        this.personDAO.updatePerson(p);
    }

    @Transactional
    public List<Person> listPersons() {
        return this.personDAO.listPersons();
    }

    @Transactional
    public Person getPersonById(long id) {
        return this.personDAO.getPersonById(id);
    }

    @Transactional
    public void deletePerson(long id) { this.personDAO.deletePerson(id); }
}

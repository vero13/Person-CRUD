package com.bukaczewski.model.repository;

import com.bukaczewski.model.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void createPerson(Person p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
    }

    public void updatePerson(Person p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
    }

    public List listPersons() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from Person").list();
    }

    public Person getPersonById(long id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(Person.class, id);
    }

    public void deletePerson(long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Person person = this.getPersonById(id);
        if(null != person){
            session.delete(person);
        }
    }
}

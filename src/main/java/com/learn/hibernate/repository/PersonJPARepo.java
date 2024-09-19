package com.learn.hibernate.repository;

import com.learn.hibernate.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class PersonJPARepo {
    @PersistenceContext
    EntityManager entityManager;

    public List<Person> findAll() {
        return entityManager.createNamedQuery("get_all_persons", Person.class)
                .getResultList();
    }

    public Person findById(Long id) {
        return entityManager.find(Person.class, id);
    }

    public Person findByName(String name) {
        String jpql = "SELECT p FROM Person p WHERE p.name = :name";
        return entityManager.createQuery(jpql, Person.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    public Person insert(Person person) {
        return entityManager.merge(person);
    }

    public Person update(Person person) {
        return entityManager.merge(person);
    }

    public void deleteById(Long id) {
        Person person = findById(id);
        entityManager.remove(person);
    }
}

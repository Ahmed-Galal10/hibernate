package com.learn.hibernate.model.jpa;

import com.learn.hibernate.model.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class PersonJPARepo {
    @PersistenceContext
    EntityManager entityManager;

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

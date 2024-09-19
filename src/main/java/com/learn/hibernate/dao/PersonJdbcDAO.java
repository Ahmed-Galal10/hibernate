package com.learn.hibernate.dao;

import com.learn.hibernate.entity.Person;
import com.learn.hibernate.mapper.PersonRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Repository
public class PersonJdbcDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Person> findAll() {
        String queryString = "SELECT * FROM person";
        return jdbcTemplate.query(queryString, new BeanPropertyRowMapper<>(Person.class));
    }

    public Person findById(Integer id) {
        String queryString = "SELECT * FROM person WHERE id=?";
        return jdbcTemplate.queryForObject(queryString, new PersonRowMapper(), id);
    }

    public List<Person> findByName(String name) {
        String queryString = "SELECT * FROM person WHERE name=?";
        return jdbcTemplate.query(queryString, new BeanPropertyRowMapper<>(Person.class), name);
    }

    public int deleteById(Integer id) {
        String queryString = "delete from person where id=?";
        return jdbcTemplate.update(queryString, id);
    }

    public int insert(Person person) {
        String queryString = "insert into person (id, name, location, birth_date) values (?, ?, ?, ?)";
        return jdbcTemplate.update(queryString, person.getId(), person.getName(), person.getLocation(), new Date(person.getBirthDate().getTime()));
    }

    public int update(Person person) {
        String queryString = "update person set name=? ,location=?, birth_date=? where id=?";
        return jdbcTemplate.update(queryString, person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()), person.getId());
    }
}

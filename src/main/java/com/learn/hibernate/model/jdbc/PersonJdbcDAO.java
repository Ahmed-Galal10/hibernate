package com.learn.hibernate.model.jdbc;

import com.learn.hibernate.model.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonJdbcDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Person> findAll() {
        String queryString = "SELECT * FROM person";
        return jdbcTemplate.query(queryString, new BeanPropertyRowMapper<>(Person.class));
    }
}

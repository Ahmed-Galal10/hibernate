package com.learn.hibernate.util;

import com.learn.hibernate.model.entity.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRowMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person person = new Person();
        person.setId(rs.getLong("id"));
        person.setName(rs.getString("name"));
        person.setLocation(rs.getString("location"));
        person.setBirthDate(rs.getTimestamp("birth_date"));

        return person;
    }
}

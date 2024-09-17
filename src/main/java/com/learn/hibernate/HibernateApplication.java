package com.learn.hibernate;

import com.learn.hibernate.model.jdbc.PersonJdbcDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class HibernateApplication implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonJdbcDAO personJdbcDAO;

    public static void main(String[] args) {
        SpringApplication.run(HibernateApplication.class, args);
    }

    @Override
    public void run(String... args) {
        logger.info("\nAll Persons -> {}", personJdbcDAO.findAll());
        logger.info("\nPerson with id 1001 -> {}", personJdbcDAO.findById(1001));
        logger.info("\nPersons with name 'Ahmed' -> {}", personJdbcDAO.findByName("Ahmed"));
    }
}

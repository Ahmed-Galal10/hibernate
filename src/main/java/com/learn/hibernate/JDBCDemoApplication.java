package com.learn.hibernate;

import com.learn.hibernate.entity.Person;
import com.learn.hibernate.dao.PersonJdbcDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import java.util.Date;


//@SpringBootApplication
public class JDBCDemoApplication implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

//    @Autowired
    PersonJdbcDAO personJdbcDAO;

    public static void main(String[] args) {
        SpringApplication.run(JDBCDemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        logger.info("\nAll Persons -> {}", personJdbcDAO.findAll());
//        logger.info("\nPerson with id 1001 -> {}", personJdbcDAO.findById(1001));
        logger.info("\nPersons with name 'Ahmed' -> {}", personJdbcDAO.findByName("Ahmed"));
//        logger.info("\nDelete Person with id '1002' -> {}", personJdbcDAO.deleteById(1002));

        Person person1 = new Person("Ronaldo", "Portugal", new Date());
        Person person2 = new Person("Galaaalz", "Alex", new Date());
        logger.info("\nInsert new Person -> {}", personJdbcDAO.insert(person1));
        logger.info("\nUpdate Person -> {}", personJdbcDAO.update(person2));
    }
}

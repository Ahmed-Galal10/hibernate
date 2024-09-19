package com.learn.hibernate;

import com.learn.hibernate.entity.Person;
import com.learn.hibernate.repository.PersonJPARepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;


@SpringBootApplication
public class JPADemoApplication implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonJPARepo personJPARepo;

    public static void main(String[] args) {
        SpringApplication.run(JPADemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        logger.info("\\nPerson with specific id -> {}", personJPARepo.findById(1001L));

        Person person1 = new Person("Ronaldo", "Portugal", new Date());
        logger.info("\nInsert new Person -> {}", personJPARepo.insert(person1));

        Person person2 = personJPARepo.findByName("Galal");
        person2.setLocation("Shoubra");
        logger.info("\nUpdate Person -> {}", personJPARepo.update(person2));

        personJPARepo.deleteById(1001L);

        logger.info("\\nRetrieve all persons -> {}", personJPARepo.findAll());
    }
}

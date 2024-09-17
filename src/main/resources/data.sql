CREATE TABLE person
(
    id integer not null,
    name varchar(255) not null,
    location varchar(255),
    birth_date timestamp,
    primary key (id)
);

INSERT INTO person (ID, NAME, LOCATION, BIRTH_DATE) VALUES (1001, 'Ahmed', 'Cairo', NOW());
INSERT INTO person (ID, NAME, LOCATION, BIRTH_DATE) VALUES (1002, 'Galal', 'Giza', NOW());
INSERT INTO person (ID, NAME, LOCATION, BIRTH_DATE) VALUES (1003, 'Ahmed', 'Madrid', CURRENT_TIMESTAMP);

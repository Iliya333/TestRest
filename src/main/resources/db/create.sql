create table employee
(
    id int not null PRIMARY KEY,
    department_id int not null,
    name VARCHAR(255) not null,
    surname varchar(255) not null,
    patronymic varchar(255) not null,
    birthday TIMESTAMP not null,
    salary int not null,
    FOREIGN KEY (department_id) REFERENCES department (id) ON DELETE CASCADE
);



CREATE TABLE department
(
    id          int not null PRIMARY KEY,
    name        VARCHAR(255) NOT NULL
);


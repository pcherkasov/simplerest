DROP TABLE IF EXISTS employee;

CREATE TABLE employee
(
  employee_id serial PRIMARY KEY NOT NULL,
  first_name varchar(100) NOT NULL,
  last_name varchar(100),
  department_id int,
  job_title varchar(200),
  gender varchar(10) NOT NULL,
  date_of_birdth timestamp
);
CREATE UNIQUE INDEX employee_emloyee_id_uindex ON employee (emloyee_id);

INSERT INTO employee
    (first_name, gender)
          VALUES ('Ivan', 'MALE'),
                 ('Lena', 'FEMALE'),
                 ('Oleg', 'MALE'),
                 ('Ekaterina', 'FEMALE'),
                 ('Oksana', 'FEMALE'),
                 ('John', 'MALE'),
                 ('Robert', 'MALE'),
                 ('Tanya', 'FEMALE'),
                 ('Kris', 'MALE');
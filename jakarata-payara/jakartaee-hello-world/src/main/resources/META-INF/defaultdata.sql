CREATE TABLE IF NOT EXISTS company
(
    id   INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name TEXT NOT NULL
);

CREATE TYPE gender AS ENUM ('NA', 'FEMALE', 'MALE', 'OTHER');

CREATE TABLE IF NOT EXISTS employee
(
    id             INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    first_name     TEXT   NOT NULL,
    last_name      TEXT   NOT NULL,
    hire_date      DATE   NOT NULL,
    gender         gender NOT NULL,
    favorite_color TEXT
);

INSERT INTO company (name)
VALUES ('Company 1');
INSERT INTO company (name)
VALUES ('Company 2');

INSERT INTO employee (first_name, last_name, hire_date, gender)
VALUES ('Alice', 'Smith', '2020-01-01', 'FEMALE');
INSERT INTO employee (first_name, last_name, hire_date, gender)
VALUES ('Bruce', 'Smith', '2022-01-01', 'MALE');
INSERT INTO employee (first_name, last_name, hire_date, gender)
VALUES ('Kenneth', 'Smith', '2023-01-01', 'NA');


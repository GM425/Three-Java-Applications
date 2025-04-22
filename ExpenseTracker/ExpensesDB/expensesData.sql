CREATE DATABASE IF NOT EXISTS EXPENSES_DB;

USE EXPENSES_DB;

CREATE TABLE IF NOT EXISTS expenses_db (
    id INT NOT NULL AUTO_INCREMENT,
    category VARCHAR(50),
    date VARCHAR(50),
    description VARCHAR(80)
    amount FLOAT(10,2),
    PRIMARY KEY (id)
);

INSERT INTO expenses_db (category, date, description, amount) VALUES ("skol@gmail.com","test","test", 0);
-- GRANT ALL PRIVILEGES ON employee_data.* TO 'user' IDENTIFIED BY 'user';
-- FLUSH PRIVILEGES;

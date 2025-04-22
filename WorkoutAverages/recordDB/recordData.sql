CREATE DATABASE IF NOT EXISTS RECORD_DB;

USE RECORD_DB;

CREATE TABLE IF NOT EXISTS record_db (
    id INT NOT NULL AUTO_INCREMENT,
    userId VARCHAR(50),
    date VARCHAR(50),
    activity VARCHAR(50),
    duration INT,
    amount INT,
    PRIMARY KEY (id)
);

INSERT INTO record_db (userId, date, activity, duration, amount) VALUES ("dkjji3i3", "dkjji3i3", "dkjji3i3", 0, 0);
-- GRANT ALL PRIVILEGES ON employee_data.* TO 'user' IDENTIFIED BY 'user';
-- FLUSH PRIVILEGES;

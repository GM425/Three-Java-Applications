CREATE DATABASE IF NOT EXISTS APPOINTMENT_DB;

USE APPOINTMENT_DB;

CREATE TABLE IF NOT EXISTS appointment_db (
    id INT NOT NULL AUTO_INCREMENT,
    userId VARCHAR(50),
    date VARCHAR(50),
    doctor VARCHAR(50),
    specialty VARCHAR(50),
    preventative BOOLEAN,
    duration FLOAT,
    description VARCHAR(50),
    PRIMARY KEY (id)
);

-- INSERT INTO appointment_db (userId, date, doctor, specialty, preventative, duration, description) VALUES ("dkjji3i3", "dkjji3i3", "dkjji3i3", 0, 0);
-- GRANT ALL PRIVILEGES ON employee_data.* TO 'user' IDENTIFIED BY 'user';
-- FLUSH PRIVILEGES;

CREATE DATABASE IF NOT EXISTS USER_DB;

USE USER_DB;

CREATE TABLE IF NOT EXISTS user_db (
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(50),
    password VARCHAR(50),
    PRIMARY KEY (id)
);

INSERT INTO user_db (username, password) VALUES ("dkjji3i3", "dkjji3i3");
-- GRANT ALL PRIVILEGES ON employee_data.* TO 'user' IDENTIFIED BY 'user';
-- FLUSH PRIVILEGES;

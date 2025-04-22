CREATE DATABASE IF NOT EXISTS USER_DB;

USE USER_DB;

CREATE TABLE IF NOT EXISTS user_db (
    id BIGINT NOT NULL AUTO_INCREMENT,
    username VARCHAR(50),
    password VARCHAR(200),
    email VARCHAR(50)
    enabled boolean NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS authorities_db (
    id BIGINT NOT NULL AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    FOREIGN KEY(username) REFERENCES user_db(username)
    PRIMARY KEY (id)
);

INSERT INTO user_db (username, password, enabled) VALUES ("john", "29003@3#bb", true);
INSERT INTO authorities_db (username, authority) VALUES ("john", "ROLE_USER")
-- GRANT ALL PRIVILEGES ON employee_data.* TO 'user' IDENTIFIED BY 'user';
-- FLUSH PRIVILEGES;

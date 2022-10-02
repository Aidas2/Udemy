CREATE DATABASE 18_trigger_demo;
use 18_trigger_demo;

CREATE TABLE users (
    username VARCHAR(100),
    age INT
);

INSERT INTO users(username, age) VALUES ("bobby", 23);
SELECT * FROM users;

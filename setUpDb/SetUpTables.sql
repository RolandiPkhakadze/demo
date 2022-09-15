create database db;
use db;
drop table if exists users;
CREATE TABLE users(
    id int  AUTO_INCREMENT PRIMARY KEY,
    username varchar(32) unique,
    first_name varchar(32),
    last_name varchar(32),
    password varchar(32),
    profession varchar(32),
    e_mail varchar(32)
)
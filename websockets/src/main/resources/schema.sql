-- create schema test;

drop table if exists events;

create table events(
    id int auto_increment primary key,
    message varchar(100)
);
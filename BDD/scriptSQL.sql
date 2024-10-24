create database todoList;

use todoList;


create table lista(
	id int primary key auto_increment,
	titulo varchar(255),
    descricao varchar(300),
    realizado bit(1),
    data date
);



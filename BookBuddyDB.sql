drop database if exists BookBuddy;
create database BookBuddy;
use BookBuddy;
SET GLOBAL max_allowed_packet = 1024*1024*1024*28;

create table Studenti
(
email varchar(50) primary key,
nome_utente varchar(20) not null,
pass varchar(20) not null,
admin boolean not null
);

create table MaterialeDidattico
(
id int auto_increment not null primary key,
autore varchar(100) not null,
nome varchar(100) not null,
data_pubblicazione date,
corso_di_laurea varchar(60) not null,
materia varchar(30) not null,
valutazione double,
appunti boolean not null,
fileintero longblob,
copertina varchar(1000)
);

create table Ottiene
(
email varchar(50) not null,
id int,
preferito boolean not null,
primary key (email, id),
foreign key (email) references Studenti(email),
foreign key (id) references MaterialeDidattico(id)
);

insert into Studenti values
("c.iommazzo@studenti.unisa.it","camilla","password123",1),
("s.donniacuo1@studenti.unisa.it","siria","password123",1),
("e.ragozzini@studenti.unisa.it","ema","password123",1),
("g.salzillo2@studenti.unisa.it","peppe","password123",0),
("utente@email.com","utente1","password123",0);




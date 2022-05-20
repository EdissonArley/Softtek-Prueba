CREATE DATABASE softtek
use softtek

CREATE TABLE brand (
id            int not null auto_increment,
description    varchar(45) not null,

constraint brand_pk primary key (id) 
);

CREATE TABLE status (
id            int not null auto_increment,
description    varchar(45) not null,

constraint status_pk primary key (id) 
);

CREATE TABLE user (
id            int not null auto_increment,
userName      varchar(45) not null,
password      varchar(45) not null,
rol           ENUM ('administrador', 'operario'),

constraint user_pk primary key (id) 
);

CREATE TABLE person (
id            int not null auto_increment,
firstName      varchar(45) not null,
lastname      varchar(45) not null,
dni           varchar(45) not null,
user_id       int not null,

constraint person_pk primary key (id),
constraint person_fk1 foreign key (user_id) references user (id)
);

CREATE TABLE provider (
id                           int not null auto_increment,
business_name                varchar(75) not null,
business_identification      varchar(75) not null,
adrees                       varchar(75) not null,
email                        varchar(75) not null,

constraint provider_pk primary key (id) 
);

CREATE TABLE vehicle (
id            int not null auto_increment,
plate         varchar(6) not null,
model         int not null,
brand_id      int not null,
person_id     int not null,
status_id     int not null,
provider_id   int not null,

constraint vehicle_pk primary key (id),
constraint vehicle_fk1 foreign key (brand_id) references brand (id),
constraint vehicle_fk2 foreign key (person_id) references person (id),
constraint vehicle_fk3 foreign key (status_id) references status (id),
constraint vehicle_fk4 foreign key (provider_id) references provider (id)
);

INSERT INTO `softtek`.`brand` (`id`, `description`) VALUES ('1', 'Mazda');
INSERT INTO `softtek`.`brand` (`id`, `description`) VALUES ('2', 'Chevrolet');
INSERT INTO `softtek`.`status` (`id`, `description`) VALUES ('1', 'Activo');
INSERT INTO `softtek`.`status` (`id`, `description`) VALUES ('2', 'Inactivo');


CREATE DATABASE `bd_hibernatel` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `bd_hibernatel`;

CREATE TABLE `mascota` (
`id_mascota` int not null auto_increment,
`nombre` varchar(45) not null,
`raza` varchar(45) not null,
`color` varchar(45) not null,
`sexo` varchar(45) not null,
PRIMARY KEY (`id_mascota`)
) ENGINE=InnoDB auto_increment=6 default charset=utf8mb4;

CREATE TABLE persona(
id_persona int not null,
nombre_persona varchar(45) default null,
profesion_persona varchar(45) default null,
telefono_persona varchar(45) default null,
tipo_persona int not null,
nacimiento_id int not null,
PRIMARY KEY (id_persona)
);

CREATE TABLE nacimiento(
id_nacimiento int not null auto_increment,
ciudad_nacimiento varchar (45) default null,
departamento_nacimiento varchar (45) default null,
fecha_nacimiento date default null,
pais_nacimiento varchar (45) default null,
PRIMARY KEY (id_nacimiento)
);

ALTER TABLE persona ADD INDEX fk_persona_nacimiento (nacimiento_id ASC);
;
ALTER TABLE persona ADD CONSTRAINT fk_persona_nacimiento foreign key (nacimiento_id) references nacimiento (id_nacimiento)
on delete no action
on update no action;

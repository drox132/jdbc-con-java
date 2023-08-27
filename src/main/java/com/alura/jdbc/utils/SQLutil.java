package com.alura.jdbc.utils;

public class SQLutil {

	/*
	 * 
SELECT VERSION();
SHOW DATABASES;

/*CREATE DATABASE control_de_stock;

USE CONTROL_DE_STOCK;


CREATE TABLE tbproducto(
ID_PRODUCTO INT AUTO_INCREMENT,
NOMBRE varchar(50) NOT NULL,
DESCRIPCION varchar(100),
CANTIDAD INT ,
PRIMARY KEY (ID_PRODUCTO)
);


/*INSERT INTO tbproducto(NOMBRE, DESCRIPCION,CANTIDAD) VALUES();
/*INSERT INTO tbproducto(NOMBRE, DESCRIPCION,CANTIDAD) VALUES();

SELECT * FROM TBPRODUCTO;

CREATE TABLE CATEGORIA(
ID INT AUTO_INCREMENT,
NOMBRE VARCHAR (50) NOT NULL,
PRIMARY KEY (ID) 
)ENGINE = InnoDB

SELECT * FROM CATEGORIA;
INSERT INTO CATEGORIA (NOMBRE) 
VALUES ("COCINA"),
("ELECTRONICOS"),
("VESTIR"),
("TECNOLOGIA");


ALTER TABLE TBPRODUCTO modify CATEGORIA_ID INT NULL;

ALTER TABLE TBPRODUCTO ADD FOREIGN KEY (CATEGORIA_ID) REFERENCES CATEGORIA(ID);
UPDATE TBPRODUCTO 
SET CATEGORIA_ID =1
WHERE ID_PRODUCTO BETWEEN 1 AND 8;

UPDATE TBPRODUCTO 
SET CATEGORIA_ID =2
WHERE ID_PRODUCTO IN(11,12,13);

UPDATE TBPRODUCTO 
SET CATEGORIA_ID =4
WHERE ID_PRODUCTO IN(14,29);

UPDATE TBPRODUCTO 
SET CATEGORIA_ID =3
WHERE ID_PRODUCTO IN(16,18);

SELECT * FROM TBPRODUCTO;

/*QUERY PARA EL REPORTE
SELECT C.ID, C.NOMBRE, P.ID_PRODUCTO, P.NOMBRE, P.DESCRIPCION, P.CANTIDAD 
FROM TBPRODUCTO P
INNER JOIN CATEGORIA C ON C.ID = P.CATEGORIA_ID;

SELECT * FROM TBPRODUCTO WHERE CATEGORIA_ID=1
	 * */
}

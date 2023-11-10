DROP TABLE IF EXISTS cajas;
DROP table IF EXISTS almacen;


CREATE TABLE almacen (
  codigo int NOT NULL AUTO_INCREMENT,
  lugar varchar(250) DEFAULT NULL,
  capacidad int DEFAULT NULL,
  PRIMARY KEY (codigo)
);

CREATE TABLE cajas (
  num_Referencia varchar(5) DEFAULT NULL,
  contenido varchar(250) DEFAULT NULL,
  valor int DEFAULT NULL,
  almacen  int DEFAULT NULL,
  PRIMARY KEY (num_Referencia),
  FOREIGN KEY (almacen) REFERENCES almacen (codigo)
);


insert into almacen (lugar, capacidad)values('Tarragona', 9000);
insert into almacen (lugar, capacidad)values('Reus', 6000);
insert into almacen (lugar, capacidad)values('Lleida', 3000);
insert into almacen (lugar, capacidad)values('Barcelona', 2000);
insert into almacen (lugar, capacidad)values('Girona', 1500);

insert into cajas (num_Referencia, contenido, valor, almacen) values ('jhfk','Tuercas',4,1);
insert into cajas (num_Referencia, contenido, valor, almacen) values ('asdfg','Tornillos',5,1);
insert into cajas (num_Referencia, contenido, valor, almacen) values ('qwert','Carteras',14,1);
insert into cajas (num_Referencia, contenido, valor, almacen) values ('zxcvb','Pantalones',49,1);
insert into cajas (num_Referencia, contenido, valor, almacen) values ('mnbvc','Abrigos',58,1);
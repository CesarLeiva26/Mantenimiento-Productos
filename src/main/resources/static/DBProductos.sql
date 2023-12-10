create database DBProductos;

use DBProductos;

create table tbproductos(
idproductos int primary key auto_increment,
nombre varchar(50),
stock int,
precio double
);

insert into tbproductos values (1,'Galletas Morochas', 100, 1.50),
(2, 'Gaseosa Inka Kola', 60, 5.50);

select * from tbproductos;
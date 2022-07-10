
create database autos;

---------------------------------------------------------------------------------------------------------

create table vehiculos (
id serial primary key,
marca varchar(50),
modelo varchar(50),
año int,
cambio varchar(50),
potencia varchar(50),
plazas int,
combustible varchar(50),
cilindrada int,
velocidad_maxima int,
precio int
)


create table categorias (
id serial primary key,
descripcion varchar(50)
)


create table detalle_categoria (
id_vehiculo int not null,
id_categoria int not null,
CONSTRAINT detalle_deposito_pkey PRIMARY KEY (id_vehiculo, id_categoria)
)

ALTER TABLE detalle_categoria
   ADD CONSTRAINT fk_vehiculo
   FOREIGN KEY (id_vehiculo) 
   REFERENCES vehiculos(id);   
  
 ALTER TABLE detalle_categoria
   ADD CONSTRAINT fk_categoria
   FOREIGN KEY (id_categoria) 
   REFERENCES categorias(id);

---------------------------------------------------------------------------------------------------------
  
  INSERT INTO vehiculos (marca,modelo,año,cambio,potencia,plazas,combustible,cilindrada,velocidad_maxima,precio) VALUES
	 ('Audi','A1 Sportback 25',2022,'Manual','95 CV',5,'Gasolina',999,191,30130),
	 ('BMW','i3',2019,'Automatico','170 CV',5,'Corriente eléctrica',0,150,37444),
	 ('Chevrolet','Tahoe 5.3',2022,'Automatico','285 CV',5,'Gasolina',5327,170,74060),
	 ('Jeep','Wrangler Unlimited 2.0',2021,'Automatico secuencial','380 CV',5,'Gasolina y corriente eléctrica',1995,177,80850),
	 ('Scania','540 S',2022,'Automatico','530 CV',3,'Gasolina',0,90,0),
	 ('Volvo','FH16 700',2022,'Automatico','700 CV',3,'Gasolina',163,90,240000),
	 ('Kawasaki ','Z900',2022,'Semi-automatico','125 CV',1,'Gasolina',948,250,10199),
	 ('Yamaha ','Tricity 125:',2022,'Automatico','12 CV',1,'Gasolina',125,110,4249),
	 ('CAN-AM','Traxter',2022,'Automatico','82 CV',3,'Gasolina',976,60,14683),
	 ('Secway','Snarler AT6 SE',2021,'Automatico','44 CV',1,'Gasolina',567,60,7780);

	
	INSERT INTO public.categorias (descripcion) VALUES ('Auto'),('Camioneta'),('Camion'),('Moto'),('UTV');
	

	INSERT INTO public.detalle_categoria (id_vehiculo,id_categoria)
	values  (1,1), (2,1), (3,2), (4,2), (5,3),
	 		(6,3), (7,4), (8,4), (1,2), (9,5),
	 		(10,5);

	--------------------------------------------------------------------------------------------------------- 










create table videojuego (
    id int primary key auto_increment,
    nombre varchar (200) not null,
    descripcion varchar(3000),
    imagen_url varchar (500)
);

create table distribuidor
(
    id int primary key auto_increment,
    nombre varchar (200) not null,
    sitio_web varchar (500)
);

insert into distribuidor
(id,    nombre,                         sitio_web) values
(1,     '2K',                           'https://2k.com'),
(2,     'Focus Home Interactive',       'https://www.focus-home.com'),
(3,     'Thekla',                       null),
(4,     'Number One',                   null),
(5,     '505 Games',                    'https://505games.com'),
(6,     'Unknown Worlds Entertainment', 'https://unknownworlds.com'),
(7,     'Campo Santo',                  'https://www.camposanto.com');

alter table videojuego add column distribuidor_id int, add foreign key (distribuidor_id) references distribuidor (id);

update videojuego set distribuidor_id = 1 where id in (1, 5);
update videojuego set distribuidor_id = 2 where id in (2);
update videojuego set distribuidor_id = 3 where id in (3);
update videojuego set distribuidor_id = 4 where id in (4);
update videojuego set distribuidor_id = 5 where id in (6);
update videojuego set distribuidor_id = 6 where id in (7);
update videojuego set distribuidor_id = 7 where id in (8);

alter table videojuego
modify distribuidor_id int not null;
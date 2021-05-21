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


NSERT INTO `videojuego` (`id`, `nombre`, `descripcion`, `imagen_url`, `distribuidor_id`) VALUES
(1, 'Bioshock Infinite', 'La última gran entrega de la saga Bioshock, ahora en una imperdible ciudad de ensueño entre las nubes.', 'https://cdn.vox-cdn.com/thumbor/I24jyQjEEDBM4AQrGIbaCk4t2gk=/0x0:1080x720/1200x800/filters:focal(0x0:1080x720)/cdn.vox-cdn.com/uploads/chorus_image/image/4674397/bioshock_infinite_delay.0.jpg', 1),
(8, 'Firewatchdd', 'Firewatch es un juego de misterio en primera persona para un jugador que se desarrolla en la selva de Wyoming', 'https://www.mobygames.com/images/covers/l/323028-firewatch-playstation-4-front-cover.jpg', 7),
(9, 'Grand theft auto: San Andreas', 'Grand Theft Auto: San Andreas es un videojuego de acción-aventura de mundo abierto desarrollado por Rockstar North y publicado por Rockstar Games.', 'https://www.caratulas.com/juegos/caratulas/G/Grand_Theft_Auto_San_Andreas-Frontal-PS2.jpg', 8),
(18, 'Resident Evil 4', 'Resident Evil 4, conocido en Japón como Biohazard 4, es un videojuego de disparos en tercera persona del estilo supervivencia y horror', 'https://media.vandal.net/m/36874/resident-evil-4-201683095332_1.jpg', 9),
(30, 'Fifa 21', 'FIFA 20 es un videojuego de simulación de fútbol desarrollado por EA Sports', 'https://depor.com/resizer/NMILM416u_GM5JPhkq_0TuWdtlE=/620x0/smart/filters:format(jpeg):quality(75)/arc-anglerfish-arc2-prod-elcomercio.s3.amazonaws.com/public/GS5Q7JW7ERA37MBWBZSCQGCY5I.jpg', 36),
(32, 'Grand Theft Auto: Vice City', 'Grand Theft Auto: Vice City, es un videojuego de acción-aventura. Es el cuarto título de la serie Grand Theft Auto y el segundo en gráficos 3D.', 'https://image.api.playstation.com/cdn/EP1004/CUSA03546_00/iIZNLXtAvjs6s77Bahs8N6K84EaS0KIK.png?w=440', 8),
(33, 'Grand Theft Auto: Vice City Stories', 'Grand Theft Auto: Vice City Stories es el décimo juego de la saga Grand Theft Auto. Es un videojuego diseñado para la consola PSP y lanzado en PlayStation 2 y PlayStation 3', 'https://i0.wp.com/adxgames.net/wp-content/uploads/2020/02/gta-vice-city-stories-pc-1.jpg?fit=330%2C410&ssl=1', 8),
(388, 'God of War ', 'God of War es una serie de videojuegos en 3ª. persona creada por SCE Santa Monica Studio', 'https://images-na.ssl-images-amazon.com/images/I/7195fJHhQ%2BL._AC_SX466_.jpg', 34);

--

INSERT INTO `distribuidor` (`id`, `nombre`, `sitio_web`) VALUES
(1, '2K', 'https://2k.com'),
(5, '505 Games', 'https://505games.com'),
(7, 'Campo Santo', 'https://www.camposanto.com'),
(8, 'Rockstar Games', 'https://www.rockstargames.com/mx/'),
(9, 'Capcom', 'https://www.capcom.com/us/'),
(34, 'Santa Monica Studio', 'https://sms.playstation.com/'),
(36, 'EA Sports', 'https://www.ea.com/es-mx');

INSERT INTO compradores (dni_compradores, apellido_compradores, nombre_compradores, correo_electronico_comprador, pase_de_oro)
VALUES
  ('12345678', 'Pérez', 'Juan', 'juan.perez@example.com', true),
  ('87654321', 'González', 'María', 'maria.gonzalez@example.com', false),
  ('98765432', 'Rodríguez', 'Pedro', 'pedro.rodriguez@example.com', true),
  ('56789012', 'Martínez', 'Ana', 'ana.martinez@example.com', true),
  ('34567890', 'López', 'Luis', 'luis.lopez@example.com', false),
  ('90876543', 'Hernández', 'Laura', 'laura.hernandez@example.com', true),
  ('67890123', 'Gómez', 'Carlos', 'carlos.gomez@example.com', false),
  ('23456789', 'Torres', 'Sofía', 'sofia.torres@example.com', true),
  ('98765432', 'Silva', 'Diego', 'diego.silva@example.com', false),
  ('87654321', 'Romero', 'Lucía', 'lucia.romero@example.com', true),
  ('12345678', 'Pérez', 'Miguel', 'miguel.perez@example.com', true),
  ('56789012', 'González', 'Carolina', 'carolina.gonzalez@example.com', false),
  ('90876543', 'Sánchez', 'Andrés', 'andres.sanchez@example.com', true),
  ('34567890', 'Martínez', 'Paula', 'paula.martinez@example.com', true),
  ('23456789', 'López', 'Gabriel', 'gabriel.lopez@example.com', false),
  ('98765432', 'Hernández', 'Valentina', 'valentina.hernandez@example.com', true),
  ('67890123', 'Gómez', 'Javier', 'javier.gomez@example.com', false),
  ('87654321', 'Torres', 'María', 'maria.torres@example.com', true),
  ('56789012', 'Silva', 'Matías', 'matias.silva@example.com', false),
  ('12345678', 'Romero', 'Florencia', 'florencia.romero@example.com', true),
  ('34567890', 'Pérez', 'Lucas', 'lucas.perez@example.com', true),
  ('90876543', 'González', 'Isabella', 'isabella.gonzalez@example.com', false),
  ('23456789', 'Sánchez', 'Sebastián', 'sebastian.sanchez@example.com', true),
  ('87654321', 'Martínez', 'Catalina', 'catalina.martinez@example.com', false),
  ('98765432', 'López', 'Tomás', 'tomas.lopez@example.com', true),
  ('56789012', 'Hernández', 'Valeria', 'valeria.hernandez@example.com', true),
  ('34567890', 'Gómez', 'Alejandro', 'alejandro.gomez@example.com', false),
  ('90876543', 'Torres', 'Daniela', 'daniela.torres@example.com', true),
  ('23456789', 'Silva', 'Julián', 'julian.silva@example.com', false),
  ('87654321', 'Romero', 'Antonella', 'antonella.romero@example.com', true),
  ('12345678', 'Pérez', 'Francisco', 'francisco.perez@example.com', true),
  ('56789012', 'González', 'Martina', 'martina.gonzalez@example.com', false),
  ('90876543', 'Sánchez', 'Leonardo', 'leonardo.sanchez@example.com', true),
  ('34567890', 'Martínez', 'Agustina', 'agustina.martinez@example.com', true),
  ('23456789', 'López', 'Felipe', 'felipe.lopez@example.com', false),
  ('98765432', 'Hernández', 'Valentino', 'valentino.hernandez@example.com', true),
  ('87654321', 'Gómez', 'Josefina', 'josefina.gomez@example.com', false),
  ('56789012', 'Torres', 'Felipe', 'felipe.torres@example.com', true),
  ('12345678', 'Silva', 'Martina', 'martina.silva@example.com', true),
  ('90876543', 'Romero', 'Mateo', 'mateo.romero@example.com', false),
  ('34567890', 'Pérez', 'Julieta', 'julieta.perez@example.com', true),
  ('23456789', 'González', 'Maximiliano', 'maximiliano.gonzalez@example.com', false),
  ('98765432', 'Martínez', 'Camila', 'camila.martinez@example.com', true),
  ('87654321', 'López', 'Emilia', 'emilia.lopez@example.com', false),
  ('56789012', 'Hernández', 'Joaquín', 'joaquin.hernandez@example.com', true),
  ('12345678', 'Gómez', 'Delfina', 'delfina.gomez@example.com', true),
  ('90876543', 'Torres', 'Jorge', 'jorge.torres@example.com', false),
  ('34567890', 'Silva', 'Antonia', 'antonia.silva@example.com', true),
  ('23456789', 'Romero', 'Luciano', 'luciano.romero@example.com', false),
  ('98765432', 'Pérez', 'Milagros', 'milagros.perez@example.com', true);
INSERT INTO usuarios (nombre_usuario, contrasenia_usuario, rol_usuario)
VALUES
  ('usuario1', 'contrasenia1', 'EMPLEADO_ADMINISTRATIVO'),
  ('usuario2', 'contrasenia2', 'EMPLEADO_JUEGO'),
  ('usuario3', 'contrasenia3', 'EMPLEADO_JUEGO'),
  ('usuario4', 'contrasenia4', 'EMPLEADO_JUEGO'),
  ('usuario5', 'contrasenia5', 'EMPLEADO_JUEGO'),
  ('usuario6', 'contrasenia6', 'EMPLEADO_JUEGO'),
  ('usuario7', 'contrasenia7', 'EMPLEADO_JUEGO'),
  ('usuario8', 'contrasenia8', 'EMPLEADO_JUEGO'),
  ('usuario9', 'contrasenia9', 'EMPLEADO_JUEGO'),
  ('usuario10', 'contrasenia10', 'EMPLEADO_JUEGO'),
  ('usuario11', 'contrasenia11', 'EMPLEADO_JUEGO'),
  ('usuario12', 'contrasenia12', 'EMPLEADO_JUEGO');

INSERT INTO empleados (nombre_empleados, apellido_empleados, dni_empleados, rutas_a_la_fotos, id_usuario)
  VALUES ('Juan', 'Pérez', '12345678', '/ruta/foto1.jpg', 1),
         ('María', 'González', '87654321', '/ruta/foto2.jpg', 2),
         ('Pedro', 'Rodríguez', '98765432', '/ruta/foto3.jpg', 3),
         ('Ana', 'Martínez', '56789012', '/ruta/foto4.jpg', 4),
         ('Luis', 'López', '34567890', '/ruta/foto5.jpg', 5),
         ('Laura', 'Hernández', '90876543', '/ruta/foto6.jpg', 6),
         ('Carlos', 'Gómez', '67890123', '/ruta/foto7.jpg', 7),
         ('Sofía', 'Torres', '23456789', '/ruta/foto8.jpg', 8),
         ('Diego', 'Silva', '98765432', '/ruta/foto9.jpg', 9),
         ('Lucía', 'Romero', '87654321', '/ruta/foto10.jpg', 10),
         ('Miguel', 'Pérez', '12345678', '/ruta/foto11.jpg', 11),
         ('Carolina', 'González', '56789012', '/ruta/foto12.jpg', 12);
INSERT INTO juegos (nombre_juegos, precio_juegos, cobro_pase_oro, juegos_activos, descripciones, rutas_a_las_fotos)
VALUES ('Montaña Rusa', 10, true, true, 'Descripción Montaña Rusa', 'https://media.istockphoto.com/id/1404372377/es/foto/monta%C3%B1a-rusa-emocionante-y-divertida-atracci%C3%B3n-en-la-v%C3%ADa-del-ferrocarril-en-el-parque-tem%C3%A1tico.webp?b=1&s=170667a&w=0&k=20&c=AdqDRow_FRjleudXub_n8rHDBdMEu0QfRNDuHbdUmfk='),
       ('Carrusel', 5, false, false, 'Descripción Carrusel', 'https://images.unsplash.com/photo-1577774438656-768f1e5d9ed6?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8Y2FycnVzZWx8ZW58MHwwfDB8fHww&auto=format&fit=crop&w=500&q=60'),
       ('Tobogán Acuático', 8, true, true, 'Descripción Tobogán Acuático', 'https://images.unsplash.com/photo-1642717841683-c0323214617c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTZ8fHRvYm9nYW4lMjBhY3VhdGljb3xlbnwwfDB8MHx8fDA%3D&auto=format&fit=crop&w=500&q=60'),
       ('Sillas Voladoras', 6, false, false, 'Descripción Sillas Voladoras', 'https://images.unsplash.com/photo-1531114297032-fef035025fe7?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8c2lsbGFzJTIwdm9sYWRvcmFzfGVufDB8MHwwfHx8MA%3D%3D&auto=format&fit=crop&w=500&q=60'),
       ('Laberinto', 4, true, true, 'Descripción Laberinto', 'https://images.unsplash.com/photo-1590278458425-6aa3912a48a5?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8TGFiZXJpbnRvfGVufDB8MHwwfHx8MA%3D%3D&auto=format&fit=crop&w=500&q=60'),
       ('Barco Pirata', 7, false, false, 'Descripción Barco Pirata', 'https://media.istockphoto.com/id/680512040/es/foto/barco-pirata-en-alta-mar.webp?b=1&s=170667a&w=0&k=20&c=FRcEn2rc4rU_wqOmgMNCmOntVodJxK-XVqlbTskP6mA='),
       ('Rueda de la Fortuna', 10, true, true, 'Descripción Rueda de la Fortuna', 'https://images.unsplash.com/photo-1528324100-d0c311a3da67?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8UnVlZGElMjBkZSUyMGxhJTIwRm9ydHVuYXxlbnwwfDB8MHx8fDA%3D&auto=format&fit=crop&w=500&q=60'),
       ('Autos Chocadores', 6, false, false, 'Descripción Autos Chocadores', 'https://images.unsplash.com/photo-1572164625211-6723762c0e3a?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8QXV0b3MlMjBDaG9jYWRvcmVzfGVufDB8MHwwfHx8MA%3D%3D&auto=format&fit=crop&w=500&q=60'),
       ('Atracción Acuática', 8, true, true, 'Descripción Atracción Acuática', 'https://media.istockphoto.com/id/1051006012/es/foto/familia-feliz-divertirse-en-un-parque-de-diversiones.webp?b=1&s=170667a&w=0&k=20&c=oOCLSa6lwoagyy9zeTziHbBoF-jca3AiTzeyPX_wrJU='),
       ('Torre de Caída', 9, false, false, 'Descripción Torre de Caída', 'https://media.istockphoto.com/id/1165715981/es/foto/vista-de-primer-plano-de-la-torre-de-ca%C3%ADda-de-hierro-vertical-o-gran-ca%C3%ADda-en-un-parque-de.webp?b=1&s=170667a&w=0&k=20&c=_uminvu77JGfpsgKbw2S9hueVfUnFMRO3oM6YXArIXY='),
       ('Montaña de Agua', 7, true, true, 'Descripción Montaña de Agua', 'https://media.istockphoto.com/id/1459256710/es/foto/un-ni%C3%B1o-o-ni%C3%B1a-se-divierte-chapoteando-en-la-piscina-despu%C3%A9s-de-bajar-por-un-tobog%C3%A1n-acu%C3%A1tico.webp?b=1&s=170667a&w=0&k=20&c=vPFw8UPj5zTGx-QdjyYcKRyXRH5uT7F1zrKuoXYvcP8='),
       ('Tren Fantasma', 5, false, false, 'Descripción Tren Fantasma', 'https://images.unsplash.com/photo-1527498348926-888801f0a493?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MzF8fFRyZW4lMjBGYW50YXNtYXxlbnwwfDB8MHx8fDA%3D&auto=format&fit=crop&w=500&q=60');


-- Primer horario: 16:00 - 20:00
INSERT INTO horarios_juego (hora_inicio, hora_fin)
VALUES
  ('2023-06-19T16:00:00', '2023-06-19T20:00:00'),
  ('2023-06-20T16:00:00', '2023-06-20T20:00:00'),
  ('2023-06-21T16:00:00', '2023-06-21T20:00:00'),
  ('2023-06-22T16:00:00', '2023-06-22T20:00:00'),
  ('2023-06-23T16:00:00', '2023-06-23T20:00:00'),
  ('2023-06-24T16:00:00', '2023-06-24T20:00:00'),
  ('2023-06-25T16:00:00', '2023-06-25T20:00:00'),
  ('2023-06-26T16:00:00', '2023-06-26T20:00:00'),
  ('2023-06-27T16:00:00', '2023-06-27T20:00:00'),
  ('2023-06-28T16:00:00', '2023-06-28T20:00:00');

-- Segundo horario: 18:00 - 22:00
INSERT INTO horarios_juego (hora_inicio, hora_fin)
VALUES
  ('2023-06-19T18:00:00', '2023-06-19T22:00:00'),
  ('2023-06-20T18:00:00', '2023-06-20T22:00:00'),
  ('2023-06-21T18:00:00', '2023-06-21T22:00:00'),
  ('2023-06-22T18:00:00', '2023-06-22T22:00:00'),
  ('2023-06-23T18:00:00', '2023-06-23T22:00:00'),
  ('2023-06-24T18:00:00', '2023-06-24T22:00:00'),
  ('2023-06-25T18:00:00', '2023-06-25T22:00:00'),
  ('2023-06-26T18:00:00', '2023-06-26T22:00:00'),
  ('2023-06-27T18:00:00', '2023-06-27T22:00:00'),
  ('2023-06-28T18:00:00', '2023-06-28T22:00:00');

-- Tercer horario: 20:00 - 24:00
INSERT INTO horarios_juego (hora_inicio, hora_fin)
VALUES
  ('2023-06-19T20:00:00', '2023-06-20T00:00:00'),
  ('2023-06-20T20:00:00', '2023-06-21T00:00:00'),
  ('2023-06-21T20:00:00', '2023-06-22T00:00:00'),
  ('2023-06-22T20:00:00', '2023-06-23T00:00:00'),
  ('2023-06-23T20:00:00', '2023-06-24T00:00:00'),
  ('2023-06-24T20:00:00', '2023-06-25T00:00:00'),
  ('2023-06-25T20:00:00', '2023-06-26T00:00:00'),
  ('2023-06-26T20:00:00', '2023-06-27T00:00:00'),
  ('2023-06-27T20:00:00', '2023-06-28T00:00:00'),
  ('2023-06-28T20:00:00', '2023-06-29T00:00:00');
-- Relación para el primer horario (16:00 - 20:00)
INSERT INTO juegos_horarios (id_juegos, id_horarios)
VALUES
  (1, 1),
  (2, 1),
  (3, 1),
  (4, 1),
  (5, 1),
  (6, 1),
  (7, 1),
  (8, 1),
  (9, 1),
  (10, 1),
  (11, 1),
  (12, 1);

-- Relación para el segundo horario (18:00 - 22:00)
INSERT INTO juegos_horarios (id_juegos, id_horarios)
VALUES
  (1, 2),
  (2, 2),
  (3, 2),
  (4, 2),
  (5, 2),
  (6, 2),
  (7, 2),
  (8, 2),
  (9, 2),
  (10, 2),
  (11, 2),
  (12, 2);

-- Relación para el tercer horario (20:00 - 24:00)
INSERT INTO juegos_horarios (id_juegos, id_horarios)
VALUES
  (1, 3),
  (2, 3),
  (3, 3),
  (4, 3),
  (5, 3),
  (6, 3),
  (7, 3),
  (8, 3),
  (9, 3),
  (10, 3),
  (11, 3),
  (12, 3);
INSERT INTO empleados_juegos (id_empleados, id_juegos)
VALUES
  -- Empleado 2
  (2, 1),
  (2, 5),
  (2, 8),
  -- Empleado 3
  (3, 3),
  (3, 6),
  (3, 10),
  -- Empleado 4
  (4, 2),
  (4, 4),
  (4, 9),
  -- Empleado 5
  (5, 1),
  (5, 7),
  (5, 12),
  -- Empleado 6
  (6, 3),
  (6, 4),
  (6, 11),
  -- Empleado 7
  (7, 2),
  (7, 5),
  (7, 9),
  -- Empleado 8
  (8, 1),
  (8, 6),
  (8, 10),
  -- Empleado 9
  (9, 4),
  (9, 7),
  (9, 12),
  -- Empleado 10
  (10, 2),
  (10, 3),
  (10, 11),
  -- Empleado 11
  (11, 1),
  (11, 8),
  (11, 9),
  -- Empleado 12
  (12, 5),
  (12, 6),
  (12, 10);
-- INSERT para la tabla "entradas"
INSERT INTO entradas (cod_ident_entrada, fecha_hora_utilizacion, id_juegos)
VALUES
  ('COD-ENTRADA-1', '2023-06-19 10:00:00', 1),
  ('COD-ENTRADA-2', '2023-06-19 11:00:00', 2),
  ('COD-ENTRADA-3', '2023-06-19 12:00:00', 3),
  ('COD-ENTRADA-4', '2023-06-20 10:00:00', 4),
  ('COD-ENTRADA-5', '2023-06-20 11:00:00', 5),
  ('COD-ENTRADA-6', '2023-06-20 12:00:00', 6),
  ('COD-ENTRADA-7', '2023-06-21 10:00:00', 7),
  ('COD-ENTRADA-8', '2023-06-21 11:00:00', 8),
  ('COD-ENTRADA-9', '2023-06-21 12:00:00', 9),
  ('COD-ENTRADA-10', '2023-06-22 10:00:00', 10),
  ('COD-ENTRADA-11', '2023-06-22 11:00:00', 11),
  ('COD-ENTRADA-12', '2023-06-22 12:00:00', 12);

-- INSERT para la tabla "ventas_entradas"
INSERT INTO ventas_entradas (id_entradas, id_empleados, id_compradores, monto_ventas, fecha_ventas)
VALUES
  (1, 1, 1, 100.00, '2023-06-19 13:00:00'),
  (2, 2, 2, 150.00, '2023-06-19 14:00:00'),
  (3, 3, 3, 120.00, '2023-06-19 15:00:00'),
  (4, 4, 4, 110.00, '2023-06-20 13:00:00'),
  (5, 5, 5, 130.00, '2023-06-20 14:00:00'),
  (6, 6, 6, 140.00, '2023-06-20 15:00:00'),
  (7, 7, 7, 90.00, '2023-06-21 13:00:00'),
  (8, 8, 8, 80.00, '2023-06-21 14:00:00'),
  (9, 9, 9, 100.00, '2023-06-21 15:00:00'),
  (10, 10, 10, 120.00, '2023-06-22 13:00:00'),
  (11, 11, 11, 130.00, '2023-06-22 14:00:00'),
  (12, 12, 12, 140.00, '2023-06-22 15:00:00');



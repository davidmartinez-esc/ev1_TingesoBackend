INSERT INTO precio_reparacion (id, nombre_de_la_rep, precio_gasolina, precio_diesel, precio_hibrido, precio_electrico)
VALUES
    (1, 'REP SISTEMA DE FRENOS',120000, 120000, 180000, 220000),
    (2, 'SERVICIO SISTEMA DE REFRIGERACION',130000, 130000, 190000, 230000),
    (3, 'REPARACIONES DE MOTOR',350000, 450000, 700000, 800000),
    (4, 'REPARACIONES DE TRANSMISION',210000, 210000, 300000, 300000),
    (5, 'REP DEL SISTEMA ELECTRICO',150000, 150000, 200000, 250000),
    (6, 'REP DEL SISTEMA DE ESCAPE',100000, 120000, 450000, 0),
    (7, 'REP DE NEUMATICOS Y RUEDAS',100000, 100000, 100000, 100000),
    (8, 'REP DE SUSPENSION Y DIRECCION',180000, 180000, 210000, 250000),
    (9, 'REP AIRE ACONDICIONA Y CALEFACCION',150000, 150000, 180000, 180000),
    (10, 'REP SISTEMA DE COMBUSTIBLE',130000, 140000, 220000, 0),
    (11, 'REP Y REEMPLAZO DE PARABRISAS Y CRISTALES',80000, 80000, 80000, 80000);

INSERT INTO descuento_por_numero_de_reparaciones (id, numero_de_reparaciones, tipo_de_motor, porcentaje_descuento)
VALUES
    (1, '1-2', 'GASOLINA', 5),
    (2, '1-2', 'DIESEL', 7),
    (3, '1-2', 'HIBRIDO', 10),
    (4, '1-2', 'ELECTRICO', 8),
    (5, '3-5', 'GASOLINA', 10),
    (6, '3-5', 'DIESEL', 12),
    (7, '3-5', 'HIBRIDO', 15),
    (8, '3-5', 'ELECTRICO', 13),
    (9, '6-9', 'GASOLINA', 15),
    (10, '6-9', 'DIESEL', 17),
    (11, '6-9', 'HIBRIDO', 20),
    (12, '6-9', 'ELECTRICO', 18),
    (13, '10-MAS', 'GASOLINA', 20),
    (14, '10-MAS', 'DIESEL', 22),
    (15, '10-MAS', 'HIBRIDO', 25),
    (16, '10-MAS', 'ELECTRICO', 23);

INSERT INTO recargo_por_antiguedad (id, antiguedad, tipo_de_vehiculo, porcentaje_recargo)
VALUES
    (1, '0-5', 'SEDAN', 0),
    (2, '0-5', 'HATCHBACK', 0),
    (3, '0-5', 'SUV', 0),
    (4, '0-5', 'PICKUP', 0),
    (5, '0-5', 'FURGONETA', 0),
    (6, '6-10', 'SEDAN', 5),
    (7, '6-10', 'HATCHBACK', 5),
    (8, '6-10', 'SUV', 7),
    (9, '6-10', 'PICKUP', 7),
    (10, '6-10', 'FURGONETA', 7),
    (11, '11-15', 'SEDAN', 9),
    (12, '11-15', 'HATCHBACK', 9),
    (13, '11-15', 'SUV', 11),
    (14, '11-15', 'PICKUP', 11),
    (15, '11-15', 'FURGONETA', 11),
    (16, '16-MAS', 'SEDAN', 15),
    (17, '16-MAS', 'HATCHBACK', 15),
    (18, '16-MAS', 'SUV', 20),
    (19, '16-MAS', 'PICKUP', 20),
    (20, '16-MAS', 'FURGONETA', 20);


INSERT INTO recargo_por_kilometraje (id, kilometraje, tipo_de_vehiculo, porcentaje_recargo)
VALUES
    (1, '0-5.000', 'SEDAN', 0),
    (2, '0-5.000', 'HATCHBACK', 0),
    (3, '0-5.000', 'SUV', 0),
    (4, '0-5.000', 'PICKUP', 0),
    (5, '0-5.000', 'FURGONETA', 0),
    (6, '5.001-12.000', 'SEDAN', 3),
    (7, '5.001-12.000', 'HATCHBACK', 3),
    (8, '5.001-12.000', 'SUV', 5),
    (9, '5.001-12.000', 'PICKUP', 5),
    (10, '5.001-12.000', 'FURGONETA', 5),
    (11, '12.001-25.000', 'SEDAN', 7),
    (12, '12.001-25.000', 'HATCHBACK', 7),
    (13, '12.001-25.000', 'SUV', 9),
    (14, '12.001-25.000', 'PICKUP', 9),
    (15, '12.001-25.000', 'FURGONETA', 9),
    (16, '25.001-40.000', 'SEDAN', 12),
    (17, '25.001-40.000', 'HATCHBACK', 12),
    (18, '25.001-40.000', 'SUV', 12),
    (19, '25.001-40.000', 'PICKUP', 12),
    (20, '25.001-40.000', 'FURGONETA', 12),
    (21, '40.000-MAS', 'SEDAN', 20),
    (22, '40.000-MAS', 'HATCHBACK', 20),
    (23, '40.000-MAS', 'SUV', 20),
    (24, '40.000-MAS', 'PICKUP', 20),
    (25, '40.000-MAS', 'FURGONETA', 20);


CREATE TABLE precio_reparacion (
                                   id BIGINT NOT NULL,
                                   nombre_de_la_rep VARCHAR(255),
                                   precio_gasolina INT,
                                   precio_diesel INT,
                                   precio_hibrido INT,
                                   precio_electrico INT,

                                   PRIMARY KEY(id)
);

CREATE TABLE descuento_por_numero_de_reparaciones (
                                                      id BIGINT NOT NULL,
                                                      numero_de_reparaciones VARCHAR(20),
                                                      tipo_de_motor VARCHAR(20),
                                                      porcentaje_descuento INT,

                                                      PRIMARY KEY(id)
);

CREATE TABLE  recargo_por_antiguedad(
                                        id BIGINT NOT NULL,
                                        antiguedad VARCHAR(20),
                                        tipo_de_vehiculo VARCHAR(20),
                                        porcentaje_recargo INT,

                                        PRIMARY KEY(id)
);

CREATE TABLE  recargo_por_kilometraje(
                                         id BIGINT NOT NULL,
                                         kilometraje VARCHAR(50),
                                         tipo_de_vehiculo VARCHAR(20),
                                         porcentaje_recargo INT,

                                         PRIMARY KEY(id)
);


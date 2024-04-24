
CREATE TABLE precio_reparacion (
                                   id BIGINT NOT NULL,
                                   Gasolina INT,
                                   Diésel INT,
                                   Híbrido INT,
                                   Eléctrico INT,

                                   PRIMARY KEY(id)
);

CREATE TABLE descuento_por_numero_de_reparaciones (
                                                      id BIGINT NOT NULL,
                                                      numero_de_reparaciones VARCHAR(10),
                                                      tipo_de_motor VARCHAR(20),
                                                      porcentaje_descuento INT,

                                                      PRIMARY KEY(id)
);

CREATE TABLE  recargo_por_antiguedad(
                                        id BIGINT NOT NULL,
                                        antiguedad VARCHAR(10),
                                        tipo_de_vehiculo VARCHAR(20),
                                        porcentaje_recargo INT,

                                        PRIMARY KEY(id)
);

CREATE TABLE  recargo_por_kilometraje(
                                         id BIGINT NOT NULL,
                                         kilometraje VARCHAR(10),
                                         tipo_de_vehiculo VARCHAR(20),
                                         porcentaje_recargo INT,

                                         PRIMARY KEY(id)
);


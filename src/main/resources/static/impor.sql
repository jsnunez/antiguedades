-- Inserciones para la tabla EpocaAntiguedad
INSERT INTO epoca_antiguedad (nombre ) VALUES
('Prehistoria'),
('Antigüedad Clásica'),
('Edad Media'),
('Renacimiento'),
('Barroco'),
('Ilustración'),
('Edad Moderna'),
('Edad Contemporánea');

-- Inserciones para la tabla EstadoPersona
INSERT INTO estadopersona (estado) VALUES
('Activo'),
('Inactivo'),
('Suspendido'),
('Baja'),
('En Prueba');
-- Inserciones para la tabla Genero
INSERT INTO genero (nombre) VALUES
('Masculino'),
('Femenino'),
('No Binario'),
('Prefiero no decir'),
('Otro');

-- Inserciones para la tabla Pais
INSERT INTO paises (nombre) VALUES
('Perú'),
('Argentina'),
('Chile'),
('Colombia'),
('Venezuela');
-- Inserciones para la tabla Region
INSERT INTO regiones (nombre, pais_id) VALUES
('Lima', 1),
('Buenos Aires', 2),
('Santiago', 3),
('Bogotá', 4),
('Caracas', 5);

-- Inserciones para la tabla Ciudades
INSERT INTO ciudades (nombre, region_id) VALUES
('Lima', 1),
('Buenos Aires', 2),
('Santiago', 3),
('Bogotá', 4),
('Caracas', 5);
-- Inserciones para la tabla TipoDireccion
INSERT INTO tipodireccion (tipo) VALUES
('Residencial'),
('Comercial'),
('Industrial'),
('Oficina'),
('Vacacional');
-- Inserciones para la tabla Empresa
INSERT INTO empresa (nombre, nit) VALUES
('Empresa 1', '123456789'),
('Empresa 2', '987654321'),
('Empresa 3', '456123789'),
('Empresa 4', '321654987'),
('Empresa 5', '789123456');
-- Inserciones para la tabla Sucursal
INSERT INTO sucursal (nombre, empresa_id, ciudad_id) VALUES
('Sucursal 1', 1, 1),
('Sucursal 2', 2, 2),
('Sucursal 3', 3, 3),
('Sucursal 4', 4, 4),
('Sucursal 5', 5, 5);
-- Inserciones para la tabla Persona
INSERT INTO persona (nombre, apellido, fecha_nacimiento, email, genero_id, sucursal_id, estadopersona_id) VALUES
('Juan', 'Pérez', '1980-01-01', 'juan@example.com', 1, 1, 1),
('María', 'González', '1990-02-02', 'maria@example.com', 2, 1, 2),
('Carlos', 'Ramírez', '1975-03-03', 'carlos@example.com', 3, 2, 1),
('Laura', 'Martínez', '1985-04-04', 'laura@example.com', 1, 2, 2),
('Pedro', 'López', '1995-05-05', 'pedro@example.com', 2, 1, 1);
-- Inserciones para la tabla DireccionPersona
INSERT INTO direccionpersona (numero, persona_id, tipo_direccion_id) VALUES
('Av. Siempre Viva 123', 1, 1),
('Calle Falsa 456', 2, 2),
('Paseo de la Reforma 789', 3, 3),
('Gran Avenida 101', 4, 4),
('Calle de la Independencia 202', 5, 5);



-- Inserciones para la tabla Categorias
INSERT INTO categorias (nombre) VALUES
('Arte Precolombino'),
('Muebles Antiguos'),
('Cerámica'),
('Arte Popular'),
('Joyas Antiguas');
-- Inserciones para la tabla Antiguedades
INSERT INTO antiguedades (nombre,disponible, descripcion, precio, estado_Conservacion, fecha_Registro, categoria_id, propietario_id, sucursal_id, epoca_id) VALUES
('Vase Maya',1, 'Un hermoso vase de la cultura Maya.', 1500.00, 'Excelente', NOW(), 1, 1, 1, 1),
('Estatua Inca',1, 'Estatua de un guerrero Inca.', 2500.00, 'Buena', NOW(), 2, 2, 1, 2),
('Cerámica Azteca',1, 'Cerámica pintada de la cultura Azteca.', 800.00, 'Regular', NOW(), 3, 1, 1, 1),
('Mueble Colonial',1, 'Mueble de época colonial.', 3000.00, 'Excelente', NOW(), 4, 3, 2, 3),
('Arte Huichol',1, 'Obra de arte hecha por la comunidad Huichol.', 1200.00, 'Buena', NOW(), 1, 2, 2, 2);
-- Inserciones para la tabla RankingAntiguedad
INSERT INTO rankingantiguedad (nombre, antiguedad_id) VALUES
('Primera', 1),
('Segunda', 2),
('Tercera', 3),
('Cuarta', 4),
('Quinta', 5);




-- Inserciones para la tabla ClaseContacto
INSERT INTO clasecontacto (nombre) VALUES
('Teléfono'),
('Email'),
('WhatsApp'),
('Dirección'),
('Redes Sociales');

-- Inserciones para la tabla Coleccionistas
INSERT INTO coleccionistas (persona_id, cantidad_Compras, total_Compras) VALUES
(1, 5, 10000.00),
(2, 3, 7500.00),
(3, 7, 5000.00),
(4, 10, 15000.00),
(5, 2, 3000.00);

-- Inserciones para la tabla ContactoPersona
INSERT INTO contactopersona (numero, persona_id, clasecontacto_id) VALUES
('987654321', 1, 1),
('123456789', 2, 2),
('999888777', 3, 3),
('555444333', 4, 4),
('222333444', 5, 5);
-- Inserciones para la tabla EstacionPago
INSERT INTO estacionpago (nombre, ubicacion) VALUES
('Estación A', 'Lima, Perú'),
('Estación B', 'Buenos Aires, Argentina'),
('Estación C', 'Santiago, Chile'),
('Estación D', 'Bogotá, Colombia'),
('Estación E', 'Caracas, Venezuela');
-- Inserciones para la tabla TipoTransaccion
INSERT INTO tipo_transaccion (tipo) VALUES
('Compra'),
('Venta'),
('Intercambio'),
('Donación'),
('Subasta');


-- Inserciones para la tabla Transaccion
INSERT INTO transacciones (fecha, comprador_id, vendedor_id, monto, estacion_Pago_id, tipo_Transaccion_id) VALUES
('2023-01-10', 1, 2, 1500.00, 1, 1),
('2023-02-15', 2, 1, 2000.00, 2, 2),
('2023-03-20', 3, 1, 750.00, 1, 1),
('2023-04-25', 1, 3, 1200.00, 3, 3),
('2023-05-30', 2, 3, 300.00, 2, 2);

-- Inserciones para la tabla Despachos
INSERT INTO despachos (estado, fecha_Despacho, transaccion_id) VALUES
('Enviado', NOW(), 1),
('Entregado', NOW(), 2),
('Pendiente', NOW(), 3),
('Cancelado', NOW(), 4),
('En Proceso', NOW(), 5);

-- Inserciones para la tabla DetalleTransaccion
INSERT INTO detalle_transaccion (transaccion_id, antiguedad_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);



-- Inserciones para la tabla Empleado
INSERT INTO empleado (nombre, apellido, fecha_Contratacion, puesto, salario, comision, persona_id) VALUES
('Juan', 'Pérez', NOW(), 'Vendedor', 2000.00, 150.00, 1),
('María', 'González', NOW(), 'Gerente', 3500.00, 250.00, 2),
('Carlos', 'Ramírez', NOW(), 'Asistente', 1500.00, 100.00, 3),
('Laura', 'Martínez', NOW(), 'Contadora', 3000.00, 200.00, 4),
('Pedro', 'López', NOW(), 'Marketing', 2500.00, 180.00, 5);




-- Inserciones para la tabla Galeria
INSERT INTO galeria (url_Imagen, descripcion, antiguedad_id) VALUES
('http://example.com/image1.jpg', 'Vase Maya', 1),
('http://example.com/image2.jpg', 'Estatua Inca', 2),
('http://example.com/image3.jpg', 'Cerámica Azteca', 3),
('http://example.com/image4.jpg', 'Mueble Colonial', 4),
('http://example.com/image5.jpg', 'Arte Huichol', 5);



-- Inserciones para la tabla HistorialPropiedad
INSERT INTO historialpropiedad (fecha_Cambio, antiguedad_id, propietario_Anterior_id, propietario_Actual_id) VALUES
(NOW(), 1, 1, 2),
(NOW(), 2, 2, 3),
(NOW(), 1, 3, 1),
(NOW(), 2, 4, 2),
(NOW(), 3, 5, 4);

-- Inserciones para la tabla MedioPago
INSERT INTO mediopago (tipo) VALUES
('Tarjeta de Crédito'),
('Transferencia Bancaria'),
('Efectivo'),
('Cheque'),
('PayPal');

-- Inserciones para la tabla TipoMovCaja
INSERT INTO tipomovcaja (tipo) VALUES
('Ingreso'),
('Egreso'),
('Transferencia'),
('Reembolso'),
('Ajuste');

-- Inserciones para la tabla MovCaja
INSERT INTO movcaja ( monto, fecha_Movimiento, tipo_Movimiento_id, estacion_Pago_id) VALUES
( 5000.00, NOW(), 1, 1),
( 2000.00, NOW(), 2, 2),
( 1000.00, NOW(), 3, 3),
( 1500.00, NOW(), 4, 4),
( 3000.00, NOW(), 5, 5);


INSERT INTO tipopersona (tipo) VALUES
('Coleccionista'),
('Vendedor'),
('Comprador'),
('Proveedor'),
('Empleado');

-- Inserciones para la tabla PersonaTipoPersona
INSERT INTO personatipopersona (persona_id, tipopersona_id) VALUES
(1, 1),
(2, 2),
(3, 1),
(4, 2),
(5, 1);



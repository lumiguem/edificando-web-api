-- =======================================================
-- CREACIÓN DE BASE DE DATOS
-- =======================================================
DROP DATABASE IF EXISTS Edificando_db;
CREATE DATABASE Edificando_db;
USE Edificando_db;

-- =======================================================
-- TABLA CATEGORÍAS
-- =======================================================
CREATE TABLE categorias (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT
);

-- =======================================================
-- TABLA MARCAS
-- =======================================================
CREATE TABLE marcas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT
);

-- =======================================================
-- TABLA PRODUCTOS
-- =======================================================
CREATE TABLE productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL,
    descripcion TEXT,
    precio DECIMAL(10,2) NOT NULL,
    stock INT DEFAULT 0,
    imagen VARCHAR(255),
    id_categoria INT,
    id_marca INT,
    FOREIGN KEY (id_categoria) REFERENCES categorias(id),
    FOREIGN KEY (id_marca) REFERENCES marcas(id)
);

-- =======================================================
-- TABLA TIPOS DE SERVICIO
-- =======================================================
CREATE TABLE tipo_servicio (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT
);

-- =======================================================
-- TABLA SERVICIOS
-- =======================================================
CREATE TABLE servicios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL,
    descripcion TEXT,
    precio DECIMAL(10,2) NOT NULL,
    imagen VARCHAR(255),
    id_tipo_servicio INT,
    FOREIGN KEY (id_tipo_servicio) REFERENCES tipo_servicio(id)
);

-- =======================================================
-- TABLA TIPOS DE CLIENTE
-- =======================================================
CREATE TABLE tipo_cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT
);

-- =======================================================
-- TABLA CLIENTES
-- =======================================================
CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL,
    direccion VARCHAR(255),
    telefono VARCHAR(20),
    correo VARCHAR(100),
    id_tipo_cliente INT,
    FOREIGN KEY (id_tipo_cliente) REFERENCES tipo_cliente(id)
);

-- =======================================================
-- TABLA PROYECTOS
-- =======================================================
CREATE TABLE proyectos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    descripcion TEXT,
    imagen VARCHAR(255),
    id_tipo_servicio INT,
    FOREIGN KEY (id_tipo_servicio) REFERENCES tipo_servicio(id)
);


-- =======================================================
-- INSERTS CATEGORÍAS
-- =======================================================
INSERT INTO categorias (nombre, descripcion) VALUES
('Impermeabilizantes', 'Productos para protección contra la humedad y filtraciones'),
('Sellantes', 'Selladores para juntas y uniones'),
('Adhesivos Epóxicos', 'Adhesivos de alta resistencia para construcción'),
('Aditivos para el Concreto', 'Aditivos para mejorar propiedades del concreto'),
('Morteros y Grouts', 'Morteros de reparación y relleno'),
('Anclajes Químicos', 'Sistemas de fijación química'),
('Resinas para Inyección', 'Resinas epóxicas y poliuretánicas'),
('Revestimientos Industriales', 'Protección y acabado de superficies industriales'),
('Herramientas y Accesorios', 'Herramientas y accesorios para la construcción y mantenimiento');

-- =======================================================
-- INSERTS MARCAS
-- =======================================================
INSERT INTO marcas (nombre, descripcion) VALUES
('Sika', 'Productos químicos para la construcción y reparación'),
('Henkel', 'Adhesivos y soluciones industriales'),
('Bosch', 'Herramientas eléctricas y accesorios'),
('DeWalt', 'Herramientas profesionales para construcción'),
('Makita', 'Herramientas eléctricas e inalámbricas'),
('Hilti', 'Tecnología para construcción y anclajes químicos'),
('Mapei', 'Aditivos, adhesivos y morteros'),
('Stanley', 'Herramientas manuales y eléctricas');

-- =======================================================
-- INSERTS PRODUCTOS (con categorías y marcas)
-- =======================================================
INSERT INTO productos (nombre, descripcion, precio, stock, imagen, id_categoria, id_marca) VALUES
('SikaTop Seal 107', 'Revestimiento impermeabilizante cementoso', 120.00, 50, 'img/productos/sikatop_seal107.jpg', 1, 1),
('Mapelastic Foundation', 'Impermeabilizante flexible bicomponente', 200.00, 30, 'img/productos/mapelastic.jpg', 1, 7),

('Sikaflex 11FC', 'Sellante elástico multipropósito', 45.00, 100, 'img/productos/sikaflex11fc.jpg', 2, 1),

('Loctite PL Premium', 'Adhesivo epóxico de alta resistencia', 65.00, 80, 'img/productos/loctite_pl_premium.jpg', 3, 2),
('Mapei Eporip', 'Adhesivo epóxico para juntas de construcción', 85.00, 60, 'img/productos/eporip.jpg', 3, 7),

('Sika ViscoCrete', 'Aditivo superplastificante para concreto', 150.00, 40, 'img/productos/viscocrete.jpg', 4, 1),
('Mapei Dynamon', 'Aditivo reductor de agua de alto rango', 135.00, 35, 'img/productos/dynamon.jpg', 4, 7),

('SikaGrout 212', 'Mortero de relleno de alta resistencia', 90.00, 70, 'img/productos/sikagrout212.jpg', 5, 1),
('Mapei Planitop 400', 'Mortero estructural de reparación', 110.00, 50, 'img/productos/planitop400.jpg', 5, 7),

('Hilti HIT-HY 200', 'Anclaje químico de alto rendimiento', 250.00, 25, 'img/productos/hilti_hit_hy200.jpg', 6, 6),
('Sika AnchorFix-2', 'Resina de anclaje epóxica', 180.00, 30, 'img/productos/anchorfix2.jpg', 6, 1),

('Sikadur 52', 'Resina epóxica de inyección de baja viscosidad', 220.00, 20, 'img/productos/sikadur52.jpg', 7, 1),
('Mapei Epojet', 'Resina epóxica de inyección', 240.00, 18, 'img/productos/epojets.jpg', 7, 7),

('SikaFloor 264', 'Revestimiento epóxico para pisos industriales', 320.00, 15, 'img/productos/sikafloor264.jpg', 8, 1),
('Mapei Mapecoat I 24', 'Revestimiento epóxico protector', 340.00, 12, 'img/productos/mapecoat24.jpg', 8, 7),

('Taladro Percutor Bosch', 'Taladro eléctrico para concreto y mampostería', 350.00, 40, 'img/productos/taladro_percutor.jpg', 9, 3),
('Amoladora Angular DeWalt', 'Herramienta para corte y desbaste', 280.00, 35, 'img/productos/amoladora.jpg', 9, 4),
('Martillo Demoledor Makita', 'Herramienta eléctrica para demolición de concreto', 1200.00, 15, 'img/productos/martillo_demoledor.jpg', 9, 5),
('Juego de Llaves Stanley', 'Juego de llaves de diferentes medidas', 150.00, 60, 'img/productos/llaves_mixtas.jpg', 9, 8),
('Nivel Láser Bosch', 'Equipo para nivelación de estructuras', 500.00, 20, 'img/productos/nivel_laser.jpg', 9, 3);

-- =======================================================
-- INSERTS TIPOS DE SERVICIO
-- =======================================================
INSERT INTO tipo_servicio (nombre, descripcion) VALUES
('Techos', 'Servicios relacionados con techos y cubiertas'),
('Impermeabilización Estructural', 'Protección de estructuras contra agua y humedad'),
('Reparación y Protección Estructural', 'Reparaciones de concreto y estructuras dañadas'),
('Juntas', 'Tratamiento y sellado de juntas en estructuras'),
('Pisos Industriales y Estacionamientos', 'Acabados y recubrimientos para pisos'),
('Obras Civiles', 'Construcciones y proyectos civiles generales');

-- =======================================================
-- INSERTS SERVICIOS (3 por tipo)
-- =======================================================
INSERT INTO servicios (nombre, descripcion, precio, imagen, id_tipo_servicio) VALUES
('Instalación de Techo Aluzinc', 'Colocación de techo metálico con protección anticorrosiva', 5000.00, 'img/servicios/techo_aluzinc.jpg', 1),
('Mantenimiento de Techo', 'Reparación de filtraciones y limpieza', 2500.00, 'img/servicios/mantenimiento_techo.jpg', 1),
('Instalación de Techo Termoacústico', 'Montaje de paneles aislantes', 6000.00, 'img/servicios/techo_termoacustico.jpg', 1),

('Impermeabilización de Losas', 'Protección contra filtraciones en losas de concreto', 4000.00, 'img/servicios/impermeabilizacion_losas.jpg', 2),
('Impermeabilización de Cisternas', 'Aplicación de revestimientos impermeables', 3500.00, 'img/servicios/impermeabilizacion_cisternas.jpg', 2),
('Impermeabilización de Muros', 'Revestimiento impermeable en muros perimetrales', 3000.00, 'img/servicios/impermeabilizacion_muros.jpg', 2),

('Reparación de Concreto Dañado', 'Recuperación estructural de columnas y vigas', 7000.00, 'img/servicios/reparacion_concreto.jpg', 3),
('Protección con Revestimiento Epóxico', 'Protección anticorrosiva de superficies', 8000.00, 'img/servicios/proteccion_epoxico.jpg', 3),
('Refuerzo de Estructuras', 'Aplicación de fibras de carbono y polímeros', 12000.00, 'img/servicios/refuerzo_estructuras.jpg', 3),

('Sellado de Juntas de Expansión', 'Aplicación de sellante en juntas de expansión', 4500.00, 'img/servicios/sellado_juntas.jpg', 4),
('Reemplazo de Juntas en Pisos', 'Reemplazo de juntas deterioradas en pisos industriales', 5000.00, 'img/servicios/reemplazo_juntas.jpg', 4),
('Tratamiento de Juntas de Construcción', 'Sellado flexible para juntas de construcción', 4000.00, 'img/servicios/tratamiento_juntas.jpg', 4),

('Instalación de Piso Epóxico', 'Revestimiento industrial de alto tráfico', 15000.00, 'img/servicios/piso_epoxico.jpg', 5),
('Piso Poliuretano Antideslizante', 'Revestimiento resistente a químicos y abrasión', 18000.00, 'img/servicios/piso_poliuretano.jpg', 5),
('Revestimiento para Estacionamiento', 'Pintura y señalización de estacionamientos', 12000.00, 'img/servicios/revestimiento_estacionamiento.jpg', 5),

('Construcción de Muros de Concreto', 'Ejecución de muros estructurales', 20000.00, 'img/servicios/muros_concreto.jpg', 6),
('Construcción de Losas', 'Losas de concreto reforzado', 25000.00, 'img/servicios/losas_concreto.jpg', 6),
('Obras de Albañilería General', 'Construcción de tabiquería y acabados', 15000.00, 'img/servicios/albanileria.jpg', 6);


INSERT INTO tipo_cliente (nombre, descripcion) VALUES
('Persona Natural', 'Cliente individual'),
('Empresa', 'Cliente corporativo'),
('Distribuidor', 'Cliente que compra para revender');

-- Insertar clientes
INSERT INTO clientes (nombre, direccion, telefono, correo, id_tipo_cliente) VALUES
('Juan Pérez', 'Av. Los Próceres 123, Lima', '987654321', 'juan.perez@email.com', 1),
('María Gómez', 'Jr. San Martín 456, Arequipa', '999888777', 'maria.gomez@email.com', 1),
('Construcciones Andinas SAC', 'Av. Industrial 234, Lima', '014567890', 'contacto@construandinas.com', 2),
('Servicios Generales del Sur EIRL', 'Calle Comercio 789, Cusco', '084654321', 'info@serviciosur.com', 2),
('Ferretería El Progreso', 'Av. Grau 321, Trujillo', '044987654', 'ventas@ferreprogreso.com', 3),
('Distribuidora San José', 'Av. Universitaria 567, Lima', '013456789', 'ventas@distribuidorasanjose.com', 3),
('Ana Torres', 'Av. Javier Prado 987, Lima', '987123456', 'ana.torres@email.com', 1),
('Inmobiliaria Los Olivos SAC', 'Av. Canta Callao 432, Lima', '015678432', 'contacto@losolivos.com', 2),
('Ferretería El Constructor', 'Jr. Independencia 654, Chiclayo', '074654987', 'ventas@ferreconstructor.com', 3),
('Carlos Ramírez', 'Calle Primavera 321, Lima', '999456123', 'carlos.ramirez@email.com', 1);

-- =======================================================
-- INSERTS PROYECTOS
-- =======================================================
INSERT INTO proyectos (titulo, descripcion, imagen, id_tipo_servicio) VALUES
('Centro Comercial Plaza Norte',
 'Impermeabilización completa de estacionamientos subterráneos utilizando sistemas de membrana de poliuretano.',
 'https://images.unsplash.com/photo-1555636222-cae831e670b3?auto=format&fit=crop&w=600&q=80',
 2),

('Puente Bicentenario',
 'Inyección de resinas epóxicas en fisuras estructurales y refuerzo con fibra de carbono.',
 'https://images.unsplash.com/photo-1545558014-8692077e9b5c?auto=format&fit=crop&w=600&q=80',
 3),

('Planta Industrial Química',
 'Aplicación de revestimiento epóxico de alta resistencia química en 5000m2.',
 'https://images.unsplash.com/photo-1565008447742-97f6f38c985c?auto=format&fit=crop&w=600&q=80',
 5),

('Residencial Los Álamos',
 'Renovación de impermeabilización en azoteas con manto asfáltico gravillado.',
 'https://images.unsplash.com/photo-1599692223425-232c04e28f24?auto=format&fit=crop&w=600&q=80',
 1);




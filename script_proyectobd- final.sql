
-- Creación de secuencias
CREATE SEQUENCE seq_clientes
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE SEQUENCE seq_reservaciones
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE SEQUENCE seq_ocupaciones
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE SEQUENCE seq_empleados
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

-- Creación de la tabla Clientes
CREATE TABLE Clientes (
    id_cliente NUMBER DEFAULT seq_clientes.NEXTVAL PRIMARY KEY,
    nombre_cliente VARCHAR2(100),
    telefono VARCHAR2(20),
    numero VARCHAR2(20)
);

-- Creación de la tabla Reservaciones
CREATE TABLE Reservaciones (
    id_reservacion NUMBER DEFAULT seq_reservaciones.NEXTVAL PRIMARY KEY,
    id_cliente NUMBER,
    cantidad NUMBER,
    dia DATE,
    FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente)
);

-- Creación de la tabla Ocupaciones
CREATE TABLE Ocupaciones (
    id_ocupacion NUMBER DEFAULT seq_ocupaciones.NEXTVAL PRIMARY KEY,
    nombre_ocupacion VARCHAR2(100),
    cantidad_empleados NUMBER
);

-- Creación de la tabla Empleados
CREATE TABLE Empleados (
    id_empleado NUMBER DEFAULT seq_empleados.NEXTVAL PRIMARY KEY,
    id_ocupacion NUMBER,
    nombre_empleado VARCHAR2(100),
    apellido VARCHAR2(100),
    telefono VARCHAR2(20),
    FOREIGN KEY (id_ocupacion) REFERENCES Ocupaciones(id_ocupacion)
);

-- Finalización de transacción
COMMIT;

-- ////////////////////////////////

-- Creación de secuencias (si es necesario)
CREATE SEQUENCE seq_proveedor
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE SEQUENCE seq_categorias
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE SEQUENCE seq_productos
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE SEQUENCE seq_ventas
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE SEQUENCE seq_servicios
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

-- Creación de la tabla Proveedor
CREATE TABLE Proveedor (
    id_proveedor NUMBER DEFAULT seq_proveedor.NEXTVAL PRIMARY KEY,
    nombre_proveedor VARCHAR2(100),
    correo VARCHAR2(100),
    contacto VARCHAR2(50),
    direccion VARCHAR2(200)
);

-- Creación de la tabla Categorias
CREATE TABLE Categorias (
    id_categoria NUMBER DEFAULT seq_categorias.NEXTVAL PRIMARY KEY,
    nombre_categoria VARCHAR2(100)
);

-- Creación de la tabla Productos
CREATE TABLE Productos (
    id_producto NUMBER DEFAULT seq_productos.NEXTVAL PRIMARY KEY,
    id_categoria NUMBER,
    id_proveedor NUMBER,
    nombre_producto VARCHAR2(100),
    inventario NUMBER,
    CONSTRAINT fk_categoria
        FOREIGN KEY (id_categoria)
        REFERENCES Categorias(id_categoria),
    CONSTRAINT fk_proveedor
        FOREIGN KEY (id_proveedor)
        REFERENCES Proveedor(id_proveedor)
);

-- Creación de la tabla Ventas
CREATE TABLE Ventas (
    id_venta NUMBER DEFAULT seq_ventas.NEXTVAL PRIMARY KEY,
    id_producto NUMBER,
    monto_v NUMBER,
    CONSTRAINT fk_producto_venta
        FOREIGN KEY (id_producto)
        REFERENCES Productos(id_producto)
);

-- Creación de la tabla Servicios
CREATE TABLE Servicios (
    id_servicio NUMBER DEFAULT seq_servicios.NEXTVAL PRIMARY KEY,
    monto_s NUMBER
);

--Insert Clientes
INSERT INTO Clientes (nombre_cliente, telefono, numero) VALUES ('Ana González', '555-1234', 'A123');
INSERT INTO Clientes (nombre_cliente, telefono, numero) VALUES ('Luis Fernández', '555-5678', 'B456');
INSERT INTO Clientes (nombre_cliente, telefono, numero) VALUES ('María López', '555-8765', 'C789');
INSERT INTO Clientes (nombre_cliente, telefono, numero) VALUES ('Pedro Martínez', '555-4321', 'D012');
INSERT INTO Clientes (nombre_cliente, telefono, numero) VALUES ('Laura Ramírez', '555-6789', 'E345');

--Insert Reservaciones
INSERT INTO Reservaciones (id_cliente, cantidad, dia) VALUES (1, 3, TO_DATE('2024-07-30', 'YYYY-MM-DD'));
INSERT INTO Reservaciones (id_cliente, cantidad, dia) VALUES (2, 2, TO_DATE('2024-08-01', 'YYYY-MM-DD'));
INSERT INTO Reservaciones (id_cliente, cantidad, dia) VALUES (3, 4, TO_DATE('2024-08-05', 'YYYY-MM-DD'));
INSERT INTO Reservaciones (id_cliente, cantidad, dia) VALUES (4, 1, TO_DATE('2024-08-10', 'YYYY-MM-DD'));
INSERT INTO Reservaciones (id_cliente, cantidad, dia) VALUES (5, 5, TO_DATE('2024-08-15', 'YYYY-MM-DD'));

--Insert Ocupaciones
INSERT INTO Ocupaciones (nombre_ocupacion, cantidad_empleados) VALUES ('Gerente', 3);
INSERT INTO Ocupaciones (nombre_ocupacion, cantidad_empleados) VALUES ('Cocinero', 10);
INSERT INTO Ocupaciones (nombre_ocupacion, cantidad_empleados) VALUES ('Camarero', 15);
INSERT INTO Ocupaciones (nombre_ocupacion, cantidad_empleados) VALUES ('Recepcionista', 4);
INSERT INTO Ocupaciones (nombre_ocupacion, cantidad_empleados) VALUES ('Limpiador', 2);


--Insert Empleados
INSERT INTO Empleados (id_ocupacion, nombre_empleado, apellido, telefono) VALUES (1, 'Carlos', 'Sánchez', '555-1111');
INSERT INTO Empleados (id_ocupacion, nombre_empleado, apellido, telefono) VALUES (2, 'Marta', 'Torres', '555-2222');
INSERT INTO Empleados (id_ocupacion, nombre_empleado, apellido, telefono) VALUES (3, 'Jorge', 'Gutiérrez', '555-3333');
INSERT INTO Empleados (id_ocupacion, nombre_empleado, apellido, telefono) VALUES (4, 'Elena', 'Méndez', '555-4444');
INSERT INTO Empleados (id_ocupacion, nombre_empleado, apellido, telefono) VALUES (5, 'Sofía', 'Vega', '555-5555');

--Insert Proveedores
INSERT INTO Proveedor (nombre_proveedor, correo, contacto, direccion) VALUES ('Alimentos del Valle', 'contacto@alimentosvalle.com', 'Juan Pérez', 'Av. Central 123');
INSERT INTO Proveedor (nombre_proveedor, correo, contacto, direccion) VALUES ('Distribuciones García', 'info@distribucionesgarcia.com', 'María García', 'Calle 45 67');
INSERT INTO Proveedor (nombre_proveedor, correo, contacto, direccion) VALUES ('Productos Rápidos', 'ventas@productosrapidos.com', 'Luis Martínez', 'Paseo Norte 89');
INSERT INTO Proveedor (nombre_proveedor, correo, contacto, direccion) VALUES ('Servicios Alimentarios', 'servicio@alimentarios.com', 'Ana López', 'Blvd. Sur 345');
INSERT INTO Proveedor (nombre_proveedor, correo, contacto, direccion) VALUES ('Comercial del Este', 'contacto@comercialdeleste.com', 'Pedro Ruiz', 'Plaza Mayor 12');

---Insert Categorias
INSERT INTO Categorias (nombre_categoria) VALUES ('Bebidas');
INSERT INTO Categorias (nombre_categoria) VALUES ('Aperitivos');
INSERT INTO Categorias (nombre_categoria) VALUES ('Platos Principales');
INSERT INTO Categorias (nombre_categoria) VALUES ('Postres');
INSERT INTO Categorias (nombre_categoria) VALUES ('Complementos');


--Insert Productos
INSERT INTO Productos (id_categoria, id_proveedor, nombre_producto, inventario) VALUES (1, 1, 'Jugo de Naranja', 100);
INSERT INTO Productos (id_categoria, id_proveedor, nombre_producto, inventario) VALUES (2, 2, 'Chips de Patata', 200);
INSERT INTO Productos (id_categoria, id_proveedor, nombre_producto, inventario) VALUES (3, 3, 'Pizza Margarita', 50);
INSERT INTO Productos (id_categoria, id_proveedor, nombre_producto, inventario) VALUES (4, 4, 'Tarta de Chocolate', 30);
INSERT INTO Productos (id_categoria, id_proveedor, nombre_producto, inventario) VALUES (5, 5, 'Aceite de Oliva', 80);

-----Insert Ventas
INSERT INTO Ventas (id_producto, monto_v) VALUES (1, 1500);
INSERT INTO Ventas (id_producto, monto_v) VALUES (2, 800);
INSERT INTO Ventas (id_producto, monto_v) VALUES (3, 2000);
INSERT INTO Ventas (id_producto, monto_v) VALUES (4, 1200);
INSERT INTO Ventas (id_producto, monto_v) VALUES (5, 1000);

--Insert Servicios
INSERT INTO Servicios (monto_s) VALUES (500);
INSERT INTO Servicios (monto_s) VALUES (300);
INSERT INTO Servicios (monto_s) VALUES (700);
INSERT INTO Servicios (monto_s) VALUES (450);
INSERT INTO Servicios (monto_s) VALUES (600);


-- Finalización de transacción
COMMIT;

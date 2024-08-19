/*ALTER TABLE SERVICIOS
ADD servicio VARCHAR2(50);

ALTER TABLE EMPLEADOS
ADD salario NUMBER;

COMMIT;

ALTER TABLE PRODUCTOS
ADD precio_venta NUMBER;

ALTER TABLE PRODUCTOS
ADD precio_compra NUMBER;

COMMIT;

ALTER TABLE EMPLEADOS
ADD salario NUMBER;

COMMIT;

ALTER TABLE VENTAS
ADD(
id_cliente NUMBER,
id_servicio NUMBER,
cantidad NUMBER,
total NUMBER,
fecha DATE
);

ALTER TABLE VENTAS
DROP COLUMN MONTO_V;

ALTER TABLE VENTAS
ADD CONSTRAINT fk_cliente_venta
FOREIGN KEY (id_cliente) REFERENCES CLIENTES(ID_CLIENTE);

ALTER TABLE VENTAS
ADD CONSTRAINT fk_servicio_venta
FOREIGN KEY (id_servicio) REFERENCES SERVICIOS(ID_SERVICIO);

COMMIT;*/

/* ------------------ESQUEMA--------------*/
-- Creacion de secuencias
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

-- Creacion de las tablas

-- Tabla Clientes
CREATE TABLE Clientes (
    id_cliente NUMBER DEFAULT seq_clientes.NEXTVAL PRIMARY KEY,
    nombre_cliente VARCHAR2(100),
    telefono VARCHAR2(20),
    numero VARCHAR2(20)
);

-- Tabla Reservaciones
CREATE TABLE Reservaciones (
    id_reservacion NUMBER DEFAULT seq_reservaciones.NEXTVAL PRIMARY KEY,
    id_cliente NUMBER,
    cantidad NUMBER,
    dia DATE,
    FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente)
);

-- Tabla Ocupaciones
CREATE TABLE Ocupaciones (
    id_ocupacion NUMBER DEFAULT seq_ocupaciones.NEXTVAL PRIMARY KEY,
    nombre_ocupacion VARCHAR2(100),
    cantidad_empleados NUMBER
);

-- Tabla Empleados
CREATE TABLE Empleados (
    id_empleado NUMBER DEFAULT seq_empleados.NEXTVAL PRIMARY KEY,
    id_ocupacion NUMBER,
    nombre_empleado VARCHAR2(100),
    apellido VARCHAR2(100),
    telefono VARCHAR2(20),
    salario NUMBER, -- after alter
    FOREIGN KEY (id_ocupacion) REFERENCES Ocupaciones(id_ocupacion)
);

-- Tabla Proveedor
CREATE TABLE Proveedor (
    id_proveedor NUMBER DEFAULT seq_proveedor.NEXTVAL PRIMARY KEY,
    nombre_proveedor VARCHAR2(100),
    correo VARCHAR2(100),
    contacto VARCHAR2(50),
    direccion VARCHAR2(200)
);

-- Tabla Categorias
CREATE TABLE Categorias (
    id_categoria NUMBER DEFAULT seq_categorias.NEXTVAL PRIMARY KEY,
    nombre_categoria VARCHAR2(100)
);

-- Tabla Productos
CREATE TABLE Productos (
    id_producto NUMBER DEFAULT seq_productos.NEXTVAL PRIMARY KEY,
    id_categoria NUMBER,
    id_proveedor NUMBER,
    nombre_producto VARCHAR2(100),
    inventario NUMBER,
    precio_venta NUMBER, -- after alter
    precio_compra NUMBER, -- after alter
    FOREIGN KEY (id_categoria) REFERENCES Categorias(id_categoria),
    FOREIGN KEY (id_proveedor) REFERENCES Proveedor(id_proveedor)
);

-- Tabla Ventas
CREATE TABLE Ventas (
    id_venta NUMBER DEFAULT seq_ventas.NEXTVAL PRIMARY KEY,
    id_producto NUMBER,
    id_cliente NUMBER, -- after altern
    id_servicio NUMBER, -- after alter
    cantidad NUMBER, -- after alter
    total NUMBER, -- after alter
    fecha DATE, -- after alter
    FOREIGN KEY (id_producto) REFERENCES Productos(id_producto),
    FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente), -- after alter
    FOREIGN KEY (id_servicio) REFERENCES Servicios(id_servicio) -- after alter
);

-- Tabla Servicios
CREATE TABLE Servicios (
    id_servicio NUMBER DEFAULT seq_servicios.NEXTVAL PRIMARY KEY,
    monto_s NUMBER,
    servicio VARCHAR2(50) -- after alter
);

-- Guardado de cambios
COMMIT;

/* Procedimientos almacenados con Rollback y Lista */
/* -----------------CATEGORIAS-----------------*/
    --insert
CREATE OR REPLACE PROCEDURE sp_insert_categoria (
    p_nombre_categoria IN VARCHAR2
) AS
BEGIN
    INSERT INTO Categorias (nombre_categoria)
    VALUES (p_nombre_categoria);
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE_APPLICATION_ERROR(-20001, 'Error al insertar en la tabla Categorias: ' || SQLERRM);
END;

    --update
CREATE OR REPLACE PROCEDURE sp_update_categoria (
    p_id_categoria IN NUMBER,
    p_nombre_categoria IN VARCHAR2
) AS
BEGIN
    UPDATE Categorias
    SET nombre_categoria = p_nombre_categoria
    WHERE id_categoria = p_id_categoria;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE_APPLICATION_ERROR(-20002, 'Error al actualizar en la tabla Categorias: ' || SQLERRM);
END;

    --delete
CREATE OR REPLACE PROCEDURE sp_delete_categoria (
    p_id_categoria IN NUMBER
) AS
BEGIN
    DELETE FROM Categorias
    WHERE id_categoria = p_id_categoria;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE_APPLICATION_ERROR(-20003, 'Error al eliminar de la tabla Categorias: ' || SQLERRM);
END;

    --read
CREATE OR REPLACE PROCEDURE sp_listar_categorias(
    p_categorias OUT SYS_REFCURSOR
) AS
BEGIN
    OPEN p_categorias FOR
    SELECT id_categoria, nombre_categoria
    FROM Categorias;
END;

/* -----------------CLIENTES-----------------*/
    --create
    CREATE OR REPLACE PROCEDURE sp_insert_cliente (
    p_nombre_cliente IN VARCHAR2,
    p_telefono IN VARCHAR2,
    p_numero IN VARCHAR2
) AS
BEGIN
    INSERT INTO Clientes (nombre_cliente, telefono, numero)
    VALUES (p_nombre_cliente, p_telefono, p_numero);
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE_APPLICATION_ERROR(-20001, 'Error al insertar en la tabla Clientes: ' || SQLERRM);
END;

    --read
CREATE OR REPLACE PROCEDURE sp_listar_clientes (
    p_clientes OUT SYS_REFCURSOR
) AS
BEGIN
    OPEN p_clientes FOR
    SELECT id_cliente, nombre_cliente, telefono, numero
    FROM Clientes;
END;

    --update
CREATE OR REPLACE PROCEDURE sp_update_cliente (
    p_id_cliente IN NUMBER,
    p_nombre_cliente IN VARCHAR2,
    p_telefono IN VARCHAR2,
    p_numero IN VARCHAR2
) AS
BEGIN
    UPDATE Clientes
    SET nombre_cliente = p_nombre_cliente,
        telefono = p_telefono,
        numero = p_numero
    WHERE id_cliente = p_id_cliente;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE_APPLICATION_ERROR(-20002, 'Error al actualizar en la tabla Clientes: ' || SQLERRM);
END;

    --delete
CREATE OR REPLACE PROCEDURE sp_delete_cliente (
    p_id_cliente IN NUMBER
) AS
BEGIN
    DELETE FROM Clientes
    WHERE id_cliente = p_id_cliente;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE_APPLICATION_ERROR(-20003, 'Error al eliminar de la tabla Clientes: ' || SQLERRM);
END;

/* -----------------EMPLEADOS-----------------*/
    --create
    CREATE OR REPLACE PROCEDURE sp_insert_empleado (
    p_id_ocupacion IN NUMBER,
    p_nombre_empleado IN VARCHAR2,
    p_apellido IN VARCHAR2,
    p_telefono IN VARCHAR2,
    p_salario IN NUMBER
) AS
BEGIN
    INSERT INTO Empleados (id_ocupacion, nombre_empleado, apellido, telefono, salario)
    VALUES (p_id_ocupacion, p_nombre_empleado, p_apellido, p_telefono, p_salario);
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE_APPLICATION_ERROR(-20001, 'Error al insertar en la tabla Empleados: ' || SQLERRM);
END;

    --read
CREATE OR REPLACE PROCEDURE sp_listar_empleados (
    p_empleados OUT SYS_REFCURSOR
) AS
BEGIN
    OPEN p_empleados FOR
    SELECT id_empleado, id_ocupacion, nombre_empleado, apellido, telefono, salario
    FROM Empleados;
END;

    --update
CREATE OR REPLACE PROCEDURE sp_update_empleado (
    p_id_empleado IN NUMBER,
    p_id_ocupacion IN NUMBER,
    p_nombre_empleado IN VARCHAR2,
    p_apellido IN VARCHAR2,
    p_telefono IN VARCHAR2,
    p_salario IN NUMBER
) AS
BEGIN
    UPDATE Empleados
    SET id_ocupacion = p_id_ocupacion,
        nombre_empleado = p_nombre_empleado,
        apellido = p_apellido,
        telefono = p_telefono,
        salario = p_salario
    WHERE id_empleado = p_id_empleado;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE_APPLICATION_ERROR(-20002, 'Error al actualizar en la tabla Empleados: ' || SQLERRM);
END;

    --delete
CREATE OR REPLACE PROCEDURE sp_delete_empleado (
    p_id_empleado IN NUMBER
) AS
BEGIN
    DELETE FROM Empleados
    WHERE id_empleado = p_id_empleado;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE_APPLICATION_ERROR(-20003, 'Error al eliminar de la tabla Empleados: ' || SQLERRM);
END;

/* -----------------OCUPACIONES-----------------*/
    --create
CREATE OR REPLACE PROCEDURE sp_insertar_ocupacion (
    p_nombre_ocupacion IN VARCHAR2,
    p_cantidad_empleados IN NUMBER
) AS
BEGIN
    INSERT INTO Ocupaciones (nombre_ocupacion, cantidad_empleados)
    VALUES (p_nombre_ocupacion, p_cantidad_empleados);
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE_APPLICATION_ERROR(-20001, 'Error al insertar en la tabla Ocupaciones: ' || SQLERRM);
END;

    --read
CREATE OR REPLACE PROCEDURE sp_listar_ocupaciones (
    p_ocupaciones OUT SYS_REFCURSOR
) AS
BEGIN
    OPEN p_ocupaciones FOR
    SELECT id_ocupacion, nombre_ocupacion, cantidad_empleados
    FROM Ocupaciones;
END;

    --update
CREATE OR REPLACE PROCEDURE sp_actualizar_ocupacion (
    p_id_ocupacion IN NUMBER,
    p_nombre_ocupacion IN VARCHAR2,
    p_cantidad_empleados IN NUMBER
) AS
BEGIN
    UPDATE Ocupaciones
    SET nombre_ocupacion = p_nombre_ocupacion,
        cantidad_empleados = p_cantidad_empleados
    WHERE id_ocupacion = p_id_ocupacion;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE_APPLICATION_ERROR(-20002, 'Error al actualizar en la tabla Ocupaciones: ' || SQLERRM);
END;

    --delete
    CREATE OR REPLACE PROCEDURE sp_eliminar_ocupacion (
    p_id_ocupacion IN NUMBER
) AS
BEGIN
    DELETE FROM Ocupaciones
    WHERE id_ocupacion = p_id_ocupacion;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE_APPLICATION_ERROR(-20003, 'Error al eliminar de la tabla Ocupaciones: ' || SQLERRM);
END;

/* -----------------PRODUCTOS-----------------*/
    CREATE OR REPLACE PROCEDURE sp_insertar_producto (
    p_id_categoria IN NUMBER,
    p_id_proveedor IN NUMBER,
    p_nombre_producto IN VARCHAR2,
    p_inventario IN NUMBER,
    p_precio_venta IN NUMBER,
    p_precio_compra IN NUMBER
) AS
BEGIN
    INSERT INTO Productos (id_categoria, id_proveedor, nombre_producto, inventario, precio_venta, precio_compra)
    VALUES (p_id_categoria, p_id_proveedor, p_nombre_producto, p_inventario, p_precio_venta, p_precio_compra);
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE_APPLICATION_ERROR(-20001, 'Error al insertar en la tabla Productos: ' || SQLERRM);
END;
/

CREATE OR REPLACE PROCEDURE sp_actualizar_producto (
    p_id_producto IN NUMBER,
    p_id_categoria IN NUMBER,
    p_id_proveedor IN NUMBER,
    p_nombre_producto IN VARCHAR2,
    p_inventario IN NUMBER,
    p_precio_venta IN NUMBER,
    p_precio_compra IN NUMBER
) AS
BEGIN
    UPDATE Productos
    SET id_categoria = p_id_categoria,
        id_proveedor = p_id_proveedor,
        nombre_producto = p_nombre_producto,
        inventario = p_inventario,
        precio_venta = p_precio_venta,
        precio_compra = p_precio_compra
    WHERE id_producto = p_id_producto;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE_APPLICATION_ERROR(-20002, 'Error al actualizar en la tabla Productos: ' || SQLERRM);
END;
/

CREATE OR REPLACE PROCEDURE sp_listar_productos (
    p_productos OUT SYS_REFCURSOR
) AS
BEGIN
    OPEN p_productos FOR
    SELECT id_producto, id_categoria, id_proveedor, nombre_producto, inventario, precio_venta, precio_compra
    FROM Productos;
END;
/

COMMIT;

    --delete
CREATE OR REPLACE PROCEDURE sp_eliminar_producto (
    p_id_producto IN NUMBER
) AS
BEGIN
    DELETE FROM Productos
    WHERE id_producto = p_id_producto;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE_APPLICATION_ERROR(-20003, 'Error al eliminar de la tabla Productos: ' || SQLERRM);
END;

/* -----------------PROVEEDORES-----------------*/
    --create
CREATE OR REPLACE PROCEDURE sp_insertar_proveedor (
    p_nombre_proveedor IN VARCHAR2,
    p_correo IN VARCHAR2,
    p_contacto IN VARCHAR2,
    p_direccion IN VARCHAR2
) AS
BEGIN
    INSERT INTO Proveedor (nombre_proveedor, correo, contacto, direccion)
    VALUES (p_nombre_proveedor, p_correo, p_contacto, p_direccion);
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE_APPLICATION_ERROR(-20001, 'Error al insertar en la tabla Proveedor: ' || SQLERRM);
END;

    --read
CREATE OR REPLACE PROCEDURE sp_listar_proveedores (
    p_proveedores OUT SYS_REFCURSOR
) AS
BEGIN
    OPEN p_proveedores FOR
    SELECT id_proveedor, nombre_proveedor, correo, contacto, direccion
    FROM Proveedor;
END;

    --update
CREATE OR REPLACE PROCEDURE sp_actualizar_proveedor (
    p_id_proveedor IN NUMBER,
    p_nombre_proveedor IN VARCHAR2,
    p_correo IN VARCHAR2,
    p_contacto IN VARCHAR2,
    p_direccion IN VARCHAR2
) AS
BEGIN
    UPDATE Proveedor
    SET nombre_proveedor = p_nombre_proveedor,
        correo = p_correo,
        contacto = p_contacto,
        direccion = p_direccion
    WHERE id_proveedor = p_id_proveedor;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE_APPLICATION_ERROR(-20002, 'Error al actualizar en la tabla Proveedor: ' || SQLERRM);
END;

    --delete
CREATE OR REPLACE PROCEDURE sp_eliminar_proveedor (
    p_id_proveedor IN NUMBER
) AS
BEGIN
    DELETE FROM Proveedor
    WHERE id_proveedor = p_id_proveedor;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE_APPLICATION_ERROR(-20003, 'Error al eliminar de la tabla Proveedor: ' || SQLERRM);
END;

/* -----------------RESERVACIONES-----------------*/
    --create
CREATE OR REPLACE PROCEDURE sp_insertar_reservacion (
    p_id_cliente IN NUMBER,
    p_cantidad IN NUMBER,
    p_dia IN DATE
) AS
BEGIN
    INSERT INTO Reservaciones (id_reservacion, id_cliente, cantidad, dia)
    VALUES (seq_reservaciones.NEXTVAL, p_id_cliente, p_cantidad, p_dia);
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE_APPLICATION_ERROR(-20001, 'Error al insertar en la tabla Reservaciones: ' || SQLERRM);
END;

    --read
CREATE OR REPLACE PROCEDURE sp_listar_reservaciones (
    p_reservaciones OUT SYS_REFCURSOR
) AS
BEGIN
    OPEN p_reservaciones FOR
    SELECT id_reservacion, id_cliente, cantidad, dia
    FROM Reservaciones;
END;

    --update
CREATE OR REPLACE PROCEDURE sp_actualizar_reservacion (
    p_id_reservacion IN NUMBER,
    p_id_cliente IN NUMBER,
    p_cantidad IN NUMBER,
    p_dia IN DATE
) AS
BEGIN
    UPDATE Reservaciones
    SET id_cliente = p_id_cliente,
        cantidad = p_cantidad,
        dia = p_dia
    WHERE id_reservacion = p_id_reservacion;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE_APPLICATION_ERROR(-20002, 'Error al actualizar en la tabla Reservaciones: ' || SQLERRM);
END;

    --delete
CREATE OR REPLACE PROCEDURE sp_eliminar_reservacion (
    p_id_reservacion IN NUMBER
) AS
BEGIN
    DELETE FROM Reservaciones
    WHERE id_reservacion = p_id_reservacion;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE_APPLICATION_ERROR(-20003, 'Error al eliminar de la tabla Reservaciones: ' || SQLERRM);
END;

/* -----------------SERVICIOS-----------------*/
    --create
CREATE OR REPLACE PROCEDURE sp_insertar_servicio (
    p_monto_s IN NUMBER,
    p_servicio IN VARCHAR2
) AS
BEGIN
    INSERT INTO Servicios (id_servicio, monto_s, servicio)
    VALUES (seq_servicios.NEXTVAL, p_monto_s, p_servicio);
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE_APPLICATION_ERROR(-20001, 'Error al insertar en la tabla Servicios: ' || SQLERRM);
END;

    --read
CREATE OR REPLACE PROCEDURE sp_listar_servicios (
    p_servicios OUT SYS_REFCURSOR
) AS
BEGIN
    OPEN p_servicios FOR
    SELECT id_servicio, monto_s, servicio
    FROM Servicios;
END;

    --update
CREATE OR REPLACE PROCEDURE sp_actualizar_servicio (
    p_id_servicio IN NUMBER,
    p_monto_s IN NUMBER,
    p_servicio IN VARCHAR2
) AS
BEGIN
    UPDATE Servicios
    SET monto_s = p_monto_s,
        servicio = p_servicio
    WHERE id_servicio = p_id_servicio;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE_APPLICATION_ERROR(-20002, 'Error al actualizar en la tabla Servicios: ' || SQLERRM);
END;

    --delete
CREATE OR REPLACE PROCEDURE sp_eliminar_servicio (
    p_id_servicio IN NUMBER
) AS
BEGIN
    DELETE FROM Servicios
    WHERE id_servicio = p_id_servicio;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE_APPLICATION_ERROR(-20003, 'Error al eliminar de la tabla Servicios: ' || SQLERRM);
END;

/* -----------------VENTAS-----------------*/
    --create
    CREATE OR REPLACE PROCEDURE sp_insertar_venta (
    p_id_producto IN NUMBER,
    p_total IN NUMBER,
    p_id_cliente IN NUMBER,
    p_id_servicio IN NUMBER,
    p_cantidad IN NUMBER,
    p_fecha IN DATE
) AS
BEGIN
    INSERT INTO Ventas (id_venta, id_producto, total, id_cliente, id_servicio, cantidad, fecha)
    VALUES (seq_ventas.NEXTVAL, p_id_producto, p_total, p_id_cliente, p_id_servicio, p_cantidad, p_fecha);
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE_APPLICATION_ERROR(-20001, 'Error al insertar en la tabla Ventas: ' || SQLERRM);
END;

    --read
CREATE OR REPLACE PROCEDURE sp_listar_ventas (
    p_ventas OUT SYS_REFCURSOR
) AS
BEGIN
    OPEN p_ventas FOR
    SELECT id_venta, id_producto, total, id_cliente, id_servicio, cantidad, fecha
    FROM Ventas;
END;

    --update
CREATE OR REPLACE PROCEDURE sp_actualizar_venta (
    p_id_venta IN NUMBER,
    p_id_producto IN NUMBER,
    p_total IN NUMBER,
    p_id_cliente IN NUMBER,
    p_id_servicio IN NUMBER,
    p_cantidad IN NUMBER,
    p_fecha IN DATE
) AS
BEGIN
    UPDATE Ventas
    SET id_producto = p_id_producto,
        total = p_total,
        id_cliente = p_id_cliente,
        id_servicio = p_id_servicio,
        cantidad = p_cantidad,
        fecha = p_fecha
    WHERE id_venta = p_id_venta;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE_APPLICATION_ERROR(-20002, 'Error al actualizar en la tabla Ventas: ' || SQLERRM);
END;

    --delete
CREATE OR REPLACE PROCEDURE sp_eliminar_venta (
    p_id_venta IN NUMBER
) AS
BEGIN
    DELETE FROM Ventas
    WHERE id_venta = p_id_venta;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE_APPLICATION_ERROR(-20003, 'Error al eliminar de la tabla Ventas: ' || SQLERRM);
END;


-- Creaci�n de secuencias
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

-- Creaci�n de la tabla Clientes
CREATE TABLE Clientes (
    id_cliente NUMBER DEFAULT seq_clientes.NEXTVAL PRIMARY KEY,
    nombre_cliente VARCHAR2(100),
    telefono VARCHAR2(20),
    numero VARCHAR2(20)
);

-- Creaci�n de la tabla Reservaciones
CREATE TABLE Reservaciones (
    id_reservacion NUMBER DEFAULT seq_reservaciones.NEXTVAL PRIMARY KEY,
    id_cliente NUMBER,
    cantidad NUMBER,
    dia DATE,
    FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente)
);

-- Creaci�n de la tabla Ocupaciones
CREATE TABLE Ocupaciones (
    id_ocupacion NUMBER DEFAULT seq_ocupaciones.NEXTVAL PRIMARY KEY,
    nombre_ocupacion VARCHAR2(100),
    cantidad_empleados NUMBER
);

-- Creaci�n de la tabla Empleados
CREATE TABLE Empleados (
    id_empleado NUMBER DEFAULT seq_empleados.NEXTVAL PRIMARY KEY,
    id_ocupacion NUMBER,
    nombre_empleado VARCHAR2(100),
    apellido VARCHAR2(100),
    telefono VARCHAR2(20),
    FOREIGN KEY (id_ocupacion) REFERENCES Ocupaciones(id_ocupacion)
);

-- Finalizaci�n de transacci�n
COMMIT;

-- ////////////////////////////////

-- Creaci�n de secuencias (si es necesario)
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

-- Creaci�n de la tabla Proveedor
CREATE TABLE Proveedor (
    id_proveedor NUMBER DEFAULT seq_proveedor.NEXTVAL PRIMARY KEY,
    nombre_proveedor VARCHAR2(100),
    correo VARCHAR2(100),
    contacto VARCHAR2(50),
    direccion VARCHAR2(200)
);

-- Creaci�n de la tabla Categorias
CREATE TABLE Categorias (
    id_categoria NUMBER DEFAULT seq_categorias.NEXTVAL PRIMARY KEY,
    nombre_categoria VARCHAR2(100)
);

-- Creaci�n de la tabla Productos
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

-- Creaci�n de la tabla Ventas
CREATE TABLE Ventas (
    id_venta NUMBER DEFAULT seq_ventas.NEXTVAL PRIMARY KEY,
    id_producto NUMBER,
    monto_v NUMBER,
    CONSTRAINT fk_producto_venta
        FOREIGN KEY (id_producto)
        REFERENCES Productos(id_producto)
);

-- Creaci�n de la tabla Servicios
CREATE TABLE Servicios (
    id_servicio NUMBER DEFAULT seq_servicios.NEXTVAL PRIMARY KEY,
    monto_s NUMBER
);


--Insert Clientes
INSERT INTO Clientes (nombre_cliente, telefono, numero) VALUES ('Ana Gonz�lez', '555-1234', 'A123');
INSERT INTO Clientes (nombre_cliente, telefono, numero) VALUES ('Luis Fern�ndez', '555-5678', 'B456');
INSERT INTO Clientes (nombre_cliente, telefono, numero) VALUES ('Mar�a L�pez', '555-8765', 'C789');
INSERT INTO Clientes (nombre_cliente, telefono, numero) VALUES ('Pedro Mart�nez', '555-4321', 'D012');
INSERT INTO Clientes (nombre_cliente, telefono, numero) VALUES ('Laura Ram�rez', '555-6789', 'E345');

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
INSERT INTO Empleados (id_ocupacion, nombre_empleado, apellido, telefono) VALUES (1, 'Carlos', 'S�nchez', '555-1111');
INSERT INTO Empleados (id_ocupacion, nombre_empleado, apellido, telefono) VALUES (2, 'Marta', 'Torres', '555-2222');
INSERT INTO Empleados (id_ocupacion, nombre_empleado, apellido, telefono) VALUES (3, 'Jorge', 'Guti�rrez', '555-3333');
INSERT INTO Empleados (id_ocupacion, nombre_empleado, apellido, telefono) VALUES (4, 'Elena', 'M�ndez', '555-4444');
INSERT INTO Empleados (id_ocupacion, nombre_empleado, apellido, telefono) VALUES (5, 'Sof�a', 'Vega', '555-5555');

--Insert Proveedores
INSERT INTO Proveedor (nombre_proveedor, correo, contacto, direccion) VALUES ('Alimentos del Valle', 'contacto@alimentosvalle.com', 'Juan P�rez', 'Av. Central 123');
INSERT INTO Proveedor (nombre_proveedor, correo, contacto, direccion) VALUES ('Distribuciones Garc�a', 'info@distribucionesgarcia.com', 'Mar�a Garc�a', 'Calle 45 67');
INSERT INTO Proveedor (nombre_proveedor, correo, contacto, direccion) VALUES ('Productos R�pidos', 'ventas@productosrapidos.com', 'Luis Mart�nez', 'Paseo Norte 89');
INSERT INTO Proveedor (nombre_proveedor, correo, contacto, direccion) VALUES ('Servicios Alimentarios', 'servicio@alimentarios.com', 'Ana L�pez', 'Blvd. Sur 345');
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


-- Finalizaci�n de transacci�n
COMMIT;




ALTER TABLE SERVICIOS
ADD servicio VARCHAR2(50);

ALTER TABLE EMPLEADOS
ADD salario NUMBER;

COMMIT;

ALTER TABLE PRODUCTOS
ADD precio_venta NUMBER;

ALTER TABLE PRODUCTOS
ADD precio_compra NUMBER;

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

COMMIT;

/*creacion de procedimientos almacenados tabblas CATEGORIAS,CLIENTES Y EMPLEADOS*/



/*creacion de procedimientos almacenados tabblas CATEGORIAS,CLIENTES Y EMPLEADOS*/


/*CATEGORIAS*/
CREATE OR REPLACE PROCEDURE sp_insert_categoria (
    p_nombre_categoria IN VARCHAR2
) AS
BEGIN
    INSERT INTO Categorias (nombre_categoria)
    VALUES (p_nombre_categoria);
    COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE sp_update_categoria (
    p_id_categoria IN NUMBER,
    p_nombre_categoria IN VARCHAR2
) AS
BEGIN
    UPDATE Categorias
    SET nombre_categoria = p_nombre_categoria
    WHERE id_categoria = p_id_categoria;
    COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE sp_delete_categoria (
    p_id_categoria IN NUMBER
) AS
BEGIN
    DELETE FROM Categorias
    WHERE id_categoria = p_id_categoria;
    COMMIT;
END;
/

/*CLIENTES*/
CREATE OR REPLACE PROCEDURE sp_insert_cliente (
    p_nombre_cliente IN VARCHAR2,
    p_telefono IN VARCHAR2,
    p_numero IN VARCHAR2
) AS
BEGIN
    INSERT INTO Clientes (nombre_cliente, telefono, numero)
    VALUES (p_nombre_cliente, p_telefono, p_numero);
    COMMIT;
END;
/
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
END;
/
CREATE OR REPLACE PROCEDURE sp_delete_cliente (
    p_id_cliente IN NUMBER
) AS
BEGIN
    DELETE FROM Clientes
    WHERE id_cliente = p_id_cliente;
    COMMIT;
END;
/
-----------------------------------
/*EMPLEADOS*/
create or replace NONEDITIONABLE PROCEDURE sp_insert_empleado (
    p_id_ocupacion IN NUMBER,
    p_nombre_empleado IN VARCHAR2,
    p_apellido IN VARCHAR2,
    p_telefono IN VARCHAR2
) AS
BEGIN
    INSERT INTO Empleados (id_ocupacion, nombre_empleado, apellido, telefono)
    VALUES (p_id_ocupacion, p_nombre_empleado, p_apellido, p_telefono);
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE sp_update_empleado (
    p_id_empleado IN NUMBER,
    p_id_ocupacion IN NUMBER,
    p_nombre_empleado IN VARCHAR2,
    p_apellido IN VARCHAR2,
    p_telefono IN VARCHAR2
) AS
BEGIN
    UPDATE Empleados
    SET id_ocupacion = p_id_ocupacion,
        nombre_empleado = p_nombre_empleado,
        apellido = p_apellido,
        telefono = p_telefono
    WHERE id_empleado = p_id_empleado;
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE sp_delete_empleado (
    p_id_empleado IN NUMBER
) AS
BEGIN
    DELETE FROM Empleados
    WHERE id_empleado = p_id_empleado;
    COMMIT;
END;
/
--Insertar ocupaciones
CREATE OR REPLACE PROCEDURE InsertarOcupacion(
    p_nombre_ocupacion IN VARCHAR2,
    p_cantidad_empleados IN NUMBER
)
AS
BEGIN
    INSERT INTO Ocupaciones (nombre_ocupacion, cantidad_empleados)
    VALUES (p_nombre_ocupacion, p_cantidad_empleados);
    COMMIT;
END;
/
--Actualizar ocupaciones
CREATE OR REPLACE PROCEDURE ActualizarOcupacion(
    p_id_ocupacion IN NUMBER,
    p_nombre_ocupacion IN VARCHAR2,
    p_cantidad_empleados IN NUMBER
)
AS
BEGIN
    UPDATE Ocupaciones
    SET nombre_ocupacion = p_nombre_ocupacion,
        cantidad_empleados = p_cantidad_empleados
    WHERE id_ocupacion = p_id_ocupacion;
    COMMIT;
END;
/

--Eliminar ocupaciones
CREATE OR REPLACE PROCEDURE EliminarOcupacion(
    p_id_ocupacion IN NUMBER
)
AS
BEGIN
    DELETE FROM Ocupaciones
    WHERE id_ocupacion = p_id_ocupacion;
    COMMIT;
END;
/
--Insertar productos
CREATE OR REPLACE PROCEDURE InsertarProducto(
    p_id_categoria IN NUMBER,
    p_id_proveedor IN NUMBER,
    p_nombre_producto IN VARCHAR2,
    p_inventario IN NUMBER
)
AS
BEGIN
    INSERT INTO Productos (id_categoria, id_proveedor, nombre_producto, inventario)
    VALUES (p_id_categoria, p_id_proveedor, p_nombre_producto, p_inventario);
    COMMIT;
END;
/

--Actualizar productos
CREATE OR REPLACE PROCEDURE ActualizarProducto(
    p_id_producto IN NUMBER,
    p_id_categoria IN NUMBER,
    p_id_proveedor IN NUMBER,
    p_nombre_producto IN VARCHAR2,
    p_inventario IN NUMBER
)
AS
BEGIN
    UPDATE Productos
    SET id_categoria = p_id_categoria,
        id_proveedor = p_id_proveedor,
        nombre_producto = p_nombre_producto,
        inventario = p_inventario
    WHERE id_producto = p_id_producto;
    COMMIT;
END;
/

--Eliminar productos
CREATE OR REPLACE PROCEDURE EliminarProducto(
    p_id_producto IN NUMBER
)
AS
BEGIN
    DELETE FROM Productos
    WHERE id_producto = p_id_producto;
    COMMIT;
END;
/


--Insertar proveedor
CREATE OR REPLACE PROCEDURE InsertarProveedor(
    p_nombre_proveedor IN VARCHAR2,
    p_correo IN VARCHAR2,
    p_contacto IN VARCHAR2,
    p_direccion IN VARCHAR2
)
AS
BEGIN
    INSERT INTO Proveedor (nombre_proveedor, correo, contacto, direccion)
    VALUES (p_nombre_proveedor, p_correo, p_contacto, p_direccion);
    COMMIT;
END;
/

--Actualizar proveedor
CREATE OR REPLACE PROCEDURE ActualizarProveedor(
    p_id_proveedor IN NUMBER,
    p_nombre_proveedor IN VARCHAR2,
    p_correo IN VARCHAR2,
    p_contacto IN VARCHAR2,
    p_direccion IN VARCHAR2
)
AS
BEGIN
    UPDATE Proveedor
    SET nombre_proveedor = p_nombre_proveedor,
        correo = p_correo,
        contacto = p_contacto,
        direccion = p_direccion
    WHERE id_proveedor = p_id_proveedor;
    COMMIT;
END;
/

--Eliminar proveedor
CREATE OR REPLACE PROCEDURE EliminarProveedor(
    p_id_proveedor IN NUMBER
)
AS
BEGIN
    DELETE FROM Proveedor
    WHERE id_proveedor = p_id_proveedor;
    COMMIT;
END;
/
--Tabla reservaciones 


CREATE OR REPLACE PROCEDURE insertar_reservacion (
    v_id_cliente IN NUMBER,
    v_cantidad IN NUMBER,
    v_dia IN DATE
) AS
BEGIN
    INSERT INTO Reservaciones (id_reservacion, id_cliente, cantidad, dia)
    VALUES (seq_reservaciones.NEXTVAL, v_id_cliente, v_cantidad, v_dia);
    COMMIT;
    dbms_output.put_line('Reservación insertada.');
END insertar_reservacion;
/

CREATE OR REPLACE PROCEDURE actualizar_reservacion (
    v_id_reservacion IN NUMBER,
    v_id_cliente IN NUMBER,
    v_cantidad IN NUMBER,
    v_dia IN DATE
) AS
BEGIN
    UPDATE Reservaciones
    SET id_cliente = v_id_cliente,
        cantidad = v_cantidad,
        dia = v_dia
    WHERE id_reservacion = v_id_reservacion;
    COMMIT;
    dbms_output.put_line('Reservación actualizada.');
END actualizar_reservacion;
/

CREATE OR REPLACE PROCEDURE eliminar_reservacion (
    v_id_reservacion IN NUMBER
) AS
BEGIN
    DELETE FROM Reservaciones
    WHERE id_reservacion = v_id_reservacion;
    COMMIT;
    dbms_output.put_line('Reservación eliminada.');
END eliminar_reservacion;
/

--Tabla Servicios

CREATE OR REPLACE PROCEDURE insertar_servicio (
    v_monto_s IN NUMBER
) AS
BEGIN
    INSERT INTO Servicios (id_servicio, monto_s)
    VALUES (seq_servicios.NEXTVAL, v_monto_s);
    COMMIT;
    dbms_output.put_line('Servicio insertado.');
END insertar_servicio;
/



CREATE OR REPLACE PROCEDURE actualizar_servicio (
    v_id_servicio IN NUMBER,
    v_monto_s IN NUMBER
) AS
BEGIN
    UPDATE Servicios
    SET monto_s = v_monto_s
    WHERE id_servicio = v_id_servicio;
    COMMIT;
    dbms_output.put_line('Servicio actualizado.');
END actualizar_servicio;
/



CREATE OR REPLACE PROCEDURE eliminar_servicio (
    v_id_servicio IN NUMBER
) AS
BEGIN
    DELETE FROM Servicios
    WHERE id_servicio = v_id_servicio;
    COMMIT;
    dbms_output.put_line('Servicio eliminado.');
END eliminar_servicio;
/

--Tabla Ventas
-- Procedimiento para insertar una venta
CREATE OR REPLACE PROCEDURE insertar_venta (
    v_id_producto IN NUMBER,
    v_total IN NUMBER
) AS
BEGIN
    INSERT INTO Ventas (id_venta, id_producto, total)
    VALUES (seq_ventas.NEXTVAL, v_id_producto, v_total);
    COMMIT;
    dbms_output.put_line('Venta insertada.');
END insertar_venta;
/

-- Procedimiento para actualizar una venta
CREATE OR REPLACE PROCEDURE actualizar_venta (
    v_id_venta IN NUMBER,
    v_id_producto IN NUMBER,
    v_total IN NUMBER
) AS
BEGIN
    UPDATE Ventas
    SET id_producto = v_id_producto,
        total = v_total
    WHERE id_venta = v_id_venta;
    COMMIT;
    dbms_output.put_line('Venta actualizada.');
END actualizar_venta;
/



CREATE OR REPLACE PROCEDURE eliminar_venta (
    v_id_venta IN NUMBER
) AS
BEGIN
    DELETE FROM Ventas
    WHERE id_venta = v_id_venta;
    COMMIT;
    dbms_output.put_line('Venta eliminada.');
END eliminar_venta;
/


-- ------- ------ FUNCIONES ------ ------ ------ ----- -------- ------

-- KEISY --
-- Devuelve el total de ventas de un cliente especifico 
CREATE OR REPLACE FUNCTION obtener_total_ventas_cliente(
    p_cliente_id IN NUMBER
) RETURN NUMBER IS
    v_total NUMBER;
BEGIN
    SELECT SUM(v.total)
    INTO v_total
    FROM Ventas v
    WHERE v.id_cliente = p_cliente_id;

    RETURN NVL(v_total, 0);
END;
/



-- Devuelve el total de servicios asociados a una reservacion
CREATE OR REPLACE FUNCTION calcular_total_servicios
RETURN NUMBER IS
    v_total NUMBER;
BEGIN
    -- Calcula el total de todos los servicios
    SELECT SUM(monto_s)
    INTO v_total
    FROM Servicios;

    RETURN NVL(v_total, 0);
END;
/

-- Obtener la fecha de la última venta para un cliente
CREATE OR REPLACE FUNCTION obtener_fecha_venta_cliente(
    c_cliente_id IN NUMBER
) RETURN DATE IS
    v_fecha DATE;
BEGIN
    SELECT MAX(fecha)
    INTO v_fecha
    FROM Ventas
    WHERE id_cliente = c_cliente_id;

    RETURN v_fecha;
END;
/

-- Calcular el promedio de ventas global
CREATE OR REPLACE FUNCTION calcular_promedio_ventas_global
RETURN NUMBER IS
    v_promedio NUMBER;
BEGIN
    SELECT AVG(total)
    INTO v_promedio
    FROM Ventas;

    RETURN NVL(v_promedio, 0);
END;
/

-- Obtener las reservaciones de un cliente por su id
CREATE OR REPLACE FUNCTION TOTAL_RESERVACIONES_CLIENTE(
    p_cliente_id IN NUMBER
) RETURN NUMBER IS
    v_total_reservaciones NUMBER;
BEGIN
    SELECT COUNT(*)
    INTO v_total_reservaciones
    FROM RESERVACIONES
    WHERE id_cliente = p_cliente_id;

    RETURN v_total_reservaciones;
END;
/

--Johel--
-- 1. FunciÃ³n para obtener el nombre de una categorÃ­a por ID
CREATE OR REPLACE FUNCTION obtener_nombre_categoria(
    p_id_categoria IN NUMBER
) RETURN VARCHAR2 IS
    v_nombre_categoria VARCHAR2(100);
BEGIN
    SELECT nombre_categoria INTO v_nombre_categoria
    FROM Categorias
    WHERE id_categoria = p_id_categoria;
    
    RETURN v_nombre_categoria;
END;
/

-- 2. FunciÃ³n para contar el nÃºmero de clientes
CREATE OR REPLACE FUNCTION contar_clientes RETURN NUMBER IS
    v_num_clientes NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_num_clientes
    FROM Clientes;
    
    RETURN v_num_clientes;
END;
/

-- 3. FunciÃ³n para obtener el nombre de un empleado por ID
CREATE OR REPLACE FUNCTION obtener_nombre_empleado(
    p_id_empleado IN NUMBER
) RETURN VARCHAR2 IS
    v_nombre_empleado VARCHAR2(100);
BEGIN
    SELECT nombre_empleado INTO v_nombre_empleado
    FROM Empleados
    WHERE id_empleado = p_id_empleado;
    
    RETURN v_nombre_empleado;
END;
/

-- 4. FunciÃ³n para obtener el salario total de todos los empleados
CREATE OR REPLACE FUNCTION obtener_salario_total RETURN NUMBER IS
    v_salario_total NUMBER;
BEGIN
    SELECT SUM(salario) INTO v_salario_total
    FROM Empleados;
    
    RETURN v_salario_total;
END;
/

-- 5. FunciÃ³n para obtener el nombre de un proveedor por ID
CREATE OR REPLACE FUNCTION obtener_nombre_proveedor(
    p_id_proveedor IN NUMBER
) RETURN VARCHAR2 IS
    v_nombre_proveedor VARCHAR2(100);
BEGIN
    SELECT nombre_proveedor INTO v_nombre_proveedor
    FROM Proveedor
    WHERE id_proveedor = p_id_proveedor;
    
    RETURN v_nombre_proveedor;
END;
/


--Juan Carlos--
--1.FunciÃ³n que devuelve el nombre de una ocupaciÃ³n dado su ID
CREATE OR REPLACE FUNCTION obtener_nombre_ocupacion (
    p_id_ocupacion IN NUMBER
) RETURN VARCHAR2 IS
    v_nombre_ocupacion VARCHAR2(100);
BEGIN
    SELECT nombre_ocupacion
    INTO v_nombre_ocupacion
    FROM Ocupaciones
    WHERE id_ocupacion = p_id_ocupacion;

    RETURN v_nombre_ocupacion;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 'OcupaciÃ³n no encontrada';
    WHEN OTHERS THEN
        RETURN 'Error: ' || SQLERRM;
END;
/

--2. FunciÃ³n que cuenta el nÃºmero de productos en una categorÃ­a especÃ­fica
CREATE OR REPLACE FUNCTION contar_productos_categoria (
    p_id_categoria IN NUMBER
) RETURN NUMBER IS
    v_total NUMBER;
BEGIN
    SELECT COUNT(*)
    INTO v_total
    FROM Productos
    WHERE id_categoria = p_id_categoria;

    RETURN v_total; 
END;
/

--3. FunciÃ³n que verifica si un proveedor existe en la base de datos
CREATE OR REPLACE FUNCTION existe_proveedor (
    p_id_proveedor IN NUMBER
) RETURN BOOLEAN IS
    v_total NUMBER;
BEGIN
    SELECT COUNT(*)
    INTO v_total
    FROM Proveedor
    WHERE id_proveedor = p_id_proveedor;

    RETURN v_total > 0;
END;
/

--4. FunciÃ³n que devuelve el inventario total de un producto dado su ID
CREATE OR REPLACE FUNCTION obtener_inventario_producto (
    p_id_producto IN NUMBER
) RETURN NUMBER IS
    v_inventario NUMBER;
BEGIN
    SELECT inventario
    INTO v_inventario
    FROM Productos
    WHERE id_producto = p_id_producto;

    RETURN v_inventario;
END;
/

--5. FunciÃ³n para contar total de empleados
CREATE OR REPLACE FUNCTION contar_empleados
RETURN NUMBER IS
    v_num_empleados NUMBER;
BEGIN
    -- Contar el número total de empleados
    SELECT COUNT(*)
    INTO v_num_empleados
    FROM Empleados;

    RETURN v_num_empleados;
EXCEPTION
    WHEN OTHERS THEN
        RETURN 0; -- En caso de error en la consulta
END;
/

--6. Funcion para obetener el salario por ocupacion
CREATE OR REPLACE FUNCTION obtener_salario_total_ocupacion(
    p_id_ocupacion IN NUMBER
) RETURN NUMBER IS
    v_total NUMBER;
BEGIN
    SELECT SUM(salario)
    INTO v_total
    FROM Empleados
    WHERE id_ocupacion = p_id_ocupacion;

    RETURN NVL(v_total, 0);
END obtener_salario_total_ocupacion;
/


-- ---- ----- ------ ---- PAQUETES -- --------- ----- ----- -------

-- KEISY --
-- Paquete para servicios
CREATE OR REPLACE PACKAGE reservaciones_pkg IS
    FUNCTION calcular_total_servicios_general
    RETURN NUMBER;
END reservaciones_pkg;
/


-- Cuerpo del paquete
CREATE OR REPLACE PACKAGE BODY reservaciones_pkg IS
    FUNCTION calcular_total_servicios_general
    RETURN NUMBER IS
        v_total NUMBER;
    BEGIN
        -- Suma el monto total de todos los servicios
        SELECT SUM(monto_s)
        INTO v_total
        FROM Servicios;

        RETURN NVL(v_total, 0);
    END calcular_total_servicios_general;
END reservaciones_pkg;
/


-- Paquete para ventas
CREATE OR REPLACE PACKAGE ventas_pkg IS
    FUNCTION obtener_total_ventas_producto(
        p_producto_id IN NUMBER
    ) RETURN NUMBER;

    FUNCTION calcular_promedio_ventas_producto(
        p_producto_id IN NUMBER
    ) RETURN NUMBER;
END ventas_pkg;
/

-- Cuerpo del paquete
CREATE OR REPLACE PACKAGE BODY ventas_pkg IS
    FUNCTION obtener_total_ventas_producto(
        p_producto_id IN NUMBER
    ) RETURN NUMBER IS
        v_total NUMBER;
    BEGIN
        SELECT SUM(total)
        INTO v_total
        FROM Ventas
        WHERE id_producto = p_producto_id;

        RETURN NVL(v_total, 0);
    END obtener_total_ventas_producto;

    FUNCTION calcular_promedio_ventas_producto(
        p_producto_id IN NUMBER
    ) RETURN NUMBER IS
        v_promedio NUMBER;
    BEGIN
        SELECT AVG(total)
        INTO v_promedio
        FROM Ventas
        WHERE id_producto = p_producto_id;

        RETURN NVL(v_promedio, 0);
    END calcular_promedio_ventas_producto;
END ventas_pkg;
/




-- Paquete para reservaciones
CREATE OR REPLACE PACKAGE reservaciones_pkg IS
    FUNCTION obtener_cantidad_reservaciones_cliente(
        p_cliente_id IN NUMBER
    ) RETURN NUMBER;

    FUNCTION obtener_cantidad_reservaciones_fecha(
        p_dia IN DATE
    ) RETURN NUMBER;

    FUNCTION obtener_detalles_reservacion(
        p_reservacion_id IN NUMBER
    ) RETURN VARCHAR2;
END reservaciones_pkg;
/



-- Cuerpo del paquete
CREATE OR REPLACE PACKAGE BODY reservaciones_pkg IS
    FUNCTION obtener_cantidad_reservaciones_cliente(
        p_cliente_id IN NUMBER
    ) RETURN NUMBER IS
        v_cantidad NUMBER;
    BEGIN
        SELECT COUNT(*)
        INTO v_cantidad
        FROM Reservaciones
        WHERE id_cliente = p_cliente_id;

        RETURN NVL(v_cantidad, 0);
    END obtener_cantidad_reservaciones_cliente;

    FUNCTION obtener_cantidad_reservaciones_fecha(
        p_dia IN DATE
    ) RETURN NUMBER IS
        v_cantidad NUMBER;
    BEGIN
        SELECT COUNT(*)
        INTO v_cantidad
        FROM Reservaciones
        WHERE dia = p_dia;

        RETURN NVL(v_cantidad, 0);
    END obtener_cantidad_reservaciones_fecha;

    FUNCTION obtener_detalles_reservacion(
        p_reservacion_id IN NUMBER
    ) RETURN VARCHAR2 IS
        v_detalles VARCHAR2(4000);
    BEGIN
        SELECT 'ID: ' || id_reservacion || ', Cliente ID: ' || id_cliente || ', Cantidad: ' || cantidad || ', D� ' || dia
        INTO v_detalles
        FROM Reservaciones
        WHERE id_reservacion = p_reservacion_id;

        RETURN v_detalles;
    END obtener_detalles_reservacion;
END reservaciones_pkg;
/

--Paquete reservaciones
CREATE OR REPLACE PACKAGE reservaciones_totales_pkg IS
    FUNCTION obtener_total_reservaciones RETURN NUMBER;
    FUNCTION obtener_total_reservaciones_por_cliente(
        p_cliente_id IN NUMBER
    ) RETURN NUMBER;
END reservaciones_totales_pkg;
/

--cuerpo del paquete
CREATE OR REPLACE PACKAGE BODY reservaciones_totales_pkg IS
    FUNCTION obtener_total_reservaciones RETURN NUMBER IS
        v_total_reservaciones NUMBER;
    BEGIN
        SELECT COUNT(*)
        INTO v_total_reservaciones
        FROM Reservaciones;

        RETURN v_total_reservaciones;
    END obtener_total_reservaciones;

    FUNCTION obtener_total_reservaciones_por_cliente(
        p_cliente_id IN NUMBER
    ) RETURN NUMBER IS
        v_total_reservaciones NUMBER;
    BEGIN
        SELECT COUNT(*)
        INTO v_total_reservaciones
        FROM Reservaciones
        WHERE id_cliente = p_cliente_id;

        RETURN v_total_reservaciones;
    END obtener_total_reservaciones_por_cliente;
END reservaciones_totales_pkg;
/




-- JOHEL --

-- 1. Paquete para manejar operaciones de categorÃ­as
CREATE OR REPLACE PACKAGE pkg_categorias AS
    PROCEDURE sp_insert_categoria(p_nombre_categoria IN VARCHAR2);
    PROCEDURE sp_update_categoria(p_id_categoria IN NUMBER, p_nombre_categoria IN VARCHAR2);
    PROCEDURE sp_delete_categoria(p_id_categoria IN NUMBER);
    PROCEDURE sp_listar_categorias(p_categorias OUT SYS_REFCURSOR);
END pkg_categorias;
/

CREATE OR REPLACE PACKAGE BODY pkg_categorias AS
    PROCEDURE sp_insert_categoria(p_nombre_categoria IN VARCHAR2) IS
    BEGIN
        INSERT INTO Categorias (nombre_categoria)
        VALUES (p_nombre_categoria);
        COMMIT;
    EXCEPTION
        WHEN OTHERS THEN
            ROLLBACK;
            RAISE_APPLICATION_ERROR(-20001, 'Error al insertar en la tabla Categorias: ' || SQLERRM);
    END;

    PROCEDURE sp_update_categoria(p_id_categoria IN NUMBER, p_nombre_categoria IN VARCHAR2) IS
    BEGIN
        UPDATE Categorias
        SET nombre_categoria = p_nombre_categoria
        WHERE id_categoria = p_id_categoria;
        COMMIT;
    EXCEPTION
        WHEN OTHERS THEN
            ROLLBACK;
            RAISE_APPLICATION_ERROR(-20001, 'Error al actualizar en la tabla Categorias: ' || SQLERRM);
    END;

    PROCEDURE sp_delete_categoria(p_id_categoria IN NUMBER) IS
    BEGIN
        DELETE FROM Categorias
        WHERE id_categoria = p_id_categoria;
        COMMIT;
    EXCEPTION
        WHEN OTHERS THEN
            ROLLBACK;
            RAISE_APPLICATION_ERROR(-20001, 'Error al eliminar en la tabla Categorias: ' || SQLERRM);
    END;

    PROCEDURE sp_listar_categorias(p_categorias OUT SYS_REFCURSOR) IS
    BEGIN
        OPEN p_categorias FOR
        SELECT id_categoria, nombre_categoria
        FROM Categorias;
    END;
END pkg_categorias;
/

-- 2. Paquete para manejar operaciones de clientes
CREATE OR REPLACE PACKAGE pkg_clientes AS
    PROCEDURE sp_insert_cliente(p_nombre_cliente IN VARCHAR2, p_telefono IN VARCHAR2, p_numero IN VARCHAR2);
    PROCEDURE sp_update_cliente(p_id_cliente IN NUMBER, p_nombre_cliente IN VARCHAR2, p_telefono IN VARCHAR2, p_numero IN VARCHAR2);
    PROCEDURE sp_delete_cliente(p_id_cliente IN NUMBER);
    PROCEDURE sp_listar_clientes(p_clientes OUT SYS_REFCURSOR);
END pkg_clientes;
/

CREATE OR REPLACE PACKAGE BODY pkg_clientes AS
    PROCEDURE sp_insert_cliente(p_nombre_cliente IN VARCHAR2, p_telefono IN VARCHAR2, p_numero IN VARCHAR2) IS
    BEGIN
        INSERT INTO Clientes (nombre_cliente, telefono, numero)
        VALUES (p_nombre_cliente, p_telefono, p_numero);
        COMMIT;
    EXCEPTION
        WHEN OTHERS THEN
            ROLLBACK;
            RAISE_APPLICATION_ERROR(-20001, 'Error al insertar en la tabla Clientes: ' || SQLERRM);
    END;

    PROCEDURE sp_update_cliente(p_id_cliente IN NUMBER, p_nombre_cliente IN VARCHAR2, p_telefono IN VARCHAR2, p_numero IN VARCHAR2) IS
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
            RAISE_APPLICATION_ERROR(-20001, 'Error al actualizar en la tabla Clientes: ' || SQLERRM);
    END;

    PROCEDURE sp_delete_cliente(p_id_cliente IN NUMBER) IS
    BEGIN
        DELETE FROM Clientes
        WHERE id_cliente = p_id_cliente;
        COMMIT;
    EXCEPTION
        WHEN OTHERS THEN
            ROLLBACK;
            RAISE_APPLICATION_ERROR(-20001, 'Error al eliminar en la tabla Clientes: ' || SQLERRM);
    END;

    PROCEDURE sp_listar_clientes(p_clientes OUT SYS_REFCURSOR) IS
    BEGIN
        OPEN p_clientes FOR
        SELECT id_cliente, nombre_cliente, telefono, numero
        FROM Clientes;
    END;
END pkg_clientes;
/

-- 3. Paquete para manejar operaciones de empleados
CREATE OR REPLACE PACKAGE pkg_empleados AS
    PROCEDURE sp_insert_empleado(p_id_ocupacion IN NUMBER, p_nombre_empleado IN VARCHAR2, p_apellido IN VARCHAR2, p_telefono IN VARCHAR2, p_salario IN NUMBER);
    PROCEDURE sp_update_empleado(p_id_empleado IN NUMBER, p_id_ocupacion IN NUMBER, p_nombre_empleado IN VARCHAR2, p_apellido IN VARCHAR2, p_telefono IN VARCHAR2, p_salario IN NUMBER);
    PROCEDURE sp_delete_empleado(p_id_empleado IN NUMBER);
    PROCEDURE sp_listar_empleados(p_empleados OUT SYS_REFCURSOR);
END pkg_empleados;
/

CREATE OR REPLACE PACKAGE BODY pkg_empleados AS
    PROCEDURE sp_insert_empleado(p_id_ocupacion IN NUMBER, p_nombre_empleado IN VARCHAR2, p_apellido IN VARCHAR2, p_telefono IN VARCHAR2, p_salario IN NUMBER) IS
    BEGIN
        INSERT INTO Empleados (id_ocupacion, nombre_empleado, apellido, telefono, salario)
        VALUES (p_id_ocupacion, p_nombre_empleado, p_apellido, p_telefono, p_salario);
        COMMIT;
    EXCEPTION
        WHEN OTHERS THEN
            ROLLBACK;
            RAISE_APPLICATION_ERROR(-20001, 'Error al insertar en la tabla Empleados: ' || SQLERRM);
    END;

    PROCEDURE sp_update_empleado(p_id_empleado IN NUMBER, p_id_ocupacion IN NUMBER, p_nombre_empleado IN VARCHAR2, p_apellido IN VARCHAR2, p_telefono IN VARCHAR2, p_salario IN NUMBER) IS
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
            RAISE_APPLICATION_ERROR(-20001, 'Error al actualizar en la tabla Empleados: ' || SQLERRM);
    END;

    PROCEDURE sp_delete_empleado(p_id_empleado IN NUMBER) IS
    BEGIN
        DELETE FROM Empleados
        WHERE id_empleado = p_id_empleado;
        COMMIT;
    EXCEPTION
        WHEN OTHERS THEN
            ROLLBACK;
            RAISE_APPLICATION_ERROR(-20001, 'Error al eliminar en la tabla Empleados: ' || SQLERRM);
    END;

    PROCEDURE sp_listar_empleados(p_empleados OUT SYS_REFCURSOR) IS
    BEGIN
        OPEN p_empleados FOR
        SELECT id_empleado, nombre_empleado, apellido, telefono, salario
        FROM Empleados;
    END;
END pkg_empleados;
/

-- 4. Paquete para manejar operaciones de proveedores
CREATE OR REPLACE PACKAGE pkg_proveedores AS
    PROCEDURE sp_insert_proveedor(
        p_nombre_proveedor IN VARCHAR2,
        p_correo IN VARCHAR2,
        p_contacto IN VARCHAR2,
        p_direccion IN VARCHAR2
    );
    PROCEDURE sp_update_proveedor(
        p_id_proveedor IN NUMBER,
        p_nombre_proveedor IN VARCHAR2,
        p_correo IN VARCHAR2,
        p_contacto IN VARCHAR2,
        p_direccion IN VARCHAR2
    );
    PROCEDURE sp_delete_proveedor(
        p_id_proveedor IN NUMBER
    );
    PROCEDURE sp_listar_proveedores(
        p_proveedores OUT SYS_REFCURSOR
    );
END pkg_proveedores;
/

-- Cuerpo del paquete
CREATE OR REPLACE PACKAGE BODY pkg_proveedores AS
    PROCEDURE sp_insert_proveedor(
        p_nombre_proveedor IN VARCHAR2,
        p_correo IN VARCHAR2,
        p_contacto IN VARCHAR2,
        p_direccion IN VARCHAR2
    ) IS
    BEGIN
        INSERT INTO Proveedor (
            nombre_proveedor, 
            correo, 
            contacto, 
            direccion
        ) VALUES (
            p_nombre_proveedor, 
            p_correo, 
            p_contacto, 
            p_direccion
        );
        COMMIT;
    EXCEPTION
        WHEN OTHERS THEN
            ROLLBACK;
            RAISE_APPLICATION_ERROR(-20001, 'Error al insertar en la tabla Proveedor: ' || SQLERRM);
    END;

    PROCEDURE sp_update_proveedor(
        p_id_proveedor IN NUMBER,
        p_nombre_proveedor IN VARCHAR2,
        p_correo IN VARCHAR2,
        p_contacto IN VARCHAR2,
        p_direccion IN VARCHAR2
    ) IS
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
            RAISE_APPLICATION_ERROR(-20001, 'Error al actualizar en la tabla Proveedor: ' || SQLERRM);
    END;

    PROCEDURE sp_delete_proveedor(
        p_id_proveedor IN NUMBER
    ) IS
    BEGIN
        DELETE FROM Proveedor
        WHERE id_proveedor = p_id_proveedor;
        COMMIT;
    EXCEPTION
        WHEN OTHERS THEN
            ROLLBACK;
            RAISE_APPLICATION_ERROR(-20001, 'Error al eliminar en la tabla Proveedor: ' || SQLERRM);
    END;

    PROCEDURE sp_listar_proveedores(
        p_proveedores OUT SYS_REFCURSOR
    ) IS
    BEGIN
        OPEN p_proveedores FOR
        SELECT id_proveedor, nombre_proveedor, correo, contacto, direccion
        FROM Proveedor;
    END;
END pkg_proveedores;
/


--Juan Carlos--
--1. Paquete que agrupa procedimientos y funciones relacionados con ocupaciones
CREATE OR REPLACE PACKAGE ocupaciones_pkg IS
    PROCEDURE insertar_ocupacion(p_nombre_ocupacion IN VARCHAR2, p_cantidad_empleados IN NUMBER);
    PROCEDURE actualizar_ocupacion(p_id_ocupacion IN NUMBER, p_nombre_ocupacion IN VARCHAR2, p_cantidad_empleados IN NUMBER);
    PROCEDURE eliminar_ocupacion(p_id_ocupacion IN NUMBER);
    FUNCTION obtener_nombre_ocupacion(p_id_ocupacion IN NUMBER) RETURN VARCHAR2;
END ocupaciones_pkg;
/

CREATE OR REPLACE PACKAGE BODY ocupaciones_pkg IS
    PROCEDURE insertar_ocupacion(p_nombre_ocupacion IN VARCHAR2, p_cantidad_empleados IN NUMBER) IS
    BEGIN
        INSERT INTO Ocupaciones (nombre_ocupacion, cantidad_empleados)
        VALUES (p_nombre_ocupacion, p_cantidad_empleados);
        COMMIT;
    END insertar_ocupacion;

    PROCEDURE actualizar_ocupacion(p_id_ocupacion IN NUMBER, p_nombre_ocupacion IN VARCHAR2, p_cantidad_empleados IN NUMBER) IS
    BEGIN
        UPDATE Ocupaciones
        SET nombre_ocupacion = p_nombre_ocupacion,
            cantidad_empleados = p_cantidad_empleados
        WHERE id_ocupacion = p_id_ocupacion;
        COMMIT;
    END actualizar_ocupacion;

    PROCEDURE eliminar_ocupacion(p_id_ocupacion IN NUMBER) IS
    BEGIN
        DELETE FROM Ocupaciones
        WHERE id_ocupacion = p_id_ocupacion;
        COMMIT;
    END eliminar_ocupacion;

    FUNCTION obtener_nombre_ocupacion(p_id_ocupacion IN NUMBER) RETURN VARCHAR2 IS
    BEGIN
        RETURN obtener_nombre_ocupacion(p_id_ocupacion);
    END obtener_nombre_ocupacion;
END ocupaciones_pkg;
/

--2. Paquete que agrupa procedimientos y funciones relacionados con productos
CREATE OR REPLACE PACKAGE productos_pkg IS
    PROCEDURE insertar_producto(p_id_categoria IN NUMBER, p_id_proveedor IN NUMBER, p_nombre_producto IN VARCHAR2, p_inventario IN NUMBER);
    PROCEDURE actualizar_producto(p_id_producto IN NUMBER, p_id_categoria IN NUMBER, p_id_proveedor IN NUMBER, p_nombre_producto IN VARCHAR2, p_inventario IN NUMBER);
    PROCEDURE eliminar_producto(p_id_producto IN NUMBER);
    FUNCTION obtener_inventario_producto(p_id_producto IN NUMBER) RETURN NUMBER;
END productos_pkg;
/

CREATE OR REPLACE PACKAGE BODY productos_pkg IS
    PROCEDURE insertar_producto(p_id_categoria IN NUMBER, p_id_proveedor IN NUMBER, p_nombre_producto IN VARCHAR2, p_inventario IN NUMBER) IS
    BEGIN
        INSERT INTO Productos (id_categoria, id_proveedor, nombre_producto, inventario)
        VALUES (p_id_categoria, p_id_proveedor, p_nombre_producto, p_inventario);
        COMMIT;
    END insertar_producto;

    PROCEDURE actualizar_producto(p_id_producto IN NUMBER, p_id_categoria IN NUMBER, p_id_proveedor IN NUMBER, p_nombre_producto IN VARCHAR2, p_inventario IN NUMBER) IS
    BEGIN
        UPDATE Productos
        SET id_categoria = p_id_categoria,
            id_proveedor = p_id_proveedor,
            nombre_producto = p_nombre_producto,
            inventario = p_inventario
        WHERE id_producto = p_id_producto;
        COMMIT;
    END actualizar_producto;

    PROCEDURE eliminar_producto(p_id_producto IN NUMBER) IS
    BEGIN
        DELETE FROM Productos
        WHERE id_producto = p_id_producto;
        COMMIT;
    END eliminar_producto;

    FUNCTION obtener_inventario_producto(p_id_producto IN NUMBER) RETURN NUMBER IS
    BEGIN
        RETURN obtener_inventario_producto(p_id_producto);
    END obtener_inventario_producto;
END productos_pkg;
/

--3 Paquete que agrupa procedimientos y funciones relacionados con proveedores
CREATE OR REPLACE PACKAGE proveedores_pkg IS
    PROCEDURE insertar_proveedor(p_nombre_proveedor IN VARCHAR2, p_correo IN VARCHAR2, p_contacto IN VARCHAR2, p_direccion IN VARCHAR2);
    PROCEDURE actualizar_proveedor(p_id_proveedor IN NUMBER, p_nombre_proveedor IN VARCHAR2, p_correo IN VARCHAR2, p_contacto IN VARCHAR2, p_direccion IN VARCHAR2);
    PROCEDURE eliminar_proveedor(p_id_proveedor IN NUMBER);
    FUNCTION existe_proveedor(p_id_proveedor IN NUMBER) RETURN BOOLEAN;
END proveedores_pkg;
/

CREATE OR REPLACE PACKAGE BODY proveedores_pkg IS
    PROCEDURE insertar_proveedor(p_nombre_proveedor IN VARCHAR2, p_correo IN VARCHAR2, p_contacto IN VARCHAR2, p_direccion IN VARCHAR2) IS
    BEGIN
        INSERT INTO Proveedor (nombre_proveedor, correo, contacto, direccion)
        VALUES (p_nombre_proveedor, p_correo, p_contacto, p_direccion);
        COMMIT;
    END insertar_proveedor;

    PROCEDURE actualizar_proveedor(p_id_proveedor IN NUMBER, p_nombre_proveedor IN VARCHAR2, p_correo IN VARCHAR2, p_contacto IN VARCHAR2, p_direccion IN VARCHAR2) IS
    BEGIN
        UPDATE Proveedor
        SET nombre_proveedor = p_nombre_proveedor,
            correo = p_correo,
            contacto = p_contacto,
            direccion = p_direccion
        WHERE id_proveedor = p_id_proveedor;
        COMMIT;
    END actualizar_proveedor;

    PROCEDURE eliminar_proveedor(p_id_proveedor IN NUMBER) IS
    BEGIN
        DELETE FROM Proveedor
        WHERE id_proveedor = p_id_proveedor;
        COMMIT;
    END eliminar_proveedor;

    FUNCTION existe_proveedor(p_id_proveedor IN NUMBER) RETURN BOOLEAN IS
    BEGIN
        RETURN existe_proveedor(p_id_proveedor);
    END existe_proveedor;
END proveedores_pkg;
/

--4 Paquete que proporciona utilidades relacionadas con cÃ¡lculos y operaciones generales
-- Vuelve a crear el paquete y el cuerpo del paquete
CREATE OR REPLACE PACKAGE utilidades_pkg IS
    FUNCTION es_proveedor_valido(p_id_proveedor IN NUMBER) RETURN BOOLEAN;
    FUNCTION es_ocupacion_valida(p_id_ocupacion IN NUMBER) RETURN BOOLEAN;
    FUNCTION calcular_salario_total(p_id_ocupacion IN NUMBER) RETURN NUMBER;
END utilidades_pkg;
/

CREATE OR REPLACE PACKAGE BODY utilidades_pkg IS
    FUNCTION es_proveedor_valido(p_id_proveedor IN NUMBER) RETURN BOOLEAN IS
    BEGIN
        RETURN existe_proveedor(p_id_proveedor);
    END es_proveedor_valido;

    FUNCTION es_ocupacion_valida(p_id_ocupacion IN NUMBER) RETURN BOOLEAN IS
    BEGIN
        RETURN obtener_nombre_ocupacion(p_id_ocupacion) IS NOT NULL;
    END es_ocupacion_valida;

    FUNCTION calcular_salario_total(p_id_ocupacion IN NUMBER) RETURN NUMBER IS
    BEGIN
        RETURN obtener_salario_total_ocupacion(p_id_ocupacion);
    END calcular_salario_total;
END utilidades_pkg;
/


-- ----- ------ ------ ----CURSORES ----- ----- ----- ---- ---

-- KEISY --
-- Cursor para listar las ventas
DECLARE
    CURSOR cur_ventas IS
        SELECT id_venta, cantidad, total, fecha
        FROM Ventas;
BEGIN
    FOR venta IN cur_ventas LOOP
        DBMS_OUTPUT.PUT_LINE('Venta ID: ' || venta.id_venta || 
                             ' - Cantidad: ' || venta.cantidad || 
                             ' - Total: ' || venta.total || 
                             ' - Fecha: ' || venta.fecha);
    END LOOP;
END;
/


-- Cursor para listar los servicios
DECLARE
    CURSOR cur_servicios IS
        SELECT id_servicio, servicio 
        FROM Servicios;
BEGIN
    FOR servicio IN cur_servicios LOOP
        DBMS_OUTPUT.PUT_LINE('Servicio ID: ' || servicio.id_servicio || 
                             ' - Nombre: ' || servicio.servicio);
    END LOOP;
END;
/



-- JOHEL --
-- Cursor para listar todos los clientes
DECLARE
    CURSOR cur_clientes IS
        SELECT * FROM Clientes;
BEGIN
    FOR cliente IN cur_clientes LOOP
        DBMS_OUTPUT.PUT_LINE(cliente.id_cliente || ' - ' || cliente.nombre_cliente);
    END LOOP;
END;
/

-- Cursor para listar todas las categorÃ­as
DECLARE
    CURSOR cur_categorias IS
        SELECT * FROM Categorias;
BEGIN
    FOR categoria IN cur_categorias LOOP
        DBMS_OUTPUT.PUT_LINE(categoria.id_categoria || ' - ' || categoria.nombre_categoria);
    END LOOP;
END;
/

--Juan Carlos--
--1 Cursor para listar todas las ocupaciones
DECLARE
    CURSOR c_ocupaciones IS
        SELECT id_ocupacion, nombre_ocupacion, cantidad_empleados
        FROM Ocupaciones;
    v_ocupacion c_ocupaciones%ROWTYPE;
BEGIN
    OPEN c_ocupaciones;
    LOOP
        FETCH c_ocupaciones INTO v_ocupacion;
        EXIT WHEN c_ocupaciones%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('ID: ' || v_ocupacion.id_ocupacion || ', Nombre: ' || v_ocupacion.nombre_ocupacion || ', Empleados: ' || v_ocupacion.cantidad_empleados);
    END LOOP;
    CLOSE c_ocupaciones;
END;
/

--2 Cursor para listar productos de un proveedor especÃ­fico
DECLARE
    CURSOR c_productos_proveedor IS
        SELECT id_producto, nombre_producto, inventario
        FROM Productos
        WHERE id_proveedor = 1; -- Cambiar por el ID del proveedor que desees consultar
    v_producto c_productos_proveedor%ROWTYPE;
BEGIN
    OPEN c_productos_proveedor;
    LOOP
        FETCH c_productos_proveedor INTO v_producto;
        EXIT WHEN c_productos_proveedor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('ID: ' || v_producto.id_producto || ', Nombre: ' || v_producto.nombre_producto || ', Inventario: ' || v_producto.inventario);
    END LOOP;
    CLOSE c_productos_proveedor;
END;
/


-- --- ------ ------ -----TRIGGER ----- ----- ------- -----
-- KEISY --
-- Trigger para actualizar la fecha
CREATE OR REPLACE TRIGGER trg_actualizar_ventas
AFTER UPDATE ON ventas
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('Venta con ID ' || :OLD.id_venta || ' ha sido actualizada.');
END;
/


-- JOHEL --
-- Trigger para registrar la fecha de actualizaciÃ³n
CREATE OR REPLACE TRIGGER trg_auditar_actualizaciones_empleados
AFTER UPDATE ON Empleados
FOR EACH ROW
BEGIN
    -- Registro de la actualizaci󮠥n la salida DBMS (se puede modificar según necesidades)
    DBMS_OUTPUT.PUT_LINE('Empleado actualizado: ID = ' || :OLD.id_empleado || ', Nombre = ' || :OLD.nombre_empleado || ', Apellido = ' || :OLD.apellido);
END;
/


--Juan Carlos--
-- Trigger para auditar inventario despuÃ©s de eliminar un producto
CREATE OR REPLACE TRIGGER actualizar_inventario
AFTER DELETE ON Productos
FOR EACH ROW
BEGIN
    -- Registro en la salida de DBMS_OUTPUT para fines de auditor�
    DBMS_OUTPUT.PUT_LINE('Producto eliminado - ID: ' || :OLD.id_producto || ', Inventario eliminado: ' || :OLD.inventario || ', Categor�ID: ' || :OLD.id_categoria);
END;
/


/*creacion de procedimientos almacenados tabblas CATEGORIAS,CLIENTES Y EMPLEADOS*/


/*CATEGORIAS*/
CREATE OR REPLACE PROCEDURE sp_insert_categoria (
    p_nombre_categoria IN VARCHAR2
) AS
BEGIN
    INSERT INTO Categorias (nombre_categoria)
    VALUES (p_nombre_categoria);
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        -- En caso de error, realizar rollback
        ROLLBACK;
        
        -- Lanzar un error personalizado con el mensaje del error original
        RAISE_APPLICATION_ERROR(-20001, 'Error al insertar en la tabla Categorias: ' || SQLERRM);
END;

CREATE OR REPLACE PROCEDURE sp_listar_categorias(
    p_categorias OUT SYS_REFCURSOR
) AS
BEGIN
    OPEN p_categorias FOR
    SELECT id_categoria, nombre_categoria
    FROM Categorias;
END;

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
        -- En caso de error, realizar rollback
        ROLLBACK;
        
        -- Lanzar un error personalizado con el mensaje del error original
        RAISE_APPLICATION_ERROR(-20001, 'Error al insertar en la tabla Categorias: ' || SQLERRM);
END;


CREATE OR REPLACE PROCEDURE sp_delete_categoria (
    p_id_categoria IN NUMBER
) AS
BEGIN
    DELETE FROM Categorias
    WHERE id_categoria = p_id_categoria;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        -- En caso de error, realizar rollback
        ROLLBACK;
        
        -- Lanzar un error personalizado con el mensaje del error original
        RAISE_APPLICATION_ERROR(-20001, 'Error al insertar en la tabla Categorias: ' || SQLERRM);
END;


/*CLIENTES*/
CREATE OR REPLACE PROCEDURE sp_insert_cliente (
    p_nombre_cliente IN VARCHAR2,
    p_telefono IN VARCHAR2,
    p_numero IN VARCHAR2
) AS
BEGIN
    -- Inserta los datos en la tabla Clientes
    INSERT INTO Clientes (nombre_cliente, telefono, numero)
    VALUES (p_nombre_cliente, p_telefono, p_numero);

    -- Confirma la transacci�n
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        -- En caso de error, realiza rollback
        ROLLBACK;

        -- Lanza un error personalizado con el mensaje del error original
        RAISE_APPLICATION_ERROR(-20001, 'Error al insertar en la tabla Clientes: ' || SQLERRM);
END;

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
        -- En caso de error, realizar rollback
        ROLLBACK;
        
        -- Lanzar un error personalizado con el mensaje del error original
        RAISE_APPLICATION_ERROR(-20001, 'Error al actualizar en la tabla Clientes: ' || SQLERRM);
END;
CREATE OR REPLACE PROCEDURE sp_delete_cliente (
    p_id_cliente IN NUMBER
) AS
BEGIN
    DELETE FROM Clientes
    WHERE id_cliente = p_id_cliente;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        -- En caso de error, realizar rollback
        ROLLBACK;
        
        -- Lanzar un error personalizado con el mensaje del error original
        RAISE_APPLICATION_ERROR(-20001, 'Error al eliminar en la tabla Clientes: ' || SQLERRM);
END;

CREATE OR REPLACE PROCEDURE sp_listar_clientes(
    p_clientes OUT SYS_REFCURSOR
) AS
BEGIN
    OPEN p_clientes FOR
    SELECT id_cliente, nombre_cliente, telefono, numero
    FROM Clientes;
END;

-----------------------------------
/*EMPLEADOS*/
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
END;


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
END;


CREATE OR REPLACE PROCEDURE sp_delete_empleado (
    p_id_empleado IN NUMBER
) AS
BEGIN
    DELETE FROM Empleados
    WHERE id_empleado = p_id_empleado;
    COMMIT;
END;

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


CREATE OR REPLACE PROCEDURE eliminar_reservacion (
    v_id_reservacion IN NUMBER
) AS
BEGIN
    DELETE FROM Reservaciones
    WHERE id_reservacion = v_id_reservacion;
    COMMIT;
    dbms_output.put_line('Reservación eliminada.');
END eliminar_reservacion;

 
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




CREATE OR REPLACE PROCEDURE eliminar_servicio (
    v_id_servicio IN NUMBER
) AS
BEGIN
    DELETE FROM Servicios
    WHERE id_servicio = v_id_servicio;
    COMMIT;
    dbms_output.put_line('Servicio eliminado.');
END eliminar_servicio;

 
--Tabla Ventas
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



CREATE OR REPLACE PROCEDURE eliminar_venta (
    v_id_venta IN NUMBER
) AS
BEGIN
    DELETE FROM Ventas
    WHERE id_venta = v_id_venta;
    COMMIT;
    dbms_output.put_line('Venta eliminada.');
END eliminar_venta;
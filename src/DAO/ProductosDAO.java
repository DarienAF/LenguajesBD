
package DAO;

// Entidad
import Entity.Productos;
// Procedimientos Almacenados
import java.sql.CallableStatement;
// Conexión
import java.sql.Connection;
// Excepción
import java.sql.SQLException;
// Entrada/Salida de datos interfaz
import javax.swing.JOptionPane;
// Tablas
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
// Resultados SQL
import java.sql.ResultSet;
// Tipo SQL
import java.sql.Types;

public class ProductosDAO {
    private String respuesta;

    /* --------- MÉTODO PARA CREAR PRODUCTO ---------- */
    public String crearProducto(Connection conn, Productos productos) {
        CallableStatement cst = null;

        String procedureCall = "{call sp_insertar_producto(?, ?, ?, ?, ?, ?)}"; // 6 parámetros

    try {
        cst = conn.prepareCall(procedureCall);

        // Ajusta los parámetros de acuerdo con el procedimiento almacenado
        cst.setInt(1, productos.getIdCategoria()); // id_categoria
        cst.setInt(2, productos.getIdProveedor()); // id_proveedor
        cst.setString(3, productos.getNombreProducto()); // nombre_producto
        cst.setInt(4, productos.getInventario()); // inventario
        cst.setDouble(5, productos.getPrecioVenta()); // precio_venta
        cst.setDouble(6, productos.getPrecioCompra()); // precio_compra

        respuesta = "Producto creado correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            respuesta = "No se pudo crear el producto\nError: " + err.getMessage();
        } finally {
            if (cst != null) {
                try {
                    cst.close();
                } catch (SQLException e) {
                    respuesta = respuesta + "\nError al cerrar el CallableStatement\n" + e.getMessage();
                }
            }
        }
        return respuesta;
    }

    /* --------- MÉTODO PARA MODIFICAR PRODUCTO ---------- */
    public String modificarProducto(Connection conn, Productos productos) {
        CallableStatement cst = null;
        String respuesta = "";

        // Corregido para coincidir con la firma del procedimiento almacenado
        String procedureCall = "{call sp_actualizar_producto(?, ?, ?, ?, ?, ?, ?)}";

        try {
            cst = conn.prepareCall(procedureCall);

            // Asignar parámetros del procedimiento almacenado
            cst.setInt(1, productos.getIdProducto()); // Parámetro para ID del producto
            cst.setInt(2, productos.getIdCategoria());
            cst.setInt(3, productos.getIdProveedor());
            cst.setString(4, productos.getNombreProducto());
            cst.setInt(5, productos.getInventario());
            cst.setDouble(6, productos.getPrecioVenta());
            cst.setDouble(7, productos.getPrecioCompra());

            // Ejecutar el procedimiento
            cst.execute();
            respuesta = "Producto modificado correctamente";

        } catch (SQLException err) {
            respuesta = "No se pudo modificar el producto\nError: " + err.getMessage();
        } finally {
            if (cst != null) {
                try {
                    cst.close();
                } catch (SQLException e) {
                    respuesta += "\nError al cerrar el CallableStatement\n" + e.getMessage();
                }
            }
        }
        return respuesta;
    }

   /* --------- MÉTODO PARA ELIMINAR PRODUCTO ---------- */
    public String eliminarProducto(Connection conn, int idProducto) {
        CallableStatement cst = null;

        String procedureCall = "{call sp_eliminar_producto(?)}";

        try {
            cst = conn.prepareCall(procedureCall);
            cst.setInt(1, idProducto);

            respuesta = "Producto eliminado correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            respuesta = "No se pudo eliminar el producto\nError: " + err.getMessage();
        } finally {
            if (cst != null) {
                try {
                    cst.close();
                } catch (SQLException e) {
                    respuesta = respuesta + "\nError al cerrar el CallableStatement\n" + e.getMessage();
                }
            }
        }
        return respuesta;
    }

    /* --------- MÉTODO PARA LISTAR PRODUCTOS ---------- */
    public void listarProductos(Connection conn, JTable tabla) {
        DefaultTableModel model;
        String[] columnas = {"ID Producto", "Nombre Producto", "Inventario", "ID Categoría", "ID Proveedor", "Precio Venta", "Precio Compra"};
        model = new DefaultTableModel(null, columnas);

        CallableStatement cst = null;
        ResultSet rs = null;

        try {
            // Llama al procedimiento almacenado
            cst = conn.prepareCall("{call sp_listar_productos(?)}");
            cst.registerOutParameter(1, Types.REF_CURSOR);
            cst.execute();

            // Obtiene el cursor
            rs = (ResultSet) cst.getObject(1);

            // Itera a través del ResultSet y llena el modelo de tabla
            while (rs.next()) {
                int idProducto = rs.getInt("ID_PRODUCTO");
                String nombreProducto = rs.getString("NOMBRE_PRODUCTO");
                int inventario = rs.getInt("INVENTARIO");
                int idCategoria = rs.getInt("ID_CATEGORIA");
                int idProveedor = rs.getInt("ID_PROVEEDOR");
                double precioVenta = rs.getDouble("PRECIO_VENTA");
                double precioCompra = rs.getDouble("PRECIO_COMPRA");

                model.addRow(new Object[]{idProducto, nombreProducto, inventario, idCategoria, idProveedor, precioVenta, precioCompra});
            }

            // Establece el modelo en la tabla
            tabla.setModel(model);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo listar los productos\nError: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (cst != null) {
                    cst.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar ResultSet o CallableStatement\n" + e.getMessage());
            }
        }
    }
}

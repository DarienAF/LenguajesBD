
package DAO;

//Entidad
import Entity.Productos;
//Procedimientos Almacenados
import java.sql.CallableStatement;
//Conexion
import java.sql.Connection;
//Excepcion
import java.sql.SQLException;
//Entrada/Salida de datos interfaz
import javax.swing.JOptionPane;
//Tablas
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//Resultados SQL
import java.sql.ResultSet;
//Tipo SQL
import java.sql.Types;

public class ProductosDAO {
    private String respuesta;

    /* --------- METODO PARA CREAR PRODUCTO ---------- */
    public String crearProducto(Connection conn, Productos productos) {
        CallableStatement cst = null;

        String procedureCall = "{call sp_insertar_producto(?, ?, ?, ?, ?)}";

        try {
            cst = conn.prepareCall(procedureCall);

            cst.setString(1, productos.getNombreProducto());
            cst.setInt(2, productos.getCantidadInventario());
            cst.setInt(3, productos.getIdCategoria());
            cst.setInt(4, productos.getIdProveedor());
            cst.setInt(5, productos.getInventario());

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

    /* --------- METODO PARA MODIFICAR PRODUCTO ---------- */
    public String modificarProducto(Connection conn, Productos productos) {
        CallableStatement cst = null;

        String procedureCall = "{call sp_actualizar_producto(?, ?, ?, ?, ?, ?)}";

        try {
            cst = conn.prepareCall(procedureCall);

            cst.setInt(1, productos.getIdProducto());
            cst.setString(2, productos.getNombreProducto());
            cst.setInt(3, productos.getCantidadInventario());
            cst.setInt(4, productos.getIdCategoria());
            cst.setInt(5, productos.getIdProveedor());
            cst.setInt(6, productos.getInventario());

            respuesta = "Producto modificado correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            respuesta = "No se pudo modificar el producto\nError: " + err.getMessage();
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

    /* --------- METODO PARA ELIMINAR PRODUCTO ---------- */
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

    /* --------- METODO PARA LISTAR PRODUCTOS ---------- */
    public void listarProductos(Connection conn, JTable tabla) {
        DefaultTableModel model;
        String[] columnas = {"ID Producto", "Nombre", "Cantidad Inventario", "ID Categoría", "ID Proveedor", "Inventario"};
        model = new DefaultTableModel(null, columnas);

        CallableStatement cst = null;
        ResultSet rs = null;

        try {
            cst = conn.prepareCall("{call sp_listar_productos(?)}");
            cst.registerOutParameter(1, Types.REF_CURSOR);
            cst.execute();

            rs = (ResultSet) cst.getObject(1);

            while (rs.next()) {
                int idProducto = rs.getInt("ID_PRODUCTO");
                String nombreProducto = rs.getString("NOMBRE_PRODUCTO");
                int cantidadInventario = rs.getInt("CANTIDAD_INVENTARIO");
                int idCategoria = rs.getInt("ID_CATEGORIA");
                int idProveedor = rs.getInt("ID_PROVEEDOR");
                int inventario = rs.getInt("INVENTARIO");

                model.addRow(new Object[]{idProducto, nombreProducto, cantidadInventario, idCategoria, idProveedor, inventario});
            }

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

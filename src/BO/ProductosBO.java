/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAO.ProductosDAO;
import Entity.Productos;
import proyectolenguajes.ConexionBD;
import java.sql.SQLException;
import java.sql.Connection;
import javax.swing.JTable;


public class ProductosBO {
    // Instancia para manejar la conexión con la base de datos
    ConexionBD conexion = new ConexionBD();

    private String mensaje;
    // Instancia del DAO para realizar operaciones en la base de datos
    private ProductosDAO cdao = new ProductosDAO();

    // Metodo para crear un nuevo producto
    public String crearProductos(Productos pro) throws SQLException {
        // Conexion a BD
        Connection conn = conexion.conectar();
        try {
            // Desactiva la confirmación automatica para una transaccion manualmente
            conn.setAutoCommit(false);

            // Realiza la operacion de creación del producto
            mensaje = cdao.crearProducto(conn, pro);

            // Confirma la transaccion si todo fue bien
            conn.commit();
        } catch (SQLException e) {
            // En caso de error, realiza rollback para deshacer los cambios
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException rollbackEx) {
                    // Maneja cualquier error durante el rollback
                    mensaje = mensaje + " Error en rollback: " + rollbackEx.getMessage();
                }
            }
            // Añade el mensaje de error original
            mensaje = mensaje + " " + e.getMessage();
        } finally {
            // Asegura que la conexión siempre se cierre
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                // Maneja cualquier error al cerrar la conexion
                mensaje = mensaje + " Error al cerrar la conexión: " + e.getMessage();
            }
        }
        return mensaje;
    }

    // Metodo para modificar un producto existente
    public String modificarProductos(Productos pro) throws SQLException {

        Connection conn = conexion.conectar();
        try {
            conn.setAutoCommit(false);
            mensaje = cdao.modificarProducto(conn, pro);

            conn.commit();
        } catch (SQLException e) {

            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException rollbackEx) {
                    mensaje = mensaje + " Error en rollback: " + rollbackEx.getMessage();
                }
            }
            mensaje = mensaje + " " + e.getMessage();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                mensaje = mensaje + " Error al cerrar la conexión: " + e.getMessage();
            }
        }
        return mensaje;
    }

    // Metodo para eliminar un producto
    public String eliminarProductos(int id) throws SQLException {
        Connection conn = conexion.conectar();
        try {
            conn.setAutoCommit(false);
            mensaje = cdao.eliminarProducto(conn, id);

            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException rollbackEx) {
                    mensaje = mensaje + " Error en rollback: " + rollbackEx.getMessage();
                }
            }
            mensaje = mensaje + " " + e.getMessage();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                mensaje = mensaje + " Error al cerrar la conexión: " + e.getMessage();
            }
        }
        return mensaje;
    }

    // Metodo para listar productos en una tabla
    public void listarProductos(JTable tabla) throws SQLException {
        Connection conn = conexion.conectar();
        try {
            // Realiza la operacion de listado de productos
            cdao.listarProductos(conn, tabla);
        } finally {
            // Cierre de conexion
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                // Imprime cualquier error al cerrar la conexion
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import java.sql.Connection;
import java.sql.SQLException;
import proyectolenguajes.ConexionBD;
import DAO.ProveedorDAO;
import Entity.Proveedor;
import javax.swing.JTable;


public class ProveedorBO {
    ConexionBD conexion = new ConexionBD();

    private String mensaje;

    private ProveedorDAO cdao = new ProveedorDAO();

    public String crearProveedores(Proveedor prv) throws SQLException {
        Connection conn = conexion.conectar();
        try {
            conn.setAutoCommit(false);
            mensaje = cdao.crearProveedor(conn, prv);

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

    // Metodo para modificar un proveedor existente
    public String modificarProveedores(Proveedor prv) throws SQLException {
        // Establece la conexión con la base de datos
        Connection conn = conexion.conectar();
        try {
            conn.setAutoCommit(false);
            mensaje = cdao.modificarProveedor(conn, prv);

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

    // Metodo para eliminar un proveedor
    public String eliminarProveedores(int id) throws SQLException {
        
        Connection conn = conexion.conectar();
        try {
            conn.setAutoCommit(false);
            mensaje = cdao.eliminarProveedor(conn, id);

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
            // Asegura que la conexión siempre se cierre
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

    // Metodo para listar proveedores en una tabla
    public void listarProveedores(JTable tabla) throws SQLException {
        Connection conn = conexion.conectar();
        try {
            cdao.listarProveedores(conn, tabla);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}


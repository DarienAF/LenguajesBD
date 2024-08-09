/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;


import DAO.VentasDAO;
import Entity.Ventas;
import proyectolenguajes.ConexionBD;
import java.sql.SQLException;
import java.sql.Connection;
import javax.swing.JTable;

public class VentasBO {
    ConexionBD conexion = new ConexionBD();
    
    private String mensaje;
    private VentasDAO cdao = new VentasDAO();
    
    // Metodo para crear una nueva venta
    public String crearVentas(Ventas ven) throws SQLException {

        Connection conn = conexion.conectar();
        try {

            conn.setAutoCommit(false);
            mensaje = cdao.crearVenta(conn, ven);

            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException rollbackEx) {
                    mensaje = mensaje + " Error en rollback: " + rollbackEx.getMessage();
                }
            }
            // Añade el mensaje de error original
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
    
    // Metodo para modificar una venta existente
    public String modificarVentas(Ventas ven) throws SQLException {
        Connection conn = conexion.conectar();
        try {

            conn.setAutoCommit(false);
            mensaje = cdao.modificarVenta(conn, ven);

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
    
    // Metodo para eliminar una venta
    public String eliminarVentas(int id) throws SQLException {

        Connection conn = conexion.conectar();
        try {

            conn.setAutoCommit(false);
            mensaje = cdao.eliminarVenta(conn, id);
            
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
    
    // Metodo para listar ventas en una tabla
    public void listarVentas(JTable tabla) throws SQLException {
        Connection conn = conexion.conectar();
        try {
            cdao.listarVentas(conn, tabla);
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAO.ReservacionesDAO;
import Entity.Reservaciones;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;
import proyectolenguajes.ConexionBD;

public class ReservacionesBO {
    ConexionBD conexion = new ConexionBD();
    
    private String mensaje;
    private ReservacionesDAO cdao = new ReservacionesDAO();

    public String crearReservaciones(Reservaciones res) throws SQLException {
        Connection conn = conexion.conectar();
        try {
            conn.setAutoCommit(false);
            mensaje = cdao.crearReservaciones(conn, res);

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
    
    // Metodo para modificar una reservación existente
    public String modificarReservaciones(Reservaciones res) throws SQLException {

        Connection conn = conexion.conectar();
        try {
            conn.setAutoCommit(false);
            mensaje = cdao.modificarReservaciones(conn, res);

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
    
    // Metodo para eliminar una reservación
    public String eliminarReservaciones(int id) throws SQLException {

        Connection conn = conexion.conectar();
        try {
            conn.setAutoCommit(false);
            mensaje = cdao.eliminarReservaciones(conn, id);
            
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
    
    // Metodo para listar reservaciones en una tabla
    public void listarReservaciones(JTable tabla) throws SQLException {
        Connection conn = conexion.conectar();
        try {
            cdao.listarReservaciones(conn, tabla);
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

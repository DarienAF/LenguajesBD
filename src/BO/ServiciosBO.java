
package BO;

import DAO.ServiciosDAO;
import Entity.Servicios;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;
import proyectolenguajes.ConexionBD;

public class ServiciosBO {
    ConexionBD conexion = new ConexionBD();
    
    private String mensaje;
    private ServiciosDAO cdao = new ServiciosDAO();
    
    public String crearServicios(Servicios ser) throws SQLException {
        
        Connection conn = conexion.conectar();
        try {
            conn.setAutoCommit(false);
            mensaje = cdao.crearServicio(conn, ser);

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

    public String modificarServicios(Servicios ser) throws SQLException {

        Connection conn = conexion.conectar();
        try {
            conn.setAutoCommit(false);
            mensaje = cdao.modificarServicio(conn, ser);

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
    
    public String eliminarServicios(int id) throws SQLException {

        Connection conn = conexion.conectar();
        try {
            conn.setAutoCommit(false);
            mensaje = cdao.eliminarServicio(conn, id);

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

    public void listarServicios(JTable tabla) throws SQLException {
        Connection conn = conexion.conectar();
        try {
            cdao.listarServicios(conn, tabla);
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

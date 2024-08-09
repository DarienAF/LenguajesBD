 
package BO;

import DAO.OcupacionesDAO;
import Entity.Ocupaciones;
import proyectolenguajes.ConexionBD;
import java.sql.SQLException;
import java.sql.Connection;
import javax.swing.JTable;

public class OcupacionesBO {
    ConexionBD conexion = new ConexionBD();

    private String mensaje;
    private OcupacionesDAO cdao = new OcupacionesDAO();

    public String crearOcupacion(Ocupaciones ocu) throws SQLException {
 
        Connection conn = conexion.conectar();
        try {
            conn.setAutoCommit(false);

            mensaje = cdao.crearOcupacion(conn, ocu);

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

    public String modificarOcupacion(Ocupaciones ocu) throws SQLException {
        Connection conn = conexion.conectar();
        try {

            conn.setAutoCommit(false);
            mensaje = cdao.modificarOcupacion(conn, ocu);

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

    public String eliminarOcupacion(int id) throws SQLException {

        Connection conn = conexion.conectar();
        try {
            conn.setAutoCommit(false);
            mensaje = cdao.eliminarOcupacion(conn, id);

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

    public void listarOcupaciones(JTable tabla) throws SQLException {
        Connection conn = conexion.conectar();
        try {
            cdao.listarOcupaciones(conn, tabla);
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

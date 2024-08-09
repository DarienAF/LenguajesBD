/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;


import DAO.EmpleadosDAO;
import Entity.Empleados;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;
import proyectolenguajes.ConexionBD;

public class EmpleadosBO {
    // Instancia para manejar la conexion con la base de datos
    ConexionBD conexion = new ConexionBD();
    
    private String mensaje;
    // Instancia del DAO para realizar operaciones en la base de datos
    private EmpleadosDAO cdao = new EmpleadosDAO();
    
    // Metodo para crear un nuevo empleado
    public String crearEmpleado(Empleados emp) throws SQLException {
        // Establece la conexión a aprtir del import de ConecionBD
        Connection conn = conexion.conectar();
        try {
            // Desactiva la confirmación automatica para una transaccion manualmente
            conn.setAutoCommit(false);

            // Realiza la operacion de crear del empleado
            mensaje = cdao.crearEmpleado(conn, emp);

            // Confirma la transaccion si todo fue bien
            conn.commit();
        } catch (SQLException e) {
            // En caso de error se hace rollback para deshacer los cambios
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException rollbackEx) {
                    // Maneja cualquier error durante el rollback
                    mensaje = mensaje + " Error en rollback: " + rollbackEx.getMessage();
                }
            }
            // Agrega el mensaje de error original
            mensaje = mensaje + " " + e.getMessage();
        } finally {
            // IMPORTANTE, CERRAR LA CONEXION
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
    
    // Metodo para modificar un empleado existente
    public String modificarEmpleado(Empleados emp) throws SQLException {
        // Establece la conexion con la base de datos
        Connection conn = conexion.conectar();
        try {
            // Desactiva la confirmacion automatica para manejar la transacción manualmente
            conn.setAutoCommit(false);

            // Realiza la operacion de modificacion del empleado
            mensaje = cdao.modificarEmpleado(conn, emp);

            // Confirma la transacción si todo fue bien
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
            // Asegura que la conexion siempre se cierre
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
    
    // Método para eliminar un empleado
    public String eliminarEmpleado(int id) throws SQLException {
        // Establece la conexion con la base de datos
        Connection conn = conexion.conectar();
        try {
            // Desactiva la confirmación automatica una transacción manualmente
            conn.setAutoCommit(false);

            // Realiza la operacion de eliminacion del empleado
            mensaje = cdao.eliminarEmpleado(conn, id);

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
            // Agrega el mensaje de error original
            mensaje = mensaje + " " + e.getMessage();
        } finally {
            // Asegura que la conexion siempre se cierre
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
    
    // Metodo para listar empleados en una tabla
    public void listarEmpleados(JTable tabla) throws SQLException {
        // Establece la conexion con la base de datos
        Connection conn = conexion.conectar();
        try {
            // Realiza la operacion de listado de empleados
            cdao.listarEmpleados(conn, tabla);
        } finally {
            // Asegura que la conexion siempre se cierre
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

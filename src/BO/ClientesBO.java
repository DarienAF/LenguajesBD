/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package BO;

import DAO.ClientesDAO;
import Entity.Clientes;
import java.sql.Connection;
import proyectolenguajes.ConexionBD;
import java.sql.SQLException;
import javax.swing.JTable;


public class ClientesBO {
    ConexionBD conexion = new ConexionBD();
            
    private String mensaje ;
    private ClientesDAO cdao =  new ClientesDAO();
    
    public String crearCliente( Clientes cat) throws SQLException{
        Connection conn = conexion.conectar();
       try {
        conn = conexion.conectar();
        conn.setAutoCommit(false); // Desactiva la confirmación automática

        mensaje = cdao.crearCliente(conn, cat);
        
        conn.commit(); // Confirma la transacción si todo fue bien
    } catch (SQLException e) {
        if (conn != null) {
            try {
                conn.rollback(); // Realiza rollback en caso de error
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
    
    public String modificarCliente( Clientes cat) throws SQLException{
        Connection conn = conexion.conectar();
        try {
        conn = conexion.conectar();
        conn.setAutoCommit(false); // Desactiva la confirmación automática

        mensaje = cdao.modificarCliente(conn, cat);
        
        conn.commit(); // Confirma la transacción si todo fue bien
    } catch (SQLException e) {
        if (conn != null) {
            try {
                conn.rollback(); // Realiza rollback en caso de error
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
    
    public String eliminarCliente( int id) throws SQLException{
        Connection conn = conexion.conectar();
       try {
        conn = conexion.conectar();
        conn.setAutoCommit(false); // Desactiva la confirmación automática

        mensaje = cdao.eliminarCliente(conn, id);
        
        conn.commit(); // Confirma la transacción si todo fue bien
    } catch (SQLException e) {
        if (conn != null) {
            try {
                conn.rollback(); // Realiza rollback en caso de error
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
    
    public void listarClientes(JTable tabla) throws SQLException{
        Connection conn = conexion.conectar();
        cdao.listarClientes(conn, tabla);
        try{
            conn.close();
        }catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        
    }
}

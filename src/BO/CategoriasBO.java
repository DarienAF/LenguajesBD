//Funcional
package BO;

import DAO.CategoriasDAO;
import Entity.Categorias;
import java.sql.Connection;
import proyectolenguajes.ConexionBD;
import java.sql.SQLException;
import javax.swing.JTable;

public class CategoriasBO {
  
    
    ConexionBD conexion = new ConexionBD();
            
    private String mensaje ;
    private CategoriasDAO cdao =  new CategoriasDAO();
    
    public String crearCategoria(Categorias cat) throws SQLException {
    Connection conn = null;
    try {
        conn = conexion.conectar();
        conn.setAutoCommit(false); // Desactiva la confirmación automática

        mensaje = cdao.crearCategoria(conn, cat);
        
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
    
    public String modificarCategoria( Categorias cat) throws SQLException{
        Connection conn = conexion.conectar();
       try {
        conn = conexion.conectar();
        conn.setAutoCommit(false); // Desactiva la confirmación automática

        mensaje = cdao.modificarCategoria(conn, cat);
        
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
    
    public String eliminarCategoria( int id) throws SQLException{
        Connection conn = conexion.conectar();
      try {
        conn = conexion.conectar();
        conn.setAutoCommit(false); // Desactiva la confirmación automática

        mensaje = cdao.eliminarCategoria(conn, id);
        
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
    
    public void listarCategoria(JTable tabla) throws SQLException{
        Connection conn = conexion.conectar();
        cdao.listarCategoria(conn, tabla);
        try{
            conn.close();
        }catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        
    }
    
    
    
 
   
}

 
package BO;

import DAO.OcupacionesDAO;
import Entity.Ocupaciones;
import proyectolenguajes.ConexionBD;
import java.sql.SQLException;
import java.sql.Connection;
import javax.swing.JTable;

public class OcupacionesBO {
    
    ConexionBD conexion = new ConexionBD();
            
    private String mensaje ;
    private OcupacionesDAO cdao =  new OcupacionesDAO();
    
    public String crearOcupacion( Ocupaciones ocu) throws SQLException{
        Connection conn = conexion.conectar();
       try{
           mensaje = cdao.crearOcupacion(conn, ocu);
           conn.rollback();
       }catch(SQLException e){
           mensaje = mensaje + " " + e.getMessage();
       }finally{
           try{
               if (conn!=null) {
                   conn.close();
               }
           }catch(Exception e){
               mensaje = mensaje + " " + e.getMessage();
           }
       }
        
        return mensaje;
    }
    
    public String modificarOcupacion( Ocupaciones ocu) throws SQLException{
        Connection conn = conexion.conectar();
       try{
           mensaje = cdao.modificarOcupacion(conn, ocu);
           conn.rollback();
       }catch(SQLException e){
           mensaje = mensaje + " " + e.getMessage();
       }finally{
           try{
               if (conn!=null) {
                   conn.close();
               }
           }catch(Exception e){
               mensaje = mensaje + " " + e.getMessage();
           }
       }
        
        return mensaje;
    }
    
    public String eliminarOcupacion( int id) throws SQLException{
        Connection conn = conexion.conectar();
       try{
           mensaje = cdao.eliminarOcupacion(conn, id);
           conn.rollback();
       }catch(SQLException e){
           mensaje = mensaje + " " + e.getMessage();
       }finally{
           try{
               if (conn!=null) {
                   conn.close();
               }
           }catch(Exception e){
               mensaje = mensaje + " " + e.getMessage();
           }
       }
        
        return mensaje;
    }
    
    public void listarOcupaciones(JTable tabla) throws SQLException{
        Connection conn = conexion.conectar();
        cdao.listarOcupaciones(conn, tabla);
        try{
            conn.close();
        }catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        
    }
}

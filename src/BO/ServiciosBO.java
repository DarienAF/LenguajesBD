
package BO;

import DAO.ServiciosDAO;
import Entity.Servicios;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;
import proyectolenguajes.ConexionBD;

public class ServiciosBO {
    
    ConexionBD conexion = new ConexionBD();
            
    private String mensaje ;
    private ServiciosDAO cdao =  new ServiciosDAO();
    
    public String crearServicios( Servicios ser) throws SQLException{
        Connection conn = conexion.conectar();
       try{
           mensaje = cdao.crearServicio(conn, ser);
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
    
    public String modificarServicios( Servicios ser) throws SQLException{
        Connection conn = conexion.conectar();
       try{
           mensaje = cdao.modificarServicio(conn, ser);
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
    
    public String eliminarServicios( int id) throws SQLException{
        Connection conn = conexion.conectar();
       try{
           mensaje = cdao.eliminarServicio(conn, id);
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
    
    public void listarServicios(JTable tabla) throws SQLException{
        Connection conn = conexion.conectar();
        cdao.listarServicios(conn, tabla);
        try{
            conn.close();
        }catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        
    }
    
    
}

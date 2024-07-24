
package BO;

import DAO.CategoriasDAO;
import Entity.Categorias;
import java.sql.Connection;
import proyectolenguajes.ConexionBD;
import java.sql.SQLException;
import javax.swing.JTable;

public class CategoriasBO {
    
    public class CategoriaBO {
    
    ConexionBD conexion = new ConexionBD();
            
    private String mensaje ;
    private CategoriasDAO cdao =  new CategoriasDAO();
    
    public String crearCategoria( Categorias cat) throws SQLException{
        Connection conn = conexion.conectar();
       try{
           mensaje = cdao.crearCategoria(conn, cat);
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
    
    public String modificarCategoria( Categorias cat) throws SQLException{
        Connection conn = conexion.conectar();
       try{
           mensaje = cdao.modificarCategoria(conn, cat);
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
    
    public String eliminarCategoria( int id) throws SQLException{
        Connection conn = conexion.conectar();
       try{
           mensaje = cdao.eliminarCategoria(conn, id);  
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
}

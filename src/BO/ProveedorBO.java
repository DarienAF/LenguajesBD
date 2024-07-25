/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import java.sql.Connection;
import java.sql.SQLException;
import proyectolenguajes.ConexionBD;
import DAO.ProveedorDAO;
import Entity.Proveedor;
import javax.swing.JTable;


public class ProveedorBO {
    ConexionBD conexion = new ConexionBD();
            
    private String mensaje ;
    private ProveedorDAO cdao =  new ProveedorDAO();
    
    public String crearProveedores( Proveedor prv) throws SQLException{
        Connection conn = conexion.conectar();
       try{
           mensaje = cdao.crearProveedor(conn, prv);
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
    
    public String mosificarProveedores( Proveedor prv) throws SQLException{
        Connection conn = conexion.conectar();
       try{
           mensaje = cdao.modificarProveedor(conn, prv);
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
    
    public String eliminarProveedores(int id) throws SQLException{
        Connection conn = conexion.conectar();
       try{
           mensaje = cdao.eliminarProveedor(conn, id);
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
    
    public void listarProveedores(JTable tabla) throws SQLException{
        Connection conn = conexion.conectar();
        cdao.listarProveedores(conn, tabla);
        try{
            conn.close();
        }catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        
    }
}

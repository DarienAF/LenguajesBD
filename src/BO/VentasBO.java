/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;


import DAO.VentasDAO;
import Entity.Ventas;
import proyectolenguajes.ConexionBD;
import java.sql.SQLException;
import java.sql.Connection;
import javax.swing.JTable;

public class VentasBO {
    ConexionBD conexion = new ConexionBD();
            
    private String mensaje ;
    private VentasDAO cdao =  new VentasDAO();
    
    public String crearVentas( Ventas ven) throws SQLException{
        Connection conn = conexion.conectar();
       try{
           mensaje = cdao.crearVenta(conn, ven);
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
    
    public String modificarVentas (Ventas ven) throws SQLException{
        Connection conn = conexion.conectar();
       try{
           mensaje = cdao.modificarVenta(conn, ven);
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
    
    public String eliminarVentas( int id) throws SQLException{
        Connection conn = conexion.conectar();
       try{
           mensaje = cdao.eliminarVenta(conn,id);
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
    
    public void listarVentas(JTable tabla) throws SQLException{
        Connection conn = conexion.conectar();
        cdao.listarVentas(conn, tabla);
        try{
            conn.close();
        }catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        
    }
}

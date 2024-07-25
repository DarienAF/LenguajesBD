/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAO.ReservacionesDAO;
import Entity.Reservaciones;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;
import proyectolenguajes.ConexionBD;

public class ReservacionesBO {
    ConexionBD conexion = new ConexionBD();
            
    private String mensaje ;
    private ReservacionesDAO cdao =  new ReservacionesDAO();
    
    public String crearReservaciones( Reservaciones res) throws SQLException{
        Connection conn = conexion.conectar();
       try{
           mensaje = cdao.crearReservaciones(conn, res);
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
    
    public String modificarReservaciones( Reservaciones res) throws SQLException{
        Connection conn = conexion.conectar();
       try{
           mensaje = cdao.modificarReservaciones(conn, res);
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
    
    public String eliminarReservaciones( int id) throws SQLException{
        Connection conn = conexion.conectar();
       try{
           mensaje = cdao.eliminarReservaciones(conn, id);
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
    
    public void listarRservaciones(JTable tabla) throws SQLException{
        Connection conn = conexion.conectar();
        cdao.listarReservaciones(conn, tabla);
        try{
            conn.close();
        }catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        
    }
}

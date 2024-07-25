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
    ConexionBD conexion = new ConexionBD();
            
    private String mensaje ;
    private EmpleadosDAO cdao =  new EmpleadosDAO();
    
    public String crearEmpleado( Empleados emp) throws SQLException{
        Connection conn = conexion.conectar();
       try{
           mensaje = cdao.crearEmpleado(conn, emp);
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
    
    public String modificarEmpleado( Empleados emp) throws SQLException{
        Connection conn = conexion.conectar();
       try{
           mensaje = cdao.modificarEmpleado(conn, emp);
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
    
    public String eliminarEmpleado( int id) throws SQLException{
        Connection conn = conexion.conectar();
       try{
           mensaje = cdao.eliminarEmpleado(conn, id);
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
    
    public void listarEmpleados(JTable tabla) throws SQLException{
        Connection conn = conexion.conectar();
        cdao.listarEmpleados(conn, tabla);
        try{
            conn.close();
        }catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        
    }
}

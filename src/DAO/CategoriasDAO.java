//Funcional
package DAO;

//Entidad
import Entity.Categorias;
//Procedimientos Almacenados
import java.sql.CallableStatement;
//Conexion
import java.sql.Connection;
//Excepcion
import java.sql.SQLException;
//Entrada/Salida de datos interfaz
import javax.swing.JOptionPane;
//Tablas
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//Resultados SQL
import java.sql.ResultSet;
//Tipo SQL
import java.sql.Types;

public class CategoriasDAO {
    private String respuesta;
    
    /* --------- METODO PARA CREAR CATEGORIA ---------- */
    public String crearCategoria(Connection conn, Categorias categorias) {
        //CallableStatement es una interfaz Java para sentencia SQL 
        //cst actuara de variable para almacenar una referencia a un objeto de Interfaz Call
        CallableStatement cst = null; //Como no deberia tener nada al inicio es Null

        // Se define la llamada al procedimiento almacenado
        String procedureCall = "{call sp_insert_categoria(?)}";

        try {
            cst = conn.prepareCall(procedureCall);

            cst.setString(1, categorias.getNombreCategoria()); 

            cst.execute();

        } catch (SQLException err) {
           
            respuesta = "La categoría no se almacenó. Error: " + err.getMessage();
            JOptionPane.showMessageDialog(null, respuesta);

        } finally {
            // En el bloque finally nos aseguramos de cerrar el CallableStatement
            if (cst != null) {
                try {
                    cst.close();
                } catch (SQLException e) {
                    // Manejo de excepciones al cerrar
                    respuesta = "Error al cerrar CallableStatement: " + e.getMessage();
                    JOptionPane.showMessageDialog(null, respuesta);
                }
            }
        }
        // Retornamos el mensaje final
        return respuesta;
    }
   
    public void listarCategoria(Connection conn, JTable tabla) {
    DefaultTableModel model;
    String[] columnas = {"ID", "Categoria"};
    model = new DefaultTableModel(null, columnas);  
    // Se crea de un nuevo DefaultTableModel con columnas predefinidas

    CallableStatement cst = null;
    ResultSet rs = null;

    try {
        // Preparacion y ejecucion del CallableStatement para el procedimiento
        cst = conn.prepareCall("{call sp_listar_categorias(?)}");
        cst.registerOutParameter(1, Types.REF_CURSOR);  
        // Registro del parametro de salida de cursor
        cst.execute();

        // Obtener el cursor de resultados
        rs = (ResultSet) cst.getObject(1);

        // Repetir sobre los resultados y agregarlos al modelo de la tabla
        while (rs.next()) {
            int id = rs.getInt("id_categoria"); //int x String
            String categoria = rs.getString("nombre_categoria");

            //Agregar filas
            model.addRow(new Object[]{id, categoria}); 
        }
        // Asignar el modelo de datos a la JTable
        tabla.setModel(model);  

    } catch (SQLException e) {
        System.out.println("No se puede listar la tabla");
        e.printStackTrace();
    } finally {
        // Cierre de recursos en el bloque finally para asegurar su liberación
        try {
            if (rs != null) {
                rs.close();
            }
            if (cst != null) {
                cst.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
    
    public String modificarCategoria(Connection conn, Categorias categorias) {
    CallableStatement cst = null;

    String procedureCall = "{call sp_update_categoria(?, ?)}";

        if (conn == null) {
            respuesta = "Error: La conexion a la base de datos es nula";
            return respuesta;
        }
        //Se prepare el CallableStatment
        cst = conn.prepareCall(procedureCall);

        cst.setInt(1, categorias.getIdCategoria());
        cst.setString(2, categorias.getNombreCategoria());

        // Mensaje de exito
        respuesta = "Categoria modificada correctamente";
        
        //Se ejecuta el Procedimiento 
        cst.execute();
    } catch (SQLException err) {
        //Resouesta ante error
        respuesta = "La categoria no se ha modificado por \nError: " + err.getMessage();
    } finally {
        // Cierre del CallableStatement en el bloque finally (Libera Recursos)
        if (cst != null) {
            try {
                cst.close();
            } catch (SQLException e) {
                respuesta = "Error al cerrar el CallableStatement\n" + e.getMessage();
            }
        }
    }
    //Mensaje de retorno del metodo
    return respuesta;
}


    /* --------- METODO PARA ELIMINAR CATEGORIA ---------- */
   public String eliminarCategoria(Connection conn, int id) {
    
    CallableStatement cst = null;

    String procedureCall = "{call sp_delete_categoria(?)}";

    try {
        if (conn == null) {
            respuesta = "Error: La conexion a la base de datos es nula";
            return respuesta;
        }

        cst = conn.prepareCall(procedureCall);
        cst.setInt(1, id);

        // Mensaje de exito
        respuesta = "Categoria eliminada correctamente";

        cst.execute();
    } catch (SQLException err) {
        respuesta = "La categoria no se ha eliminado por \nError: " + err.getMessage();
    } finally {
        // Cierre del CallableStatement en el bloque finally
        if (cst != null) {
            try {
                cst.close();
            } catch (SQLException e) {
                respuesta = "Error al cerrar el CallableStatement\n" + e.getMessage();
            }
        }
    }
    return respuesta;
}

    
}


package DAO;

//Entidad
import Entity.Ventas;
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
import java.time.LocalDate;

public class VentasDAO {
    private String respuesta;

    /* --------- MÉTODO PARA CREAR VENTA ---------- */
    public String crearVenta(Connection conn, Ventas venta) {
        CallableStatement cst = null;

        String procedureCall = "{call sp_insertar_venta(?, ?, ?, ?, ?, ?)}"; 
        // Ajusta el número de parámetros

        try {
            cst = conn.prepareCall(procedureCall);

            // Configura los parqmetros del procedimiento almacenado
            cst.setInt(1, venta.getIdProducto());
            cst.setDouble(2, venta.getTotal());
            cst.setInt(3, venta.getIdCliente());
            cst.setInt(4, venta.getIdServicio());
            cst.setInt(5, venta.getCantidad());
            cst.setDate(6, java.sql.Date.valueOf(venta.getFecha()));
            respuesta = "Venta registrada correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            respuesta = "No se pudo registrar la venta\nError: " + err.getMessage();
        } finally {
            if (cst != null) {
                try {
                    cst.close();
                } catch (SQLException e) {
                    respuesta = respuesta + "\nError al cerrar el CallableStatement\n" + e.getMessage();
                }
            }
        }
        return respuesta;
    }

    /* --------- MÉTODO PARA MODIFICAR VENTA ---------- */
    public String modificarVenta(Connection conn, Ventas venta) {
        CallableStatement cst = null;

        String procedureCall = "{call sp_actualizar_venta(?, ?, ?, ?, ?, ?, ?)}"; 

        try {
            
        cst = conn.prepareCall(procedureCall);

        // Configura los parámetros del procedimiento almacenado
        cst.setInt(1, venta.getIdVenta());
        cst.setInt(2, venta.getIdProducto());
        cst.setDouble(3, venta.getTotal()); // Asegúrate de que este es el parámetro correcto
        cst.setInt(4, venta.getIdCliente());
        cst.setInt(5, venta.getIdServicio());
        cst.setInt(6, venta.getCantidad());
        cst.setDate(7, java.sql.Date.valueOf(venta.getFecha())); 
        
            respuesta = "Venta modificada correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            respuesta = "No se pudo modificar la venta\nError: " + err.getMessage();
        } finally {
            if (cst != null) {
                try {
                    cst.close();
                } catch (SQLException e) {
                    respuesta = respuesta + "\nError al cerrar el CallableStatement\n" + e.getMessage();
                }
            }
        }
        return respuesta;
    }


    /* --------- METODO PARA ELIMINAR VENTA ---------- */
    public String eliminarVenta(Connection conn, int idVenta) {
        CallableStatement cst = null;

        String procedureCall = "{call sp_eliminar_venta(?)}";

        try {
            cst = conn.prepareCall(procedureCall);
            cst.setInt(1, idVenta);

            respuesta = "Venta eliminada correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            respuesta = "No se pudo eliminar la venta\nError: " + err.getMessage();
        } finally {
            if (cst != null) {
                try {
                    cst.close();
                } catch (SQLException e) {
                    respuesta = respuesta + "\nError al cerrar el CallableStatement\n" + e.getMessage();
                }
            }
        }
        return respuesta;
    }

    /* --------- METODO PARA LISTAR VENTAS ---------- */
    public void listarVentas(Connection conn, JTable tabla) {
        DefaultTableModel model;
    String[] columnas = {"ID Venta", "ID Producto", "ID Cliente", "ID Servicio", "Cantidad", "Total", "Fecha"};
    model = new DefaultTableModel(null, columnas);

    CallableStatement cst = null;
    ResultSet rs = null;

    try {
        cst = conn.prepareCall("{call sp_listar_ventas(?)}");
        cst.registerOutParameter(1, Types.REF_CURSOR);
        cst.execute();

        rs = (ResultSet) cst.getObject(1);

        while (rs.next()) {
            int idVenta = rs.getInt("ID_VENTA");
            int idProducto = rs.getInt("ID_PRODUCTO");
            int idCliente = rs.getInt("ID_CLIENTE"); 
            int idServicio = rs.getInt("ID_SERVICIO"); 
            int cantidad = rs.getInt("CANTIDAD");       
            double total = rs.getDouble("TOTAL");       
            java.sql.Date fechaSql = rs.getDate("FECHA");
            LocalDate fecha = fechaSql.toLocalDate();  // Convierte SQL Date a LocalDate

            model.addRow(new Object[]{idVenta, idProducto, idCliente, idServicio, cantidad, total, fecha});
        }

        tabla.setModel(model);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo listar las ventas\nError: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (cst != null) {
                    cst.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar ResultSet o CallableStatement\n" + e.getMessage());
            }
        }
    }
}

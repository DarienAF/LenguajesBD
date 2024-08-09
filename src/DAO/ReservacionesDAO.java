
package DAO;

import BO.*;
import Entity.Reservaciones;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ReservacionesDAO {
    private String respuesta;

    /* --------- METODO PARA CREAR RESERVACIONES ---------- */
    public String crearReservaciones(Connection conn, Reservaciones reservacion) {
        CallableStatement cst = null;

        String procedureCall = "{call sp_insertar_reservacion(?, ?, ?)}";

        try {
            cst = conn.prepareCall(procedureCall);

            cst.setInt(1, reservacion.getId_cliente());
            cst.setInt(2, reservacion.getCantidad());
            java.sql.Date FechaSql = java.sql.Date.valueOf(reservacion.getDia());
            cst.setDate(3, FechaSql);

            respuesta = "Reservacion registrada correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            respuesta = "No se pudo registrar la reservacion \nError: " + err.getMessage();
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
    
    public String modificarReservaciones(Connection conn, Reservaciones reservacion) {
        CallableStatement cst = null;

        String procedureCall = "{call sp_listar_reservaciones(?, ?, ?, ?)}";

        try {
            cst = conn.prepareCall(procedureCall);

            cst.setInt(1, reservacion.getId_reservaciones());
            cst.setInt(2, reservacion.getId_cliente());
            cst.setInt(3, reservacion.getCantidad());
            java.sql.Date FechaSql = java.sql.Date.valueOf(reservacion.getDia());
            cst.setDate(4, FechaSql);
            

            respuesta = "Reservacion modificada correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            respuesta = "No se pudo modificar la reservacion \nError: " + err.getMessage();
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
    
    public String eliminarReservaciones(Connection conn, int id_reservaciones) {
        CallableStatement cst = null;

        String procedureCall = "{call sp_eliminar_reservacion(?)}";

        try {
            cst = conn.prepareCall(procedureCall);
            cst.setInt(1, id_reservaciones);

            respuesta = "Reservacion eliminado correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            respuesta = "No se pudo eliminar el reservacion \nError: " + err.getMessage();
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
    
  

    /* --------- METODO PARA LISTAR SERVICIOS ---------- */
    public void listarReservaciones(Connection conn, JTable tabla) {
        DefaultTableModel model;
        String[] columnas = {"ID Reservacion", "ID Cliente", "Cantidad", "Fecha de la Reservacion"};
        model = new DefaultTableModel(null, columnas);

        CallableStatement cst = null;
        ResultSet rs = null;

        try {
            cst = conn.prepareCall("{call sp_listar_reservaciones(?)}");
            cst.registerOutParameter(1, Types.REF_CURSOR);
            cst.execute();

            rs = (ResultSet) cst.getObject(1);

            while (rs.next()) {
                int id_reservaciones = rs.getInt("ID_RESERVACION");
                int id_cliente = rs.getInt("ID_CLIENTE");
                int cantidad = rs.getInt("CANTIDAD");
                java.sql.Date fechaSql = rs.getDate("DIA");
                LocalDate dia = fechaSql.toLocalDate();

                model.addRow(new Object[]{id_reservaciones, id_cliente, cantidad, dia});
            }

            tabla.setModel(model);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo listar las reservaciones\nError: " + e.getMessage());
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

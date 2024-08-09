
package DAO;

//Entidad
import Entity.Servicios;
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

public class ServiciosDAO {
    private String respuesta;

    /* --------- METODO PARA CREAR SERVICIO ---------- */
    public String crearServicio(Connection conn, Servicios servicio) {
        CallableStatement cst = null;

        String procedureCall = "{call sp_insertar_servicio(?, ?)}";

        try {
            cst = conn.prepareCall(procedureCall);

            cst.setString(2, servicio.getServicio());
            cst.setInt(3, servicio.getMonto());

            respuesta = "Servicio registrado correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            respuesta = "No se pudo registrar el servicio\nError: " + err.getMessage();
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

    /* --------- METODO PARA MODIFICAR SERVICIO ---------- */
    public String modificarServicio(Connection conn, Servicios servicio) {
        CallableStatement cst = null;

        String procedureCall = "{call sp_actualizar_servicio(?, ?, ?)}";

        try {
            cst = conn.prepareCall(procedureCall);

            cst.setInt(1, servicio.getIdServicio());
            cst.setString(2, servicio.getServicio());
            cst.setInt(3, servicio.getMonto());

            respuesta = "Servicio modificado correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            respuesta = "No se pudo modificar el servicio\nError: " + err.getMessage();
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

    /* --------- METODO PARA ELIMINAR SERVICIO ---------- */
    public String eliminarServicio(Connection conn, int idServicio) {
        CallableStatement cst = null;

        String procedureCall = "{call sp_eliminar_servicio(?)}";

        try {
            cst = conn.prepareCall(procedureCall);
            cst.setInt(1, idServicio);

            respuesta = "Servicio eliminado correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            respuesta = "No se pudo eliminar el servicio\nError: " + err.getMessage();
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
    public void listarServicios(Connection conn, JTable tabla) {
        DefaultTableModel model;
        String[] columnas = {"ID Servicio", "Servicio", "Monto"};
        model = new DefaultTableModel(null, columnas);

        CallableStatement cst = null;
        ResultSet rs = null;

        try {
            cst = conn.prepareCall("{call sp_listar_servicios(?)}");
            cst.registerOutParameter(1, Types.REF_CURSOR);
            cst.execute();

            rs = (ResultSet) cst.getObject(1);

            while (rs.next()) {
                int idServicio = rs.getInt("ID_SERVICIO");
                String nombreServicio = rs.getString("SERVICIO");
                int monto = rs.getInt("MONTO");

                model.addRow(new Object[]{idServicio, nombreServicio, monto});
            }

            tabla.setModel(model);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo listar los servicios\nError: " + e.getMessage());
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

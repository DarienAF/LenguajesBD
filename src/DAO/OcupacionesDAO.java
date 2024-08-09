
package DAO;

//Entidad
import Entity.Ocupaciones;
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


public class OcupacionesDAO {
   private String respuesta;

    /* --------- METODO PARA CREAR OCUPACION ---------- */
    public String crearOcupacion(Connection conn, Ocupaciones ocupacion) {
        CallableStatement cst = null;

        String procedureCall = "{call sp_insertar_ocupacion(?, ?)}";

        try {
            cst = conn.prepareCall(procedureCall);

            cst.setString(1, ocupacion.getNombre_ocupacion());
            cst.setInt(2, ocupacion.getCantidad_empleados());

            respuesta = "Ocupación creada correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            respuesta = "No se pudo crear la ocupación\nError: " + err.getMessage();
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

    /* --------- METODO PARA MODIFICAR OCUPACION ---------- */
    public String modificarOcupacion(Connection conn, Ocupaciones ocupacion) {
        CallableStatement cst = null;

        String procedureCall = "{call sp_actualizar_ocupacion(?, ?, ?)}";

        try {
            cst = conn.prepareCall(procedureCall);

            cst.setInt(1, ocupacion.getId_ocupacion());
            cst.setString(2, ocupacion.getNombre_ocupacion());
            cst.setInt(3, ocupacion.getCantidad_empleados());

            respuesta = "Ocupación modificada correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            respuesta = "No se pudo modificar la ocupación\nError: " + err.getMessage();
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

    /* --------- METODO PARA ELIMINAR OCUPACION ---------- */
    public String eliminarOcupacion(Connection conn, int idOcupacion) {
        CallableStatement cst = null;

        String procedureCall = "{call sp_eliminar_ocupacion(?)}";

        try {
            cst = conn.prepareCall(procedureCall);
            cst.setInt(1, idOcupacion);

            respuesta = "Ocupación eliminada correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            respuesta = "No se pudo eliminar la ocupación\nError: " + err.getMessage();
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

    /* --------- METODO PARA LISTAR OCUPACIONES ---------- */
    public void listarOcupaciones(Connection conn, JTable tabla) {
        DefaultTableModel model;
        String[] columnas = {"ID Ocupación", "Nombre de la Ocupación", "Cantidad de Empleados"};
        model = new DefaultTableModel(null, columnas);

        CallableStatement cst = null;
        ResultSet rs = null;

        try {
            cst = conn.prepareCall("{call sp_listar_ocupaciones(?)}");
            cst.registerOutParameter(1, Types.REF_CURSOR);
            cst.execute();

            rs = (ResultSet) cst.getObject(1);

            while (rs.next()) {
                int idOcupacion = rs.getInt("ID_OCUPACION");
                String nombreOcupacion = rs.getString("NOMBRE_OCUPACION");
                int cantidadEmpleados = rs.getInt("CANTIDAD_EMPLEADOS");

                model.addRow(new Object[]{idOcupacion, nombreOcupacion, cantidadEmpleados});
            }

            tabla.setModel(model);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo listar las ocupaciones\nError: " + e.getMessage());
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

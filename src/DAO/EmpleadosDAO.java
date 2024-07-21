
package DAO;

//Entidad
import Entity.Empleados;
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

public class EmpleadosDAO {
    private String respuesta;

    /* --------- METODO PARA CREAR EMPLEADO ---------- */
    public String crearEmpleado(Connection conn, Empleados empleados) {
        CallableStatement cst = null;

        String procedureCall = "{call ADD_EMPLEADO(?, ?, ?, ?, ?)}";

        try {
            cst = conn.prepareCall(procedureCall);

            cst.setInt(1, empleados.getId_empleado());
            cst.setInt(2, empleados.getId_ocupacion());
            cst.setString(3, empleados.getNombre_empleado());
            cst.setString(4, empleados.getApellido());
            cst.setString(5, empleados.getTelefono());

            respuesta = "Empleado creado correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            respuesta = "No se pudo crear el empleado\nError: " + err.getMessage();
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

    /* --------- METODO PARA MODIFICAR EMPLEADO ---------- */
    public String modificarEmpleado(Connection conn, Empleados empleados) {
        CallableStatement cst = null;

        String procedureCall = "{call UPDATE_EMPLEADO(?, ?, ?, ?, ?)}";

        try {
            cst = conn.prepareCall(procedureCall);

            cst.setInt(1, empleados.getId_empleado());
            cst.setInt(2, empleados.getId_ocupacion());
            cst.setString(3, empleados.getNombre_empleado());
            cst.setString(4, empleados.getApellido());
            cst.setString(5, empleados.getTelefono());

            respuesta = "Empleado modificado correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            respuesta = "No se pudo modificar el empleado\nError: " + err.getMessage();
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

    /* --------- METODO PARA ELIMINAR EMPLEADO ---------- */
    public String eliminarEmpleado(Connection conn, int idEmpleado) {
        CallableStatement cst = null;

        String procedureCall = "{call DELETE_EMPLEADO(?)}";

        try {
            cst = conn.prepareCall(procedureCall);
            cst.setInt(1, idEmpleado);

            respuesta = "Empleado eliminado correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            respuesta = "No se pudo eliminar el empleado\nError: " + err.getMessage();
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

    /* --------- METODO PARA LISTAR EMPLEADOS ---------- */
    public void listarEmpleados(Connection conn, JTable tabla) {
        DefaultTableModel model;
        String[] columnas = {"ID Empleado", "ID Ocupación", "Nombre", "Apellido", "Teléfono"};
        model = new DefaultTableModel(null, columnas);

        CallableStatement cst = null;
        ResultSet rs = null;

        try {
            cst = conn.prepareCall("{call P_READ_EMPLEADOS(?)}");
            cst.registerOutParameter(1, Types.REF_CURSOR);
            cst.execute();

            rs = (ResultSet) cst.getObject(1);

            while (rs.next()) {
                int idEmpleado = rs.getInt("ID_EMPLEADO");
                int idOcupacion = rs.getInt("ID_OCUPACION");
                String nombre = rs.getString("NOMBRE_EMPLEADO");
                String apellido = rs.getString("APELLIDO");
                String telefono = rs.getString("TELEFONO");

                model.addRow(new Object[]{idEmpleado, idOcupacion, nombre, apellido, telefono});
            }

            tabla.setModel(model);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo listar los empleados\nError: " + e.getMessage());
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


package DAO;

//Entidad
import Entity.Proveedor;
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

public class ProveedorDAO {
    private String respuesta;

    /* --------- METODO PARA CREAR PROVEEDOR ---------- */
    public String crearProveedor(Connection conn, Proveedor proveedor) {
        CallableStatement cst = null;

        String procedureCall = "{call ADD_PROVEEDOR(?, ?, ?, ?)}";

        try {
            cst = conn.prepareCall(procedureCall);

            cst.setInt(1, proveedor.getIdProveedor());
            cst.setString(2, proveedor.getNombreProveedor());
            cst.setString(3, proveedor.getCorreo());
            cst.setString(4, proveedor.getContacto());
            cst.setString(5, proveedor.getDireccion());

            respuesta = "Proveedor registrado correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            respuesta = "No se pudo registrar el proveedor\nError: " + err.getMessage();
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

    /* --------- METODO PARA MODIFICAR PROVEEDOR ---------- */
    public String modificarProveedor(Connection conn, Proveedor proveedor) {
        CallableStatement cst = null;

        String procedureCall = "{call UPDATE_PROVEEDOR(?, ?, ?, ?, ?)}";

        try {
            cst = conn.prepareCall(procedureCall);

            cst.setInt(1, proveedor.getIdProveedor());
            cst.setString(2, proveedor.getNombreProveedor());
            cst.setString(3, proveedor.getCorreo());
            cst.setString(4, proveedor.getContacto());
            cst.setString(5, proveedor.getDireccion());

            respuesta = "Proveedor modificado correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            respuesta = "No se pudo modificar el proveedor\nError: " + err.getMessage();
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

    /* --------- METODO PARA ELIMINAR PROVEEDOR ---------- */
    public String eliminarProveedor(Connection conn, int idProveedor) {
        CallableStatement cst = null;

        String procedureCall = "{call DELETE_PROVEEDOR(?)}";

        try {
            cst = conn.prepareCall(procedureCall);
            cst.setInt(1, idProveedor);

            respuesta = "Proveedor eliminado correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            respuesta = "No se pudo eliminar el proveedor\nError: " + err.getMessage();
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

    /* --------- METODO PARA LISTAR PROVEEDORES ---------- */
    public void listarProveedores(Connection conn, JTable tabla) {
        DefaultTableModel model;
        String[] columnas = {"ID Proveedor", "Nombre", "Correo", "Contacto", "Dirección"};
        model = new DefaultTableModel(null, columnas);

        CallableStatement cst = null;
        ResultSet rs = null;

        try {
            cst = conn.prepareCall("{call P_READ_PROVEEDORES(?)}");
            cst.registerOutParameter(1, Types.REF_CURSOR);
            cst.execute();

            rs = (ResultSet) cst.getObject(1);

            while (rs.next()) {
                int idProveedor = rs.getInt("ID_PROVEEDOR");
                String nombreProveedor = rs.getString("NOMBRE_PROVEEDOR");
                String correo = rs.getString("CORREO");
                String contacto = rs.getString("CONTACTO");
                String direccion = rs.getString("DIRECCION");

                model.addRow(new Object[]{idProveedor, nombreProveedor, correo, contacto, direccion});
            }

            tabla.setModel(model);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo listar los proveedores\nError: " + e.getMessage());
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

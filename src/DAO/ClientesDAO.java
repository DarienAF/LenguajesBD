
package DAO;

//Entidad
import Entity.Clientes;
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

public class ClientesDAO {
    private String respuesta;

    /* --------- METODO PARA CREAR CLIENTE ---------- */
    public String crearCliente(Connection conn, Clientes clientes) {
        CallableStatement cst = null;

        String procedureCall = "{call sp_insert_cliente(?, ?, ?)}";

        try {
            cst = conn.prepareCall(procedureCall);

            cst.setString(1, clientes.getNombre_cliente());
            cst.setString(2, clientes.getTelefono());
            cst.setString(3, clientes.getNumero());

            respuesta = "Cliente creado correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            respuesta = "No se pudo crear el cliente\nError: " + err.getMessage();
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

    /* --------- METODO PARA MODIFICAR CLIENTE ---------- */
    public String modificarCliente(Connection conn, Clientes clientes) {
        CallableStatement cst = null;

        String procedureCall = "{call sp_update_cliente(?, ?, ?, ?)}";

        try {
            cst = conn.prepareCall(procedureCall);

            cst.setInt(1, clientes.getId_cliente());
            cst.setString(2, clientes.getNombre_cliente());
            cst.setString(3, clientes.getTelefono());
            cst.setString(4, clientes.getNumero());

            respuesta = "Cliente modificado correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            respuesta = "No se pudo modificar el cliente\nError: " + err.getMessage();
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

    /* --------- METODO PARA ELIMINAR CLIENTE ---------- */
    public String eliminarCliente(Connection conn, int idCliente) {
        CallableStatement cst = null;

        String procedureCall = "{call sp_delete_cliente(?)}";

        try {
            cst = conn.prepareCall(procedureCall);
            cst.setInt(1, idCliente);

            respuesta = "Cliente eliminado correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            respuesta = "No se pudo eliminar el cliente\nError: " + err.getMessage();
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

    /* --------- METODO PARA LISTAR CLIENTES ---------- */
    public void listarClientes(Connection conn, JTable tabla) {
        DefaultTableModel model;
        String[] columnas = {"ID Cliente", "Nombre", "Teléfono", "Número"};
        model = new DefaultTableModel(null, columnas);

        CallableStatement cst = null;
        ResultSet rs = null;

        try {
            cst = conn.prepareCall("{call sp_listar_clientes(?)}");
            cst.registerOutParameter(1, Types.REF_CURSOR);
            cst.execute();

            rs = (ResultSet) cst.getObject(1);

            while (rs.next()) {
                int idCliente = rs.getInt("ID_CLIENTE");
                String nombre = rs.getString("NOMBRE_CLIENTE");
                String telefono = rs.getString("TELEFONO");
                String numero = rs.getString("NUMERO");

                model.addRow(new Object[]{idCliente, nombre, telefono, numero});
            }

            tabla.setModel(model);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo listar los clientes\nError: " + e.getMessage());
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

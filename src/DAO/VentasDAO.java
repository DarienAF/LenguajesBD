
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

public class VentasDAO {
     private String respuesta;

    /* --------- METODO PARA CREAR VENTA ---------- */
    public String crearVenta(Connection conn, Ventas venta) {
        CallableStatement cst = null;

        String procedureCall = "{call ADD_VENTA(?, ?, ?)}";

        try {
            cst = conn.prepareCall(procedureCall);

            cst.setInt(1, venta.getIdVenta());
            cst.setInt(2, venta.getIdProducto());
            cst.setInt(3, venta.getMontoVenta());

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

    /* --------- METODO PARA MODIFICAR VENTA ---------- */
    public String modificarVenta(Connection conn, Ventas venta) {
        CallableStatement cst = null;

        String procedureCall = "{call UPDATE_VENTA(?, ?, ?)}";

        try {
            cst = conn.prepareCall(procedureCall);

            cst.setInt(1, venta.getIdVenta());
            cst.setInt(2, venta.getIdProducto());
            cst.setInt(3, venta.getMontoVenta());

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

        String procedureCall = "{call DELETE_VENTA(?)}";

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
        String[] columnas = {"ID Venta", "ID Producto", "Monto Venta"};
        model = new DefaultTableModel(null, columnas);

        CallableStatement cst = null;
        ResultSet rs = null;

        try {
            cst = conn.prepareCall("{call P_READ_VENTAS(?)}");
            cst.registerOutParameter(1, Types.REF_CURSOR);
            cst.execute();

            rs = (ResultSet) cst.getObject(1);

            while (rs.next()) {
                int idVenta = rs.getInt("ID_VENTA");
                int idProducto = rs.getInt("ID_PRODUCTO");
                int montoVenta = rs.getInt("MONTO_VENTA");

                model.addRow(new Object[]{idVenta, idProducto, montoVenta});
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

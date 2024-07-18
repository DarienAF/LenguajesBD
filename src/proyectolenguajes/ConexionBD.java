package proyectolenguajes;

//Importes para la conexion:
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private final String driver = "oracle.jdbc.driver.OracleDriver";
    private final String url = "jdbc:oracle:thin:@";
    private final String user = "proyectoadmin";
    private final String pass = "123";

    //Metodo para la conexion a la BD
    public Connection conectar() throws SQLException {
        try { 
            //Primero se necesita cargar el driver
            Class.forName(driver);
            
            //Segundo, establecer la conexion con DriverManager
            return DriverManager.getConnection(url, user, pass);
        } 
        catch (ClassNotFoundException e) {
             /* Capturar y relanzar la excepción 
             ClassNotFoundException como SQLException*/
            throw new SQLException("No se encontró el driver JDBC", e);
        }
    }

    // Metodo para cerrar la conexión de manera segura
    public void cerrarConexion(Connection conexion) {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                // Loggear el error en lugar de solo mostrar un mensaje
                e.printStackTrace();
            }
        }
    }
}


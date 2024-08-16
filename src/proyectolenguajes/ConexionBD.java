package proyectolenguajes;

// Importes para la conexion:
import java.sql.Connection;
// Manejador de Conexion
import java.sql.DriverManager;
// Manejo de Excepciones
import java.sql.SQLException;

public class ConexionBD {
    private final String driver = "oracle.jdbc.OracleDriver"; // Actualiza si es necesario
    private final String url = "jdbc:oracle:thin:@192.168.1.87:1521:ORCL";
    private final String user = "proyectoadmin";
    private final String pass = "123";

    public Connection conectar() throws SQLException {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se encontró el driver JDBC", e);
        }
    }

    public void cerrarConexion(Connection conexion) {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


package proyectolenguajes;
//Import del archivo .java JFrame de Pantalla de Inicio
import View.inicioView;
//Para probar conexion
import java.sql.Connection;
import java.sql.SQLException;

public class ProyectoLenguajes {

    public static void main(String[] args) {
         // Crea una instancia de ConexionBD
    /*    ConexionBD conexionBD = new ConexionBD();
        Connection conexion = null;

        try {
            // Intenta conectarte a la base de datos
            conexion = conexionBD.conectar();
            if (conexion != null) {
                System.out.println("Conexión exitosa!");
            } else {
                System.out.println("Conexión fallida.");
            }
        } catch (SQLException e) {
            System.err.println("Error al conectar: " + e.getMessage());
        } finally {
            // Asegúrate de cerrar la conexión
            conexionBD.cerrarConexion(conexion);
        }

        
        // TODO code application logic here*/
      Ejecutar(); //Se empieza con la funcion/metodo para que surja la interfaz
        
    }
    //Metodo para ejecutar el JFrame desde la Main
    public static void Ejecutar(){
        //Se intancia el JFrame
    inicioView ejecutar = new inicioView();
    ejecutar.setLocationRelativeTo(null);  //Centrar
    ejecutar.setVisible(true); //Mostrar JFrame
    }
    
    
    
}

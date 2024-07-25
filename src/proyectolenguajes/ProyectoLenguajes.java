
package proyectolenguajes;
//Import del archivo .java JFrame de Pantalla de Inicio
import View.inicioView;

public class ProyectoLenguajes {

    public static void main(String[] args) {
        // TODO code application logic here
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

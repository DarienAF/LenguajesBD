
package proyectolenguajes;

import View.inicioView;

public class ProyectoLenguajes {

    public static void main(String[] args) {
        // TODO code application logic here
        Ejecutar(); //Se empieza con la funcion/metodo para que surja la interfaz
        
    }
    
    public static void Ejecutar(){
    inicioView ejecutar = new inicioView();
    ejecutar.setLocationRelativeTo(null); 
    ejecutar.setVisible(true);
    }
    
}

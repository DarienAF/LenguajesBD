/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;



public class Ocupaciones {
    private int idOcupacion;
    private String nombreOcupacion;
    private int cantidadEmpleados;

    public int getIdOcupacion() {
        return idOcupacion;
    }

    public void setIdOcupacion(int idOcupacion) {
        this.idOcupacion = idOcupacion;
    }

    public String getNombreOcupacion() {
        return nombreOcupacion;
    }

    public void setNombreOcupacion(String nombreOcupacion) {
        this.nombreOcupacion = nombreOcupacion;
    }

    public int getCantidadEmpleados() {
        return cantidadEmpleados;
    }

    public void setCantidadEmpleados(int cantidadEmpleados) {
        this.cantidadEmpleados = cantidadEmpleados;
    }

    public Ocupaciones(int idOcupacion, String nombreOcupacion, int cantidadEmpleados) {
        this.idOcupacion = idOcupacion;
        this.nombreOcupacion = nombreOcupacion;
        this.cantidadEmpleados = cantidadEmpleados;
    }
    
    
}

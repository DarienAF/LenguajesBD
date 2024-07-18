/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;



/**
 *
 * @author barah
 */
public class Empleados {
    private int idEmpleado;
    private String nombreEmpleado;
    private String apellidoEmpleado;
    private Ocupaciones idOcupacion;
    private Ocupaciones nombreOcupacion;

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getApellidoEmpleado() {
        return apellidoEmpleado;
    }

    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellidoEmpleado = apellidoEmpleado;
    }

    public Empleados(int idEmpleado, String nombreEmpleado, String apellidoEmpleado, Ocupaciones idOcupacion, Ocupaciones nombreOcupacion) {
        this.idEmpleado = idEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.apellidoEmpleado = apellidoEmpleado;
        this.idOcupacion = idOcupacion;
        this.nombreOcupacion = nombreOcupacion;
    }

    public Ocupaciones getIdOcupacion() {
        return idOcupacion;
    }

    public void setIdOcupacion(Ocupaciones idOcupacion) {
        this.idOcupacion = idOcupacion;
    }

    public Ocupaciones getNombreOcupacion() {
        return nombreOcupacion;
    }

    public void setNombreOcupacion(Ocupaciones nombreOcupacion) {
        this.nombreOcupacion = nombreOcupacion;
    }

    
   
    
}

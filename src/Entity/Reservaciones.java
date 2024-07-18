/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;


public class Reservaciones {
    
    private int idReservaciones;
    private int cantidadPersonas;
    private String diaReservacion;
    private Clientes idCliente;
    private Clientes nombreCliente;

    public int getIdReservaciones() {
        return idReservaciones;
    }

    public void setIdReservaciones(int idReservaciones) {
        this.idReservaciones = idReservaciones;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public String getDiaReservacion() {
        return diaReservacion;
    }

    public void setDiaReservacion(String diaReservacion) {
        this.diaReservacion = diaReservacion;
    }

    public Clientes getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Clientes idCliente) {
        this.idCliente = idCliente;
    }

    public Clientes getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(Clientes nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Reservaciones(int idReservaciones, int cantidadPersonas, String diaReservacion, Clientes idCliente, Clientes nombreCliente) {
        this.idReservaciones = idReservaciones;
        this.cantidadPersonas = cantidadPersonas;
        this.diaReservacion = diaReservacion;
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
    }

   
    
    
}

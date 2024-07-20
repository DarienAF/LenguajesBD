/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.time.LocalDate;

public class Reservaciones {
    
   private int id_reservaciones;
   private int id_cliente;
   private int cantidad;
   private LocalDate dia;

    public Reservaciones() {
    }

    public Reservaciones(int id_reservaciones, int id_cliente, int cantidad, LocalDate dia) {
        this.id_reservaciones = id_reservaciones;
        this.id_cliente = id_cliente;
        this.cantidad = cantidad;
        this.dia = dia;
    }

    public int getId_reservaciones() {
        return id_reservaciones;
    }

    public void setId_reservaciones(int id_reservaciones) {
        this.id_reservaciones = id_reservaciones;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }
   
   
}
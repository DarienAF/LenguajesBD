/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;


public class Ventas {
    private int idVenta;
    private int idProducto;
    private int MontoVenta;

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getMontoVenta() {
        return MontoVenta;
    }

    public void setMontoVenta(int MontoVenta) {
        this.MontoVenta = MontoVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Ventas(int idVenta, int idProducto, int MontoVenta) {
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.MontoVenta = MontoVenta;
    }

    
    
    
    
}

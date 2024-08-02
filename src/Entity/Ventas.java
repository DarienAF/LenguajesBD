
package Entity;

import java.time.LocalDate;

public class Ventas {
    private int idVenta;
    private int idProducto;
    private int idCliente;
    private int idServicio;
    private int Cantidad;
    private int Total;
    private LocalDate Fecha;

    public Ventas() {
    }

    public Ventas(int idVenta, int idProducto, int idCliente, int idServicio, int Cantidad, int Total, LocalDate Fecha) {
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.idCliente = idCliente;
        this.idServicio = idServicio;
        this.Cantidad = Cantidad;
        this.Total = Total;
        this.Fecha = Fecha;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int Total) {
        this.Total = Total;
    }

    public LocalDate getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDate Fecha) {
        this.Fecha = Fecha;
    }


}

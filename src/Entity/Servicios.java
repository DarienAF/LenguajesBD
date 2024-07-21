
package Entity;


public class Servicios {
    private int idServicio;
    private String servicio;
    private int monto;

    public Servicios() {
    }

    public Servicios(int idServicio, String servicio, int monto) {
        this.idServicio = idServicio;
        this.servicio = servicio;
        this.monto = monto;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    
    
}

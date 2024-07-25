
package Entity;

public class Ocupaciones {
    private int id_ocupacion;
    private String nombre_ocupacion;
    private int cantidad_empleados;

    public Ocupaciones() {
    }

    public Ocupaciones(int id_ocupacion, String nombre_ocupacion, int cantidad_empleados) {
        this.id_ocupacion = id_ocupacion;
        this.nombre_ocupacion = nombre_ocupacion;
        this.cantidad_empleados = cantidad_empleados;
    }

    public int getId_ocupacion() {
        return id_ocupacion;
    }

    public void setId_ocupacion(int id_ocupacion) {
        this.id_ocupacion = id_ocupacion;
    }

    public String getNombre_ocupacion() {
        return nombre_ocupacion;
    }

    public void setNombre_ocupacion(String nombre_ocupacion) {
        this.nombre_ocupacion = nombre_ocupacion;
    }

    public int getCantidad_empleados() {
        return cantidad_empleados;
    }

    public void setCantidad_empleados(int cantidad_empleados) {
        this.cantidad_empleados = cantidad_empleados;
    }

    
   
}

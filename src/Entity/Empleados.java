
package Entity;

public class Empleados {
   
    private int id_empleado;
    private int id_ocupacion;
    private String nombre_empleado;
    private String apellido;
    private String telefono;

    public Empleados() {
    }

    public Empleados(int id_empleado, int id_ocupacion, String nombre_empleado, String apellido, String telefono) {
        this.id_empleado = id_empleado;
        this.id_ocupacion = id_ocupacion;
        this.nombre_empleado = nombre_empleado;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getId_ocupacion() {
        return id_ocupacion;
    }

    public void setId_ocupacion(int id_ocupacion) {
        this.id_ocupacion = id_ocupacion;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
  
}

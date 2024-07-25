
package Entity;

public class Clientes {
    private int id_cliente;
    private String nombre_cliente;
    private String telefono;
    private String numero;

    public Clientes() {
    }

    public Clientes(int id_cliente, String nombre_cliente, String telefono, String numero) {
        this.id_cliente = id_cliente;
        this.nombre_cliente = nombre_cliente;
        this.telefono = telefono;
        this.numero = numero;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }   
}

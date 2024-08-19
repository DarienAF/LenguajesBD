package Entity;

public class Productos {
    private int idProducto;
    private String nombreProducto;
    private int idCategoria;
    private int idProveedor;
    private int inventario;
    private double precioVenta;
    private double precioCompra;

    // Constructor por defecto
    public Productos() {
    }

    // Constructor con parámetros
    public Productos(int idProducto, String nombreProducto, int idCategoria, int idProveedor, int inventario, double precioVenta, double precioCompra) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.idCategoria = idCategoria;
        this.idProveedor = idProveedor;
        this.inventario = inventario;
        this.precioVenta = precioVenta;
        this.precioCompra = precioCompra;
    }

    // Getters y Setters

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public int getInventario() {
        return inventario;
    }

    public void setInventario(int inventario) {
        this.inventario = inventario;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }
    
}





package Entity;

public class Productos {
    private int idProducto;
    private String nombreProducto;
    private int cantidadInventario;
    private int idCategoria;
    private int idProveedor;
    private int inventario;
    

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

    public int getCantidadInventario() {
        return cantidadInventario;
    }

    public void setCantidadInventario(int cantidadInventario) {
        this.cantidadInventario = cantidadInventario;
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

    public Productos(int idProducto, String nombreProducto, int cantidadInventario, int idCategoria, int idProveedor, int inventario) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.cantidadInventario = cantidadInventario;
        this.idCategoria = idCategoria;
        this.idProveedor = idProveedor;
        this.inventario = inventario;
    }



    
    
    
    
}

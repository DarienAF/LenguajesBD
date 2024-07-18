/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import DAO.*;
import BO.*;

/**
 *
 * @author barah
 */
public class Productos {
    private int idProducto;
    private String nombreProducto;
    private int cantidadInventario;
    private Categorias idCategoria;
    private Categorias nombreCategoria;
    private Proveedor idProveedor;
    private Proveedor nombreProveedor;

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

    public Categorias getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categorias idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Categorias getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(Categorias nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public Proveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedor idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Proveedor getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(Proveedor nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public Productos(int idProducto, String nombreProducto, int cantidadInventario, Categorias idCategoria, Categorias nombreCategoria, Proveedor idProveedor, Proveedor nombreProveedor) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.cantidadInventario = cantidadInventario;
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.idProveedor = idProveedor;
        this.nombreProveedor = nombreProveedor;
    }
    
    
    
}

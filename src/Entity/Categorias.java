/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;



/**
 *
 * @author barah
 */
public class Categorias {
    
    private int IdCategoria;
    private String nombreCategoria;

    public int getIdCategoria() {
        return IdCategoria;
    }

    public void setIdCategoria(int IdCategoria) {
        this.IdCategoria = IdCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public Categorias(int IdCategoria, String nombreCategoria) {
        this.IdCategoria = IdCategoria;
        this.nombreCategoria = nombreCategoria;
    }
    
}

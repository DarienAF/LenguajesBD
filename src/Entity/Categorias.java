
package Entity;

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

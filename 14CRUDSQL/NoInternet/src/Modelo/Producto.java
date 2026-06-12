package Modelo;

public class Producto {
    
    private int id;
    private String titulo;
    private int anioPub;
    private int numPaginas;
    private int idAutor;
    private int idGenero;
    
    public Producto() {
        this.id = 0;
        this.titulo = "";
        this.anioPub = 0;
        this.numPaginas = 0;
        this.idAutor = 0;
        this.idGenero = 0;
    }

public Producto(int id, String titulo, int anioPub, int numPaginas, int idAutor, int idGenero) {
    this.id = id;
    this.titulo = titulo;
    this.anioPub = anioPub;
    this.numPaginas = numPaginas;
    this.idAutor = idAutor;
    this.idGenero = idGenero;
}

public Producto(int id, String nombre, double precio, int cantidad, String categoria) {
    this.id = id;
    this.titulo = nombre;
    this.anioPub = (int) precio;
    this.numPaginas = cantidad;
    this.idAutor = 1;
    this.idGenero = 1;
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    } 

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnioPub() {
        return anioPub;
    }

    public void setAnioPub(int anioPub) {
        this.anioPub = anioPub;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }
    
    public String mostrarDetalle() {
        return String.format(
            "ID: %d | Título: %s | Año: %d | Páginas: %d | Autor ID: %d | Género ID: %d",
            id, titulo, anioPub, numPaginas, idAutor, idGenero
        );
    }
    
    @Override
    public String toString() {
        return mostrarDetalle();
    }
}
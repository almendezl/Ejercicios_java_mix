package libro;
public class Libro implements Comparable<Libro> {
    private  String titulo;
    private  String autor;
    private  String genero;
    private  String editorial;

    
    public Libro(String nombre, String autor,  String genero, String editorial){
        this.titulo = nombre;
        this.autor = autor;
        this.genero = genero;
        this.editorial = editorial;

    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getNombre() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public String getEditorial() {
        return editorial;
    }

    @Override
    public String toString() {
        return  "\tTitulo: \t" + titulo + "\tAutor  \t " + autor + "\tGenero \t " + genero + ",\tEditorial: \t " + editorial;
    }

    @Override
    public int compareTo(Libro that) {
       if(this.autor.compareTo(that.autor) > 0){
            return 1;
        }
        if(this.autor.compareTo(that.autor) < 0){
            return -1;
        }
        /*if(this.genero.compareTo(that.genero) > 0){
            return 1;
        }
        if(this.genero.compareTo(that.genero) < 0){
            return -1;
        }*/
      /* if(this.isbn.compareTo(that.isbn) > 0){
            return 1;
        }
        if(this.isbn.compareTo(that.isbn) < 0){
            return -1;
        }*/
   /*   if(this.nroPaginas > that.nroPaginas){
            return 1;
        }
        if(this.nroPaginas < that.nroPaginas){
            return -1;
        }*/
        return 0;
       // if(this.autor)
    }
    
}

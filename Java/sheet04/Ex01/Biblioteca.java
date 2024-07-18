package Java.sheet04.Ex01;

public class Biblioteca {
    private String ISBN;
    private String titulo;
    private int numeroPaginas;
    private String autor;
    private boolean prestado;

    public Biblioteca() {

    }

    public Biblioteca(String ISBN, String titulo, int numeroPaginas, String autor, boolean prestado) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.numeroPaginas = numeroPaginas;
        this.autor = autor;
        this.prestado = prestado;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    @Override
    public String toString() {
        if (isPrestado()) {
            return "El libro " + getISBN() + " con título '" + getTitulo() + "' y autor '" + getAutor() +
                    "' tiene " + getNumeroPaginas() + " páginas y está prestado";
        }

        return "El libro " + getISBN() + " con título '" + getTitulo() + "' y autor '" + getAutor() +
                "' tiene " + getNumeroPaginas() + " páginas y no está prestado";
    }

    public String prestar() {
        if (isPrestado()) {
            return toString();
        } else {
            setPrestado(true);
            return toString();
        }
    }

    public void devolver() {
        if (isPrestado()) {
            setPrestado(false);
        }
    }

    public double imprimir(double coste) {
        return Math.round(((coste * getNumeroPaginas()) * 100.0) / 100.0);
    }
}

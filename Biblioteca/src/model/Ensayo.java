package model;

public class Ensayo extends Libro{
    private String tema;


    public Ensayo() {
    }

    public Ensayo(int isbn, String nombre, Persona autor, int nPaginas, String tema) {
        super(isbn, nombre, autor, nPaginas);
        this.tema = tema;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Tema = " + tema);
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
}

package model;

public class Ensayo extends Libro{
    private String tema;


    public Ensayo() {
    }

    public Ensayo(long isbn, String nombre, Persona autor, int nPaginas, String tema) {
        super(isbn, nombre, autor, nPaginas);
        this.tema = tema;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Tema: " + tema);
    }

    @Override
    public void pedirDatosLibro() {
        super.pedirDatosLibro();
        System.out.println("Temática");
        scanner.nextLine();
        tema= scanner.nextLine();
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
}

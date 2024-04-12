package model;

public class LibroTerror extends Libro{
    private int calificacion;

    public LibroTerror() {
    }

    public LibroTerror(int isbn, String nombre, Persona autor, int nPaginas, int calificacion) {
        super(isbn, nombre, autor, nPaginas);
        this.calificacion = calificacion;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Calificación = +" + calificacion);
    }

    @Override
    public void pedirDatosLibro() {
        super.pedirDatosLibro();
        System.out.println("Edad recomendada");
        int calificacion = scanner.nextInt();
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
}

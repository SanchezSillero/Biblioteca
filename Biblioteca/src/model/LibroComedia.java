package model;

public class LibroComedia extends Libro{
    private TipoHumor tipoHumor;

    public LibroComedia(int isbn, String nombre, Persona autor, int nPaginas, TipoHumor tipoHumor) {
        super(isbn, nombre, autor, nPaginas);
        this.tipoHumor = tipoHumor;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Tipo de humor = " + tipoHumor);
    }

    public TipoHumor getTipoHumor() {
        return tipoHumor;
    }

    public void setTipoHumor(TipoHumor tipoHumor) {
        this.tipoHumor = tipoHumor;
    }
}

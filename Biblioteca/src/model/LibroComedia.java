package model;

public class LibroComedia extends Libro{
    private TipoHumor tipoHumor;

    public LibroComedia() {
    }

    public LibroComedia(long isbn, String nombre, Persona autor, int nPaginas, TipoHumor tipoHumor) {
        super(isbn, nombre, autor, nPaginas);
        this.tipoHumor = tipoHumor;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Tipo de humor = " + tipoHumor);
    }

    @Override
    public void pedirDatosLibro() {
        super.pedirDatosLibro();
        System.out.println("Tipo de humor");
        String tipoHumorStr = scanner.next();
        tipoHumor = TipoHumor.valueOf(tipoHumorStr.toLowerCase());
    }

    public TipoHumor getTipoHumor() {
        return tipoHumor;
    }

    public void setTipoHumor(TipoHumor tipoHumor) {
        this.tipoHumor = tipoHumor;
    }
}

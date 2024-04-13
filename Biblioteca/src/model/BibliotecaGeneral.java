package model;

public class BibliotecaGeneral extends Biblioteca{
    public BibliotecaGeneral() {
    }

    public BibliotecaGeneral(String nombre, String nombreDirector) {
        super(nombre, nombreDirector);
    }

    @Override
    public void crearCatalogo(int nLibros) {
        if (catalogo == null) {
            catalogo = new Catalogo(nLibros);
            int catalogoCapacidad = nLibros;
            System.out.println("Añadido catálogo con capacidad para " + nLibros + " libros");
        } else {
            System.out.println("Ya existe un catálogo");
        }
    }
}

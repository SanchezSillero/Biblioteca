package model;

import java.util.Scanner;

public class BibliotecaEspecializada extends Biblioteca {
    private TipoLibroAceptado tipoLibroAceptado;

    public BibliotecaEspecializada(String nombre, String nombreDirector, TipoLibroAceptado tipoLibroAceptado) {
        super(nombre, nombreDirector);
        this.tipoLibroAceptado = tipoLibroAceptado;
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

    public TipoLibroAceptado getTipoLibroAceptado() {
        return tipoLibroAceptado;
    }

    public void setTipoLibroAceptado(TipoLibroAceptado tipoLibroAceptado) {
        this.tipoLibroAceptado = tipoLibroAceptado;
    }
}

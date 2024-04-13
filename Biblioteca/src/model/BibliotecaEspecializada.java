package model;

import java.util.Scanner;

public class BibliotecaEspecializada extends Biblioteca {
    public BibliotecaEspecializada() {
    }

    public BibliotecaEspecializada(String nombre, String nombreDirector) {
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

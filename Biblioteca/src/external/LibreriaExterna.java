package external;

import model.*;

import java.util.ArrayList;

public class LibreriaExterna implements InterfazAgregable, InterfazBuscador, InterfazEliminable {
    private ArrayList<Libro> librosFueraCatalogo = new ArrayList<>();

    @Override
    public void agregarLibro(Libro libro) {
        librosFueraCatalogo.add(libro);
    }

    @Override
    public void buscarLibro(long isbn) {
        boolean encontrado = false;
        for (Libro libro : librosFueraCatalogo) {
            if (libro.getIsbn() == isbn) {
                encontrado = true;
                libro.mostrarDatos();
                break; // Detenemos la búsqueda una vez que se encuentra el libro
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningún libro con el ISBN especificado.");
        }
    }

    @Override
    public void eliminarDeLista(long isbn) {
        for (Libro libro : librosFueraCatalogo) {
            if (libro.getIsbn() == isbn) {
                librosFueraCatalogo.remove(libro);
                return; // Salir del método después de eliminar el libro
            }
        }
        // Si el libro con el ISBN especificado no se encuentra, puedes mostrar un mensaje o lanzar una excepción
        System.out.println("No se encontró ningún libro con el ISBN especificado.");
    }

    public ArrayList<Libro> getLibrosFueraCatalogo() {
        return librosFueraCatalogo;
    }

    public void setLibrosFueraCatalogo(ArrayList<Libro> librosFueraCatalogo) {
        this.librosFueraCatalogo = librosFueraCatalogo;
    }
}

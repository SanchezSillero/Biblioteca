package external;

import model.*;

import java.util.ArrayList;

public class LibreriaExterna implements InterfazAgregador, InterfazBuscador, InterfazEliminador {
    /* patrón Singleton es un patrón de diseño que garantiza que una clase tenga solo una instancia y proporciona un punto de acceso global a esa instancia
         Las características principales del patrón Singleton son:
           1. Constructor privado: El constructor de la clase Singleton se declara como privado para evitar que otras clases instancien la clase directamente.
           2. Instancia estática: La clase Singleton contiene una instancia privada y estática de sí misma.
           3. Método estático de acceso: La clase Singleton proporciona un método estático que actúa como punto de acceso global a la instancia Singleton.
              Este método crea la instancia si aún no existe y devuelve la misma instancia en todas las llamadas subsiguientes.*/
    private static LibreriaExterna instanciaUnicaLibreriaExterna; //La clase Singleton contiene una instancia privada y estática de sí misma
    private ArrayList<Libro> librosLibreriaExterna;

    private LibreriaExterna() { //Constructor privado: El constructor de la clase Singleton se declara como privado para evitar que otras clases instancien la clase directamente.
    librosLibreriaExterna = new ArrayList<>();
    }
    // Método estático para obtener la instancia Singleton
    public static LibreriaExterna getInstance() {
        if (instanciaUnicaLibreriaExterna == null) {
            instanciaUnicaLibreriaExterna = new LibreriaExterna();
        }
        return instanciaUnicaLibreriaExterna;
    }


    @Override
    public void agregarLibro(Libro libro) {
        librosLibreriaExterna.add(libro);
    }

    @Override
    public void buscarLibro(long isbn) {
        boolean encontrado = false;
        for (Libro libro : librosLibreriaExterna) {
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
        for (Libro libro : librosLibreriaExterna) {
            if (libro.getIsbn() == isbn) {
                librosLibreriaExterna.remove(libro);
                return; // Salir del método después de eliminar el libro
            }
        }
        // Si el libro con el ISBN especificado no se encuentra, puedes mostrar un mensaje o lanzar una excepción
        System.out.println("No se encontró ningún libro con el ISBN especificado.");
    }

    public ArrayList<Libro> getLibrosLibreriaExterna() {
        return librosLibreriaExterna;
    }

    public void setLibrosLibreriaExterna(ArrayList<Libro> librosLibreriaExterna) {
        this.librosLibreriaExterna = librosLibreriaExterna;
    }
}

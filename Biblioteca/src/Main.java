import controller.Gestor;
import external.LibreriaExterna;
import model.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //CREAMOS UNA INSTANCIA DE LIBRERIA EXTERNA PARA LOS LIBROS FUERA DE CATALOGO
        LibreriaExterna libreriaExterna = LibreriaExterna.getInstance();
        ArrayList<Libro> librosFueraCatalogo = libreriaExterna.getLibrosLibreriaExterna();

        //CREAMOS ALGUNAS INSTANCIAS DE BIBLIOTECAS
        Biblioteca bibliotecaMunicipal = new BibliotecaGeneral("Biblioteca Municipal", "Francisco Sánchez");
        Biblioteca bibliotecaUniversidad = new BibliotecaEspecializada("Biblioteca Universidad", "Patricia Sillero", TipoLibroAceptado.ENSAYO);
        // En la bibliotecaUniversidad solo se aceptaran ensayos

        //Creamos algunos libros
        LibroTerror libroTerror1 = new LibroTerror(1, "Frankenstein", new Persona("Mary Shelley"), 168, 14);
        LibroComedia libroComedia1 = new LibroComedia(2, "La vida secreta de Walter Mitty", new Persona("James Thurber"), 160, TipoHumor.parodia);
        Ensayo ensayo1 = new Ensayo(3, "Los orígenes de la creatividad humana", new Persona("Edward O.Wilson"), 256, "Evolución Humana");
        ArrayList<Persona> listaPersonajesLibroPoliciaca1 = new ArrayList<>();
        listaPersonajesLibroPoliciaca1.add(new Persona("Auguste Dupin"));
        listaPersonajesLibroPoliciaca1.add(new Persona("Narrador"));
        listaPersonajesLibroPoliciaca1.add(new Persona("Madame L'Espanaye"));
        LibroPoliciaca libroPoliciaca1 = new LibroPoliciaca(4, "Los crímenes de la calle Morgue", new Persona("Edgar Allan Poe"), 66, Trama.intriga, listaPersonajesLibroPoliciaca1);
        Ensayo ensayo2 = new Ensayo(5, "El arte de la guerra", new Persona("Sun Tzu"), 112, "Estrategia");

        //CREAMOS UNA INSTANCIA DE GESTOR
        Gestor gestor = new Gestor();

        //Agregamos los libros a la libreria externa
        gestor.agregarLibro(libreriaExterna, libroTerror1);
        gestor.agregarLibro(libreriaExterna, libroComedia1);
        gestor.agregarLibro(libreriaExterna, ensayo1);
        gestor.agregarLibro(libreriaExterna, libroPoliciaca1);
        gestor.agregarLibro(libreriaExterna, ensayo2);

        //Buscamos libros por isbn
        gestor.buscarLibro(libreriaExterna, 1);

        //Eliminamos libro por isbn
        gestor.eliminarDeLista(libreriaExterna, 1);

        //Comprobamos que se ha eliminado
        gestor.buscarLibro(libreriaExterna, 1);



        //Abrimos el menu para gestior las bibliiotecas
        gestor.menu(bibliotecaMunicipal, bibliotecaUniversidad); //podemos meter tantas bibliotecas como tengamos instanciadas

    }
}


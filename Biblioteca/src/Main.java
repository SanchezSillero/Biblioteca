import controller.Gestor;
import model.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //CREAMOS BIBLIOTECAS CON EL CONSTRUCTOR
        Biblioteca bibliotecaMunicipal = new Biblioteca("Biblioteca Municipal", "Francisco Sánchez");
        Biblioteca bibliotecaUniversidad = new Biblioteca("Biblioteca Universidad", "Patricia Sillero");

        // En la bibliotecaUniversidad solo se aceptaran ensayos

        //Creamos un catologo de 4 libros en la biblioteca municipal
       // bibliotecaMunicipal.crearCatalogo(4);

        //Agregamos 5 libros al catalogo
       /* LibroTerror libroTerror1 = new LibroTerror(1, "Frankenstein", new Persona("Mary Shelley"), 168, 14);
        LibroComedia libroComedia1 = new LibroComedia(2, "La vida secreta de Walter Mitty", new Persona("James Thurber"), 160, TipoHumor.parodia);
        Ensayo ensayo1 = new Ensayo(3, "Los orígenes de la creatividad humana", new Persona("Edward O.Wilson"), 256, "Evolución Humana");
        ArrayList<Persona> listaPersonajesLibroPoliciaca1 = new ArrayList<>();
        listaPersonajesLibroPoliciaca1.add(new Persona("Auguste Dupin"));
        listaPersonajesLibroPoliciaca1.add(new Persona("Narrador"));
        listaPersonajesLibroPoliciaca1.add(new Persona ("Madame L'Espanaye"));
        LibroPoliciaca libroPoliciaca1 = new LibroPoliciaca(4, "Los crímenes de la calle Morgue", new Persona("Edgar Allan Poe"), 66, Trama.intriga, listaPersonajesLibroPoliciaca1);
        Ensayo ensayo2 = new Ensayo(5, "El arte de la guerra", new Persona("Sun Tzu"), 112, "Estrategia");

        bibliotecaMunicipal.getCatalogo().add(libroTerror1);
        bibliotecaMunicipal.getCatalogo().add(libroComedia1);
        bibliotecaMunicipal.getCatalogo().add(ensayo2);
        bibliotecaMunicipal.getCatalogo().add(libroPoliciaca1);
        bibliotecaMunicipal.getCatalogo().add(ensayo1);

        //Mostramos la informacion de los libros
        bibliotecaMunicipal.mostrarCatalogo();
*/

        Gestor.menu(bibliotecaMunicipal, bibliotecaUniversidad);

    }

}


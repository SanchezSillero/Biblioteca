import controller.Gestor;
import model.Biblioteca;
import model.Libro;
import model.LibroTerror;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //CREAMOS BIBLIOTECAS CON EL CONSTRUCTOR
        Biblioteca bibliotecaMunicipal = new Biblioteca("Biblioteca Municipal", "Francisco Sánchez");
        Biblioteca bibliotecaUniversidad = new Biblioteca("Biblioteca Universidad", "Patricia Sillero");

        Gestor.menu(bibliotecaMunicipal, bibliotecaUniversidad);

    }

}


import controller.Gestor;
import model.Biblioteca;
import model.Libro;
import model.LibroTerror;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Biblioteca bibliotecaMunicipal = new Biblioteca("Biblioteca Municipal", "Francisco Sánchez");
        Biblioteca bibliotecaUniversidad = new Biblioteca("Biblioteca Universidad", "Patricia Sillero");

        Gestor gestor = new Gestor();
        gestor.menu();


    }
}

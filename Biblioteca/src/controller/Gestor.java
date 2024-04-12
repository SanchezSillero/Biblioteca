package controller;

import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Gestor {
    Scanner scanner = new Scanner(System.in);
    Biblioteca biblioteca;
    int isbn, calificacion, nPaginas;
    String nombre, tema;
    Persona autor;
    Trama trama;
    TipoHumor tipoHumor;
    ArrayList<Persona>listaPersonajes;



    public Gestor(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
    public static void menu (Biblioteca bibliotecaMunicipal, Biblioteca bibliotecaUniversidad){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\t------BIENVENIDO AL GESTOR DE BIBLIOTECAS------");
        System.out.println("\n\n\t\t\t    Pulse Enter para empezar");
        scanner.nextLine();

        int opcion;
        Gestor gestorMunicipal = new Gestor(bibliotecaMunicipal);
        Gestor gestorUniversidad = new Gestor(bibliotecaUniversidad);

        do {
            System.out.println("¿Qué biblioteca desea gestionar?\n\t1. Biblioteca Municipal\t\t\t2. Biblioteca Universidad\t\t\t3. Salir");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1: {
                    System.out.println("\t-----BIBLIOTECA MUNICIPAL-----");
                    gestorMunicipal.menuSub(bibliotecaMunicipal);
                    break;
                }
                case 2: {
                    System.out.println("---BIBLIOTECA UNIVERSIDAD---");
                    gestorUniversidad.menuSub(bibliotecaUniversidad);
                    break;
                }
                case 3: {
                    System.out.println("¡HASTA PRONTO!");
                    break;
                }

                default:
                    System.out.println("Opción no válida");
            }
        }while (opcion!=3);
    }

    public void menuSub(Biblioteca biblioteca) {
        int opcionSub;
        do {
            System.out.println("\t1. Buscar información sobre un libro\n\t2. Construir un catálogo\n\t3. Consultar catálogo" +
                    "\n\t4. Agregar libro al catálogo\n\t5. Sacar libro del catálogo\n\t6. Salir");

            opcionSub = scanner.nextInt();
            switch (opcionSub) {
                case 1: {
                    System.out.println("Introduce el ISBN del libro");
                    int isbn = scanner.nextInt();
                    biblioteca.buscarLibro(isbn);
                    break;
                }
                case 2: {
                    System.out.println("Introduce la capacidad del catálogo (número de libros)");
                    int nLibros = scanner.nextInt();
                    biblioteca.crearCatalogo(nLibros);
                    break;
                }
                case 3: {
                    biblioteca.mostrarCatalogo();
                    break;
                }
                case 4: {
                    System.out.println("Seleccione el tipo de libro que se va agregar:");
                    System.out.println("1. Libro de Terror");
                    System.out.println("2. Libro de Comedia");
                    System.out.println("3. Ensayo");
                    System.out.println("4. Novela Policiaca");
                    int tipoLibro = scanner.nextInt();
                    switch (tipoLibro) {
                        case 1:
                            /*pedirDatosLibro();
                            System.out.println("Edad recomendada");
                            int calificacion = scanner.nextInt();
                            biblioteca.añadirLibroTerror(isbn, nombre, autor, nPaginas, calificacion);*/
                            LibroTerror libroTerror = new LibroTerror(isbn, nombre, autor, nPaginas, calificacion);
                            libroTerror.pedirDatosLibro();
                            biblioteca.añadirLibroTerror(libroTerror);

                            break;
                        case 2:
                            pedirDatosLibro();
                            System.out.println("Tipo de humor");
                            String tipoHumorStr = scanner.next();
                            TipoHumor tipoHumor = TipoHumor.valueOf(tipoHumorStr.toLowerCase());
                            biblioteca.añadirLibroComedia(isbn, nombre, autor, nPaginas, tipoHumor);
                            break;
                        case 3:
                            pedirDatosLibro();
                            System.out.println("Temática");
                            scanner.nextLine();
                            String tema= scanner.nextLine();
                            biblioteca.añadirEnsayo(isbn, nombre, autor, nPaginas, tema);
                            break;
                        case 4:
                            pedirDatosLibro();
                            System.out.println("Trama");
                            String tramaStr = scanner.nextLine();
                            Trama trama = Trama.valueOf(tramaStr.toLowerCase());
                            ArrayList<Persona>listaPersonajes = pedirPersonajes();
                            biblioteca.añadirLibroPoliciaca(isbn, nombre, autor, nPaginas, trama, listaPersonajes);
                            break;
                        default:
                            System.out.println("Opción no válida");
                            break;
                    }
                    break;
                }
                case 5: {

                    break;
                }
                case 6: {
                    System.out.println("Volviendo al menú Bibliotecas");
                    break;
                }
                default: {
                    System.out.println("Opción no válida");
                }
            }

        } while (opcionSub != 6);
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void pedirDatosLibro() {
        System.out.println("Introduce los datos del libro");
        System.out.println("ISBN:");
        isbn = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Título");
        nombre = scanner.nextLine();
        System.out.println("Autor");
        String nombreAutor = scanner.nextLine();
        autor = new Persona(nombreAutor);
        System.out.println("Número de páginas");
        nPaginas = scanner.nextInt();
    }

    public ArrayList<Persona> pedirPersonajes(){
        ArrayList<Persona> listaPersonajes = new ArrayList<>();
        System.out.println("Introduce los nombres de los personajes (presiona Enter después de cada nombre, escribe 'fin' para terminar):");
        String nombrePersonaje;
        do {
            nombrePersonaje = scanner.nextLine();
            if (!nombrePersonaje.equals("fin")) {
                listaPersonajes.add(new Persona(nombrePersonaje));
            }
        } while (!nombrePersonaje.equals("fin"));
        return listaPersonajes;
    }
}

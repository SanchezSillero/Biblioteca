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
                    if (biblioteca.getCatalogo()==null){
                        System.out.println("No existe ningún catálogo");
                    }else {
                        System.out.println("Seleccione el tipo de libro que se va agregar:");
                        System.out.println("1. Libro de Terror");
                        System.out.println("2. Libro de Comedia");
                        System.out.println("3. Ensayo");
                        System.out.println("4. Novela Policiaca");
                        int tipoLibro = scanner.nextInt();
                        switch (tipoLibro) {
                            case 1:
                                LibroTerror libroTerror = new LibroTerror(isbn, nombre, autor, nPaginas, calificacion);
                                libroTerror.pedirDatosLibro();
                                biblioteca.getCatalogo().add(libroTerror);
                                break;
                            case 2:
                                LibroComedia libroComedia = new LibroComedia(isbn, nombre, autor, nPaginas, tipoHumor);
                                libroComedia.pedirDatosLibro();
                                biblioteca.getCatalogo().add(libroComedia);
                                break;
                            case 3:
                                Ensayo ensayo = new Ensayo(isbn, nombre, autor, nPaginas, tema);
                                ensayo.pedirDatosLibro();
                                biblioteca.getCatalogo().add(ensayo);
                                break;
                            case 4:
                                LibroPoliciaca libroPoliciaca = new LibroPoliciaca(isbn, nombre, autor, nPaginas, trama, listaPersonajes);
                                libroPoliciaca.pedirDatosLibro();
                                biblioteca.getCatalogo().add(libroPoliciaca);
                                break;
                            default:
                                System.out.println("Opción no válida");
                                break;
                        }
                    }
                    break;
                }
                case 5: {
                    System.out.println("Introduce el ISBN del libro que desea sacar del catálogo");
                    isbn = scanner.nextInt();
                    for (Libro libro : biblioteca.getCatalogo()) {
                        if (isbn == libro.getIsbn()){
                            biblioteca.getCatalogo().remove(libro);
                        }
                    }
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

}

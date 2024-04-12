package controller;

import model.*;

import java.util.Scanner;

public class Gestor {
    Scanner scanner = new Scanner(System.in);
    Biblioteca biblioteca;
    long isbn;


    public Gestor(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void menuSub(Biblioteca biblioteca) {
        int opcionSub;
        do {
            System.out.println("\t1. Buscar información sobre un libro\n\t2. Construir un catálogo\n\t3. Consultar " +
                    "catálogo\n\t4. Agregar libro al catálogo\n\t5. Sacar libro del catálogo\n\t6. Borrar catálogo\n\t7. \n\t8. Salir");

            opcionSub = scanner.nextInt();
            switch (opcionSub) {
                case 1: {
                    System.out.println("Introduce el ISBN del libro");
                    long isbn = scanner.nextLong();
                    biblioteca.buscarLibro(isbn);
                    pulseEnter();
                    break;
                }
                case 2: {
                    System.out.println("Introduce la capacidad del catálogo (número de libros)");
                    int nLibros = scanner.nextInt();
                    biblioteca.crearCatalogo(nLibros);
                    pulseEnter();
                    break;
                }
                case 3: {
                    biblioteca.getCatalogo().mostrarCatalogo();
                    pulseEnter();
                    break;
                }
                case 4: {
                    if (biblioteca.getCatalogo() == null) {
                        System.out.println("No existe ningún catálogo");
                    } else {
                        if (biblioteca.getNombre().equalsIgnoreCase("Biblioteca Universidad")) {
                            System.out.println("La biblioteca universidad solo acepta libros de tipo ensayo");
                            if (biblioteca.getCatalogo().getListaLibros().size() < biblioteca.getCatalogo().getCapacidad()) {
                                Ensayo ensayo = new Ensayo();
                                ensayo.pedirDatosLibro();
                                biblioteca.getCatalogo().agregarEnsayo(ensayo);
                                pulseEnter();
                            } else {
                                System.out.println("El catálogo está lleno. Borre algún libro primero");
                                pulseEnter();
                            }
                        } else {
                            if (biblioteca.getCatalogo().getListaLibros().size() < biblioteca.getCatalogo().getCapacidad()) {
                                System.out.println("Seleccione el tipo de libro que se va agregar:");
                                System.out.println("1. Libro de Terror");
                                System.out.println("2. Libro de Comedia");
                                System.out.println("3. Ensayo");
                                System.out.println("4. Novela Policiaca");
                                int tipoLibro = scanner.nextInt();
                                switch (tipoLibro) {
                                    case 1:
                                        LibroTerror libroTerror = new LibroTerror();
                                        libroTerror.pedirDatosLibro();
                                        biblioteca.getCatalogo().agregarLibro(libroTerror);
                                        pulseEnter();
                                        break;
                                    case 2:
                                        LibroComedia libroComedia = new LibroComedia();
                                        libroComedia.pedirDatosLibro();
                                        biblioteca.getCatalogo().agregarLibro(libroComedia);
                                        pulseEnter();
                                        break;
                                    case 3:
                                        Ensayo ensayo = new Ensayo();
                                        ensayo.pedirDatosLibro();
                                        biblioteca.getCatalogo().agregarEnsayo(ensayo);
                                        pulseEnter();
                                        break;
                                    case 4:
                                        LibroPoliciaca libroPoliciaca = new LibroPoliciaca();
                                        libroPoliciaca.pedirDatosLibro();
                                        biblioteca.getCatalogo().agregarLibro(libroPoliciaca);
                                        pulseEnter();
                                        break;
                                    default:
                                        System.out.println("Opción no válida");
                                        break;
                                }
                            } else {
                                System.out.println("El catálogo está lleno. Borre algún libro primero");
                                pulseEnter();
                            }
                        }
                    }
                    break;
                }
                case 5: {
                    System.out.println("Introduce el ISBN del libro que desea sacar del catálogo");
                    isbn = scanner.nextInt();
                    for (Libro libro : biblioteca.getCatalogo().getListaLibros()) {
                        if (isbn == libro.getIsbn()) {
                            biblioteca.getCatalogo().getListaLibros().remove(libro);
                        }
                    }
                    break;
                }
                case 6: {
                    biblioteca.setCatalogo(null);
                    System.out.println("Catálogo eliminado correctamente");
                    pulseEnter();
                    break;
                }
                case 8: {
                    System.out.println("Volviendo al menú Bibliotecas");
                    break;
                }
                default: {
                    System.out.println("Opción no válida");
                }
            }

        } while (opcionSub != 8);
    }

    public static void menu(Biblioteca bibliotecaMunicipal, Biblioteca bibliotecaUniversidad) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\t------BIENVENIDO AL GESTOR DE BIBLIOTECAS------");
        System.out.println("\n\n\t\t    Pulse Enter para continuar");
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
        } while (opcion != 3);
    }

    public void pulseEnter() {
        System.out.println("\n\n\t\t\t    Pulse Enter para continuar");
        scanner.nextLine();
        scanner.nextLine();
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }


    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

}

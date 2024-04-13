package controller;

import external.LibreriaExterna;
import model.*;

import java.util.Scanner;

public class Gestor {
    private Scanner scanner = new Scanner(System.in);
    private Biblioteca biblioteca;
    private long isbn;
    LibreriaExterna libreriaExterna = LibreriaExterna.getInstance();

    //CONSTRUCTORES DE GESTOR
    public Gestor() {
    }

    public Gestor(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    //FUNCIONES DE GESTOR
    public void menu(Biblioteca... bibliotecas) { //los ... indica que el parametro es un array variable
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\t------BIENVENIDO AL GESTOR DE BIBLIOTECAS------");
        System.out.println("\n\n\t\t    Pulse Enter para continuar");
        scanner.nextLine();

        int opcion;
        Gestor[] gestores = new Gestor[bibliotecas.length]; //creamos un array de gestores, uno para cada objeto Biblioteca
        for (int i = 0; i < bibliotecas.length; i++) {
            gestores[i] = new Gestor(bibliotecas[i]);
        }

        do {
            System.out.println("¿Qué biblioteca desea gestionar?");
            for (int i = 0; i < bibliotecas.length; i++) {  //itteramos para mostrar en pantalla un indice con las bibliotecas que tenemos
                System.out.println("\t" + (i + 1) + ". " + bibliotecas[i].getNombre());
            }
            System.out.println("\t" + (bibliotecas.length + 1) + ". Salir");

            opcion = scanner.nextInt();
            if (opcion >= 1 && opcion <= bibliotecas.length) {//validamos si la opcion esta dentro del rango de bibliotecas
                System.out.println("\t-----" + bibliotecas[opcion - 1].getNombre() + "-----");
                gestores[opcion - 1].menuSub(bibliotecas[opcion - 1]); //accedemos al metodo menuSub del gestor correspondiente a la biblioteca seleccionada
            } else if (opcion == bibliotecas.length + 1) { //verificamos si la opcion es la del apendice salir del menu
                System.out.println("¡HASTA PRONTO!");
            } else {
                System.out.println("Opción no válida");
            }
        } while (opcion != bibliotecas.length + 1);
    }

    public void menuSub(Biblioteca biblioteca) {
        int opcionSub;
        do {
            System.out.println("\t1. Buscar información sobre un libro\n\t2. Construir un catálogo\n\t3. Consultar " +
                    "catálogo\n\t4. Agregar libro al catálogo\n\t5. Sacar libro del catálogo\n\t6. Borrar catálogo\n\t7. Expotar el catálogo a un fichero\n\t8. Salir");

            opcionSub = scanner.nextInt();
            switch (opcionSub) {
                case 1: { // Buscar información sobre un libro aunque no este en el catalogo (lo busca en la libreria externa)
                    System.out.println("Introduce el ISBN del libro");
                    long isbn = scanner.nextLong();
                    libreriaExterna.buscarLibro(isbn);
                    pulseEnter();
                    break;
                }
                case 2: { //Construir un catálogo de n libros
                    System.out.println("Introduce la capacidad del catálogo (número de libros)");
                    int nLibros = scanner.nextInt();
                    biblioteca.crearCatalogo(nLibros);
                    pulseEnter();
                    break;
                }
                case 3: { //COnsultamos todos los libros del catalogo, el de la biblioteca
                    biblioteca.getCatalogo().mostrarCatalogo();
                    pulseEnter();
                    break;
                }
                case 4: {
                    if (biblioteca.getCatalogo() == null) {
                        System.out.println("No existe ningún catálogo");
                        break;
                    }
                    if (biblioteca.getCatalogo().getListaLibros().size() >= biblioteca.getCatalogo().getCapacidad()) {
                        System.out.println("El catálogo está lleno. Borre algún libro primero");
                        pulseEnter();
                        break;
                    } else {
                        if (biblioteca instanceof BibliotecaEspecializada) {
                            TipoLibroAceptado tipoLibroAceptado = ((BibliotecaEspecializada) biblioteca).getTipoLibroAceptado();
                            switch (tipoLibroAceptado) {
                                case ENSAYO:
                                    Ensayo ensayo = new Ensayo();
                                    ensayo.pedirDatosLibro();
                                    biblioteca.getCatalogo().agregarLibro(ensayo);
                                    libreriaExterna.agregarLibro(ensayo);
                                    pulseEnter();
                                    break;
                                case TERROR:
                                    LibroTerror libroTerror = new LibroTerror();
                                    libroTerror.pedirDatosLibro();
                                    biblioteca.getCatalogo().agregarLibro(libroTerror);
                                    libreriaExterna.agregarLibro(libroTerror);
                                    pulseEnter();
                                    break;
                                case COMEDIA:
                                    LibroComedia libroComedia = new LibroComedia();
                                    libroComedia.pedirDatosLibro();
                                    biblioteca.getCatalogo().agregarLibro(libroComedia);
                                    libreriaExterna.agregarLibro(libroComedia);
                                    pulseEnter();
                                    break;
                                case POLICIACA:
                                    LibroPoliciaca libroPoliciaca = new LibroPoliciaca();
                                    libroPoliciaca.pedirDatosLibro();
                                    biblioteca.getCatalogo().agregarLibro(libroPoliciaca);
                                    libreriaExterna.agregarLibro(libroPoliciaca);
                                    pulseEnter();
                                    break;
                                default:
                                    System.out.println("Tipo de libro no válido para esta biblioteca especializada");
                                    break;
                            }
                        } else {
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
                                    libreriaExterna.agregarLibro(libroTerror);
                                    pulseEnter();
                                    break;
                                case 2:
                                    LibroComedia libroComedia = new LibroComedia();
                                    libroComedia.pedirDatosLibro();
                                    biblioteca.getCatalogo().agregarLibro(libroComedia);
                                    libreriaExterna.agregarLibro(libroComedia);
                                    pulseEnter();
                                    break;
                                case 3:
                                    Ensayo ensayo = new Ensayo();
                                    ensayo.pedirDatosLibro();
                                    biblioteca.getCatalogo().agregarEnsayo(ensayo);
                                    libreriaExterna.agregarLibro(ensayo);
                                    pulseEnter();
                                    break;
                                case 4:
                                    LibroPoliciaca libroPoliciaca = new LibroPoliciaca();
                                    libroPoliciaca.pedirDatosLibro();
                                    biblioteca.getCatalogo().agregarLibro(libroPoliciaca);
                                    libreriaExterna.agregarLibro(libroPoliciaca);
                                    pulseEnter();
                                    break;
                                default:
                                    System.out.println("Opción no válida");
                                    break;
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
                            biblioteca.getCatalogo().getListaLibros().remove(libro); //excepcion concurrentModification se da cuando solo tengo 1 libro y lo intenta borrar mientras itera dentro del bucle
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
                case 7: {

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

    public void pulseEnter() {
        System.out.println("\n\n\t\t\t    Pulse Enter para continuar");
        scanner.nextLine();
        scanner.nextLine();
    }


    //FUNCIONES PUENTE PARA LAS INTERFACES
    public void agregarLibro(InterfazAgregador agregador, Libro libro) {
        agregador.agregarLibro(libro);
    }

    public void eliminarDeLista(InterfazEliminador eliminador, long isbn) {
        eliminador.eliminarDeLista(isbn);
    }

    public void buscarLibro(InterfazBuscador buscador, long isbn) {
        buscador.buscarLibro(isbn);
    }
}

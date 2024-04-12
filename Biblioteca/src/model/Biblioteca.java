package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    // ATRIBUTOS DE LA CLASE BIBLIOTECA
    Scanner scanner = new Scanner(System.in);
    private String nombre;
    private Persona director;
    private Catalogo catalogo;
    //private ArrayList<Libro> catalogo;
    private int catalogoCapacidad;


    //CLASE ANIDADA CATALOGO
    public class Catalogo {
        private ArrayList<Libro> listaLibros;
        private int capacidad;

        public Catalogo(int capacidad) {
            this.listaLibros = new ArrayList<>();
            this.capacidad = capacidad;
        }

        public void mostrarCatalogo() {
            if (listaLibros.isEmpty()) {
                System.out.println("El catálogo no contiene libro alguno");
            } else {
                for (Libro libro : listaLibros) {
                    libro.mostrarDatos();
                    System.out.println("-----------------------------------");
                }
            }

        }

        public void agregarLibro(Libro libro) {
            if (listaLibros.size() < capacidad) {
                listaLibros.add(libro);
                System.out.println("Libro agregado al catálogo");
            } else {
                System.out.println("El catálogo está lleno. Borre algún libro primero");
            }
        }

        public void agregarEnsayo(Ensayo ensayo) {
            if (nombre.equalsIgnoreCase("Biblioteca Universidad")) {
                catalogo.listaLibros.add(ensayo);
                System.out.println("Ensayo añadido al catálogo de la Universidad");
            }
        }


        public ArrayList<Libro> getListaLibros() {
            return listaLibros;
        }

        public void setListaLibros(ArrayList<Libro> listaLibros) {
            this.listaLibros = listaLibros;
        }

        public int getCapacidad() {
            return capacidad;
        }

        public void setCapacidad(int capacidad) {
            this.capacidad = capacidad;
        }
    }

    // CONSTRUCTORES DE LA CLASE BIBLIOTECA
    public Biblioteca() {
    }                                                                   //CONSTRUCTOR VACIO

    public Biblioteca(String nombre, String nombreDirector) {                                //CONSTRUCTOR SIN CATALOGO (En la biblioteca puede existir o no un catalogo)
        this.nombre = nombre;
        this.director = new Persona(nombreDirector);
    }

    //FUNCIONES

    public void crearCatalogo(int nLibros) {                                                       //METODO PARA CREAR UN CATALOGO
        if (catalogo == null) {
            catalogo = new Catalogo(nLibros);
            catalogoCapacidad = nLibros;
            System.out.println("Añadido catálogo con capacidad para " + nLibros + " libros");
        } else {
            System.out.println("Ya existe un catálogo");
        }
    }

    public void buscarLibro(long isbn) {                                                         //METODO PARA BUSCAR LIBRO POR ISBN
        isbn = scanner.nextInt();
        boolean encontrado = false;
        for (Libro libro : catalogo.listaLibros) {
            if (libro.getIsbn() == isbn) {
                libro.mostrarDatos();
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No hay ningún libro con este ISBN en el catálogo");
        }
    }

    public void mostrarCatalogo() {
        if (catalogo.listaLibros.isEmpty()) {
            System.out.println("El catálogo no contiene libro alguno");
        } else {
            for (Libro libro : catalogo.listaLibros) {
                libro.mostrarDatos();
                System.out.println("-----------------------------------");
            }
        }

    }


    // GETTERS & SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Persona getDirector() {
        return director;
    }

    public void setDirector(Persona director) {
        this.director = director;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }
}

package model;

import java.util.ArrayList;

public abstract class Biblioteca implements InterfazBuscador {
    // ATRIBUTOS DE LA CLASE BIBLIOTECA
    private String nombre;
    private Persona director;
    protected Catalogo catalogo;


    // CONSTRUCTORES DE LA CLASE BIBLIOTECA
    public Biblioteca() {
    }                                                                   //CONSTRUCTOR VACIO

    public Biblioteca(String nombre, String nombreDirector) {           //CONSTRUCTOR SIN CATALOGO (En la biblioteca puede existir o no un catalogo)
        this.nombre = nombre;
        this.director = new Persona(nombreDirector);
    }

    //FUNCIONES
    public abstract void crearCatalogo(int nLibros);


    @Override
    public void buscarLibro(long isbn) {

    }

    //CLASE ANIDADA CATALOGO
    public class Catalogo implements InterfazAgregador {

        //ATRIBUTOS
        private ArrayList<Libro> listaLibros;
        private int capacidad;


        //CONSTRUCTORES
        public Catalogo() {
        }

        public Catalogo(int capacidad) {
            this.listaLibros = new ArrayList<>();
            this.capacidad = capacidad;
        }

        //FUNCIONES
        public void mostrarCatalogo() {
            if (listaLibros.isEmpty()) {
                System.out.println("El catálogo no contiene libro alguno");
            } else {
                for (Libro libro : listaLibros) {
                    libro.mostrarDatos();
                }
            }

        }

        @Override
        public void agregarLibro(Libro libro) {
            if (listaLibros.size() < capacidad) {
                listaLibros.add(libro);
                System.out.println("Libro agregado al catálogo");
            } else {
                System.out.println("El catálogo está lleno. Borre algún libro primero");
            }
        }

        public void agregarEnsayo(Ensayo ensayo) { //METODO DEFINIDO PARA LA BIBLIOTECA UNIVERSIDAD QUE SOLO ACEPTA ENSAYOS
            if (nombre.equalsIgnoreCase("Biblioteca Universidad")) {
                catalogo.listaLibros.add(ensayo);
                System.out.println("Ensayo añadido al catálogo de la Universidad");
            }
        }

        //GETTERS AND SETTERS DE CATALOGO
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

    // GETTERS & SETTERS DE BIBLIOTECA
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

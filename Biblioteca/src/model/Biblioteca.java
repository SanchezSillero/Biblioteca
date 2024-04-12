package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
                                    // ATRIBUTOS DE LA CLASE BIBLIOTECA
    Scanner scanner = new Scanner(System.in);
    private String nombre;
    private Persona director;
    private ArrayList<Libro> catalogo;

                                    // CONSTRUCTORES DE LA CLASE BIBLIOTECA
    public Biblioteca() {
    }                                                                   //CONSTRUCTOR VACIO

    public Biblioteca(String nombre, String nombreDirector) {                                //CONSTRUCTOR SIN CATALOGO
        this.nombre = nombre;
        this.director = new Persona(nombreDirector);
    }

    public Biblioteca(String nombre,String nombreDirector, ArrayList catalogo) {            //CONSTRUCTOR CON CATALOGO
        this.nombre = nombre;
        this.director = new Persona(nombreDirector);
        this.catalogo = new ArrayList<Libro>();
    }

                                           //FUNCIONES

    public void crearCatalogo(int nLibros) {                                                       //METODO PARA CREAR UN CATALOGO
        catalogo = new ArrayList<Libro>(nLibros);
        System.out.println("Añadido catálogo con capacidad para "+nLibros+" libros");
    }

    public void buscarLibro(int isbn){                                                         //METODO PARA BUSCAR LIBRO POR ISBN
        isbn = scanner.nextInt();
        boolean encontrado = false;
        for (Libro libro : catalogo) {
            if (libro.getIsbn() == isbn){
                libro.mostrarDatos();
                encontrado = true;
                break;
            }
        }
        if (!encontrado){
            System.out.println("No hay ningún libro con este ISBN en el catálogo");
        }
    }

    public void mostrarCatalogo() {
        if (catalogo.isEmpty()){
            System.out.println("El catálogo no contiene libro alguno");
        }else {
            for (Libro libro : catalogo) {
                libro.mostrarDatos();
            }
        }
        
    }


    public void añadirLibro(Libro libro){
        if (catalogo!=null) {
            catalogo.add(libro);
        }else {
            System.out.println("Debes crear un catálogo primero");
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

    public ArrayList<Libro> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(ArrayList<Libro> catalogo) {
        this.catalogo = catalogo;
    }
}

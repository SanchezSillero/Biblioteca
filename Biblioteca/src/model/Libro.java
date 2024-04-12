package model;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Libro {
    //ATRIBUTOS
    private int isbn;
    private String nombre;
    private Persona autor;
    private int nPaginas;
    Scanner scanner = new Scanner(System.in);


    //CONSTRUCTORES
    public Libro() {
    }

    public Libro(int isbn) {
        this.isbn = isbn;
    }

    public Libro(int isbn, String nombre, Persona autor, int nPaginas) {
        this.isbn = isbn;
        this.nombre = nombre;
        this.autor = autor;
        this.nPaginas = nPaginas;
    }


    //FUNCIONES
    public void mostrarDatos() {
        System.out.println("Datos del libro " + isbn);
        System.out.println("Nombre = " + nombre);
        System.out.println("Autor = " + autor.getNombre());
        System.out.println("Número de páginas = " + nPaginas);
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



    //GETTERS & SETTERS
    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Persona getAutor() {
        return autor;
    }

    public void setAutor(Persona autor) {
        this.autor = autor;
    }

    public int getnPaginas() {
        return nPaginas;
    }

    public void setnPaginas(int nPaginas) {
        this.nPaginas = nPaginas;
    }
}


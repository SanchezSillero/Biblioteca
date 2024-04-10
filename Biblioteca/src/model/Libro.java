package model;

import java.util.ArrayList;

public abstract class Libro {
    //ATRIBUTOS
    private int isbn;
    private String nombre;
    private Persona autor;
    private int nPaginas;

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
        System.out.println("Autor = " + autor);
        System.out.println("Número de páginas = " + nPaginas);
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


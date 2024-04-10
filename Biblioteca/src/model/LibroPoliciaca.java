package model;

import java.util.ArrayList;

public class LibroPoliciaca extends Libro{
    private Trama trama;
    private ArrayList<Persona> listaPersonajes;

    public LibroPoliciaca(int isbn, String nombre, Persona autor, int nPaginas, Trama trama, ArrayList<Persona> listaPersonajes) {
        super(isbn, nombre, autor, nPaginas);
        this.trama = trama;
        this.listaPersonajes = listaPersonajes;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Trama = " + trama);
        System.out.println("Lista de personajes = ");
        for (Persona personaje : listaPersonajes) {
            System.out.println(personaje.getNombre());
        }

    }

    public Trama getTrama() {
        return trama;
    }

    public void setTrama(Trama trama) {
        this.trama = trama;
    }

    public ArrayList<Persona> getListaPersonajes() {
        return listaPersonajes;
    }

    public void setListaPersonajes(ArrayList<Persona> listaPersonajes) {
        this.listaPersonajes = listaPersonajes;
    }
}

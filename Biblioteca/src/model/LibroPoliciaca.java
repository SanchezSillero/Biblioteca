package model;

import java.util.ArrayList;

public class LibroPoliciaca extends Libro{
    private Trama trama;
    private ArrayList<Persona> listaPersonajes;


    public LibroPoliciaca() {
    }

    public LibroPoliciaca(long isbn, String nombre, Persona autor, int nPaginas, Trama trama, ArrayList<Persona> listaPersonajes) {
        super(isbn, nombre, autor, nPaginas);
        this.trama = trama;
        this.listaPersonajes = listaPersonajes;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Trama: " + trama);
        System.out.println("Lista de personajes: ");
        for (Persona personaje : listaPersonajes) {
            System.out.println(personaje.getNombre());
        }
        System.out.println("-------------------------------------");
    }

    @Override
    public void pedirDatosLibro() {
        super.pedirDatosLibro();
        System.out.println("Trama");
        String tramaStr = scanner.nextLine();
        trama = Trama.valueOf(tramaStr.toLowerCase());
        listaPersonajes = pedirPersonajes();
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

    public Trama getTrama() {
        return trama;
    }

    public void setTrama(Trama trama) {
        this.trama = trama;
    }

    public ArrayList<Persona> getListaPersonajes() {
        return listaPersonajes;
    }

}

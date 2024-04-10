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







                                                    //SUBCLASES DE LIBRO
    class LibroTerror extends Libro {
        private int calificacion;

        public LibroTerror() {
        }

        public LibroTerror(int isbn, String nombre, Persona autor, int nPaginas, int calificacion) {
            super(isbn, nombre, autor, nPaginas);
            this.calificacion = calificacion;
        }

        @Override
        public void mostrarDatos() {
            super.mostrarDatos();
            System.out.println("Calificación = +" + calificacion);
        }

        public int getCalificacion() {
            return calificacion;
        }

        public void setCalificacion(int calificacion) {
            this.calificacion = calificacion;
        }
    }

    class LibroComedia extends Libro {
        private TipoHumor tipoHumor;

        public LibroComedia(int isbn, String nombre, Persona autor, int nPaginas, TipoHumor tipoHumor) {
            super(isbn, nombre, autor, nPaginas);
            this.tipoHumor = tipoHumor;
        }

        @Override
        public void mostrarDatos() {
            super.mostrarDatos();
            System.out.println("Tipo de humor = " + tipoHumor);
        }

        public TipoHumor getTipoHumor() {
            return tipoHumor;
        }

        public void setTipoHumor(TipoHumor tipoHumor) {
            this.tipoHumor = tipoHumor;
        }
    }

    class Ensayo extends Libro {
        private String tema;

        public Ensayo(int isbn, String nombre, Persona autor, int nPaginas, String tema) {
            super(isbn, nombre, autor, nPaginas);
            this.tema = tema;
        }

        @Override
        public void mostrarDatos() {
            super.mostrarDatos();
            System.out.println("Tema = " + tema);
        }

        public String getTema() {
            return tema;
        }

        public void setTema(String tema) {
            this.tema = tema;
        }
    }

    class LibroPoliciaca extends Libro {
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


}


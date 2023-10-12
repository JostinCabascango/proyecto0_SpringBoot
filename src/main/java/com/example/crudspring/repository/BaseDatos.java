package com.example.crudspring.repository;

import com.example.crudspring.bean.Libro;

import java.util.ArrayList;
import java.util.Iterator;

public class BaseDatos {
    ArrayList<Libro> libros = new ArrayList<Libro>();

    public BaseDatos() {
        libros.add(new Libro(1, "El Quijote", "Cervantes", "Anaya", "1605", "Novela"));
        libros.add(new Libro(2, "El Señor de los Anillos", "Tolkien", "Minotauro", "1954", "Fantasía"));
        libros.add(new Libro(3, "El Principito", "Saint-Exupéry", "Salamandra", "1943", "Infantil"));
        libros.add(new Libro(4, "El Hobbit", "Tolkien", "Minotauro", "1937", "Fantasía"));
        libros.add(new Libro(5, "Cien años de soledad", "García Márquez", "Sudamericana", "1967", "Novela"));
        libros.add(new Libro(6, "El Código Da Vinci", "Brown", "Umbriel", "2003", "Novela"));
        libros.add(new Libro(7, "El Alquimista", "Coelho", "Planeta", "1988", "Novela"));
        libros.add(new Libro(8, "El nombre del viento", "Rothfuss", "Plaza & Janés", "2007", "Fantasía"));
        libros.add(new Libro(9, "El retrato de Dorian Gray", "Wilde", "Alianza", "1890", "Novela"));
        libros.add(new Libro(10, "El retrato de Dorian Gray", "Wilde", "Alianza", "1890", "Novela"));
        libros.add(new Libro(11, "El retrato de Dorian Gray", "Wilde", "Alianza", "1890", "Novela"));
        libros.add(new Libro(12, "El retrato de Dorian Gray", "Wilde", "Alianza", "1890", "Novela"));
        libros.add(new Libro(13, "El retrato de Dorian Gray", "Wilde", "Alianza", "1890", "Novela"));
        libros.add(new Libro(14, "El retrato de Dorian Gray", "Wilde", "Alianza", "1890", "Novela"));
        libros.add(new Libro(15, "El retrato de Dorian Gray", "Wilde", "Alianza", "1890", "Novela"));
        libros.add(new Libro(16, "El retrato de Dorian Gray", "Wilde", "Alianza", "1890", "Novela"));
        libros.add(new Libro(17, "El retrato de Dorian Gray", "Wilde", "Alianza", "1890", "Novela"));
        libros.add(new Libro(18, "El retrato de Dorian Gray", "Wilde", "Alianza", "1890", "Novela"));
        libros.add(new Libro(19, "El retrato de Dorian Gray", "Wilde", "Alianza", "1890", "Novela"));
        libros.add(new Libro(20, "El retrato de Dorian Gray", "Wilde", "Alianza", "1890", "Novela"));

    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    public void insertar(Libro libro) {
        libros.add(libro);
    }

    public void borrar(int id) {
        Iterator<Libro> iterator = libros.iterator();
        while (iterator.hasNext()) {
            Libro libro = iterator.next();
            if (libro.getId() == id) {
                iterator.remove();
                break;
            }
        }
    }
}

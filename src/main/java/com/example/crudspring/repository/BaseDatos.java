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
        libros.add(new Libro(10, "1984", "George Orwell", "Secker & Warburg", "1949", "Ciencia Ficción"));
        libros.add(new Libro(11, "Don Quijote", "Miguel de Cervantes", "Anaya", "1605", "Novela"));
        libros.add(new Libro(12, "Matar un ruiseñor", "Harper Lee", "J. B. Lippincott & Co.", "1960", "Novela"));
        libros.add(new Libro(13, "La Odisea", "Homero", "Desconocida", "Siglo VIII a.C.", "Epopeya"));
        libros.add(new Libro(14, "Crimen y Castigo", "Fiodor Dostoievski", "Editorial El Galeón", "1866", "Novela"));
        libros.add(new Libro(15, "Drácula", "Bram Stoker", "Archibald Constable and Company", "1897", "Terror"));
        libros.add(new Libro(16, "Moby-Dick", "Herman Melville", "Richard Bentley", "1851", "Aventura"));
        libros.add(new Libro(17, "Ulises", "James Joyce", "Sylvia Beach", "1922", "Novela"));
        libros.add(new Libro(18, "Cien años de soledad", "Gabriel García Márquez", "Sudamericana", "1967", "Novela"));
        libros.add(new Libro(19, "Harry Potter y la piedra filosofal", "J.K. Rowling", "Bloomsbury", "1997", "Fantasía"));


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

    public Libro getLibro(int id) {
        Iterator<Libro> iterator = libros.iterator();
        while (iterator.hasNext()) {
            Libro libro = iterator.next();
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }

    public void modificar(Libro libro) {
        Iterator<Libro> iterator = libros.iterator();
        while (iterator.hasNext()) {
            Libro li = iterator.next();
            if (libro.getId() == li.getId()) {
                li.setTitulo(libro.getTitulo());
                li.setAutor(libro.getAutor());
                li.setEditorial(libro.getEditorial());
                li.setFecha(libro.getFecha());
                li.setTematica(libro.getTematica());
                break;
            }
        }
    }
}

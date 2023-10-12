package com.example.crudspring.bean;

import jakarta.persistence.*;

@Entity // Transforma la clase en una entidad de JPA
@Table(name = "libros") // Indica que la tabla de la base de datos se llama libros
public class Libro {
    @Id // Indica que el atributo id es la clave primaria de la tabla
    @Column(name = "id") // Indica que el atributo id hace referencia a la columna id de la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Indica que el atributo id es autoincremental en la base de datos
    private int id;
    @Column(name = "titulo", nullable = false, length = 30)
    private String titulo;
    @Column(name = "autor")
    private String autor;
    @Column(name = "editorial")
    private String editorial;
    @Column(name = "fecha")
    private String fecha;
    @Column(name = "tematica")
    private String tematica;

    public Libro(int id, String titulo, String autor, String editorial, String fecha, String tematica) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.fecha = fecha;
        this.tematica = tematica;
    }

    // Constructor vacío necesario para que funcione JPA
    public Libro() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }
}

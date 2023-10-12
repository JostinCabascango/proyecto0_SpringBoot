package com.example.crudspring.service;

import com.example.crudspring.bean.Libro;

import java.util.ArrayList;

public interface IBaseDatos3 {
    public void insertar(Libro libro);

    public void borrar(int id);

    public void modificar(Libro libro);

    public Libro getLibro(int id);

    public ArrayList<Libro> getLibros();

    public boolean existeUsuario(String nombre, String password);


}

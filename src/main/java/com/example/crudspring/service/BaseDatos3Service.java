package com.example.crudspring.service;

import com.example.crudspring.bean.Libro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BaseDatos3Service implements IBaseDatos3 {
    @Override
    public void insertar(Libro libro) {

    }

    @Override
    public void borrar(int id) {

    }

    @Override
    public void modificar(Libro libro) {

    }

    @Override
    public Libro getLibro(int id) {
        return null;
    }

    @Override
    public ArrayList<Libro> getLibros() {
        return null;
    }

    @Override
    public boolean existeUsuario(String nombre, String password) {
        return false;
    }
}

package com.example.crudspring.service;

import com.example.crudspring.bean.Libro;
import com.example.crudspring.repository.BaseDatos3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class BaseDatos3Service implements IBaseDatos3 {
    // Inyecta la dependencia de BaseDatos3 en el servicio
    @Autowired
    BaseDatos3 bd;

    @Override
    public void insertar(Libro libro) {
        bd.save(libro);

    }

    @Override
    public void borrar(int id) {
        bd.deleteById(id);

    }

    @Override
    public void modificar(Libro libro) {
        bd.save(libro);

    }

    @Override
    public Libro getLibro(int id) {
        Optional<Libro> libro = bd.findById(id);
        return libro.orElse(null); // Devuelve el libro si existe, o null si no existe
    }

    @Override
    public ArrayList<Libro> getLibros() {
        return (ArrayList<Libro>) bd.findAll();
    }

    @Override
    public boolean existeUsuario(String nombre, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String conexionURL = "jdbc:mysql://localhost:3333/biblioteca_online";
            Connection conexion = java.sql.DriverManager.getConnection(conexionURL, "root", "root");
            String query = "SELECT * FROM usuarios WHERE usuario = ? AND password = ?";
            PreparedStatement preparedStatement = conexion.prepareStatement(query);
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next(); // Devuelve true si existe el usuario, o false si no existe
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Error al comprobar la existencia del usuario", e);
        }
    }
}

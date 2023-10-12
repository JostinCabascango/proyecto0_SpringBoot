package com.example.crudspring.repository;

import com.example.crudspring.bean.Libro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BaseDatos2 {
    private Connection conexion;

    public BaseDatos2() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //jdbc:mysql://localhost:3333/biblioteca_online
            String conexionURL = "jdbc:mysql://localhost:3333/biblioteca_online";
            this.conexion = java.sql.DriverManager.getConnection(conexionURL, "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertar(Libro libro) {
        // INSERT INTO libros (id,titulo, autor, editorial, fecha, tematica) VALUES (1, "El Quijote", "Cervantes", "Anaya", "1605", "Novela");
        String query = "INSERT INTO libros (id,titulo, autor, editorial, fecha, tematica) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(query);
            preparedStatement.setInt(1, libro.getId());
            preparedStatement.setString(2, libro.getTitulo());
            preparedStatement.setString(3, libro.getAutor());
            preparedStatement.setString(4, libro.getEditorial());
            preparedStatement.setString(5, libro.getFecha());
            preparedStatement.setString(6, libro.getTematica());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

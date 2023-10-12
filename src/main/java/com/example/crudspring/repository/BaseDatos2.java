package com.example.crudspring.repository;

import com.example.crudspring.bean.Libro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

    // Inserta un libro en la base de datos
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

    // Borra un libro de la base de datos
    public void borrar(int id) {
        String query = "DELETE FROM libros WHERE id = ?";
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el libro por ID: " + ex.getMessage());
        }

    }

    // Modifica un libro de la base de datos
    public void modificar(Libro libro) {
        String query = "UPDATE libros SET titulo = ?, autor = ?, editorial = ?, fecha = ?, tematica = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(query);
            preparedStatement.setString(1, libro.getTitulo());
            preparedStatement.setString(2, libro.getAutor());
            preparedStatement.setString(3, libro.getEditorial());
            preparedStatement.setString(4, libro.getFecha());
            preparedStatement.setString(5, libro.getTematica());
            preparedStatement.setInt(6, libro.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al modificar el libro por ID: " + ex.getMessage());
        }

    }

    // Devuelve un libro de la base de datos
    public Libro getLibro(int id) {
        String query = "SELECT * FROM libros WHERE id = ?";
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(query);
            // Establece el id del libro en la consulta
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            // Si existe un libro con el id indicado, lo devuelve
            if (resultSet.next()) {
                // Crea un objeto libro con los datos obtenidos de la base de datos
                Libro libro = new Libro(resultSet.getInt("id"), resultSet.getString("titulo"), resultSet.getString("autor"), resultSet.getString("editorial"), resultSet.getString("fecha"), resultSet.getString("tematica"));
                return libro;
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener el libro por ID: " + ex.getMessage());
        }
        return null;
    }

    //Devuelve todos los libros de la base de datos
    public ArrayList<Libro> getLibros() {
        ArrayList<Libro> libros = new ArrayList<>();
        String query = "SELECT * FROM libros";
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            //Itera sobre los resultados obtenidos de la base de datos y los añade al ArrayList
            while (resultSet.next()) {
                Libro libro = new Libro(resultSet.getInt("id"), resultSet.getString("titulo"), resultSet.getString("autor"), resultSet.getString("editorial"), resultSet.getString("fecha"), resultSet.getString("tematica"));
                libros.add(libro);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener los libros: " + ex.getMessage());
        }
        return libros;
    }

}

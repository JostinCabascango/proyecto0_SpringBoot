package com.example.crudspring.repository;

import com.example.crudspring.bean.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseDatos3 extends JpaRepository<Libro, Integer> {
}
package com.example.crudspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // Anotación que indica que esta clase es un controlador de Spring
@RequestMapping("") // Anotación que indica que este controlador responde a la raíz del servidor
public class Controlador {
    @GetMapping("/")
    // Responde a la petición GET de la raíz del servidor y devuelve la vista login (login.html)
    public String iniciar(Model model) {
        // Model es un objeto que permite pasar datos a la vista
        model.addAttribute("titulo", "FORMULARIO DE ACCESO"); // Añade el atributo titulo a la vista login.html
        return "login";
    }

    // Responde a la petición POST de la raíz del servidor y devuelve la vista consulta (consulta.html)
    @PostMapping("/")
    public String login(Model model, @RequestParam String nombre, @RequestParam String password) {
        // @RequestParam es una anotación que indica que el parámetro se pasa por la URL
        // Tiene que coincidir el nombre del parámetro con el nombre del campo del formulario de la vista
        if (nombre.equals("edu") && password.equals("1234")) {
            return "consulta";
        } else {
            return "login";
        }
    }
}

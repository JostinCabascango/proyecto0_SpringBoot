package com.example.crudspring.controllers;

import com.example.crudspring.bean.Usuario;
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
    public String login(Usuario usuario, Model model) {
        if (usuario.getNombre().equals("edu") && usuario.getPassword().equals("edu")) {
            model.addAttribute("usuario", usuario);
            return "consulta";
        } else {
            model.addAttribute("error", "Credenciales incorrectas. Por favor, inténtalo de nuevo.");
            return "login";
        }
    }
}

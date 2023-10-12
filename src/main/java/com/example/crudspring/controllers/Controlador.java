package com.example.crudspring.controllers;

import com.example.crudspring.bean.Libro;
import com.example.crudspring.bean.Usuario;
import com.example.crudspring.repository.BaseDatos;
import com.example.crudspring.repository.BaseDatos2;
import com.example.crudspring.repository.BaseDatos3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@Controller // Anotación que indica que esta clase es un controlador de Spring
@RequestMapping("") // Anotación que indica que este controlador responde a la raíz del servidor
public class Controlador {
    //BaseDatos bd = new BaseDatos();
    //BaseDatos2 bd = new BaseDatos2();
    // Inyecta la dependencia de BaseDatos3 en el controlador
    @Autowired
    BaseDatos3 bd;
    Usuario usuario;

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
        // Comprueba que el usuario y la contraseña sean correctos (edu/edu) y si lo son, devuelve la vista consulta (consulta.html)
        if (usuario.getNombre() != null && usuario.getPassword() != null && usuario.getNombre().equals("edu") && usuario.getPassword().equals("edu")) {
            ArrayList<Libro> libros = bd.getLibros();
            model.addAttribute("usuario", usuario);  // Añade el atributo usuario a la vista consulta.html
            this.usuario = usuario; // Guarda el usuario en el atributo usuario de la clase Controlador
            model.addAttribute("libros", libros); // Añade el atributo libros a la vista consulta.html
            return "consulta";
        } else {
            model.addAttribute("error", "Credenciales incorrectas. Por favor, inténtalo de nuevo.");
            return "login";
        }
    }

    // Responde a la petición POST de la ruta /insertar y devuelve la vista consulta (consulta.html)
    @PostMapping("/insertar")
    public String insertar(Libro libro, Model model) {
        bd.insertar(libro);
        ArrayList<Libro> libros = bd.getLibros();
        model.addAttribute("usuario", this.usuario);
        model.addAttribute("libros", libros);
        model.addAttribute("boton", "insertar");
        model.addAttribute("action", "/insertar");
        model.addAttribute("libro", null);
        return "consulta";
    }

    // Responde a la petición GET de la ruta /borrado/{id} y devuelve la vista consulta (consulta.html)
    @GetMapping("/borrado/{id}")
    public String borrar(@PathVariable int id, Model model) {
        bd.borrar(id);
        ArrayList<Libro> libros = bd.getLibros();
        model.addAttribute("usuario", this.usuario);
        model.addAttribute("libros", libros);
        model.addAttribute("boton", "insertar");
        model.addAttribute("action", "/insertar");
        return "consulta";
    }

    // Responde a la petición GET de la ruta /modificar/{id} y devuelve la vista consulta (consulta.html)
    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable int id, Model model) {
        Libro libro = bd.getLibro(id); // Obtiene el libro con el id indicado
        ArrayList<Libro> libros = bd.getLibros();
        model.addAttribute("usuario", this.usuario);
        model.addAttribute("libros", libros);
        model.addAttribute("boton", "Actualizar");
        model.addAttribute("action", "/modificar");
        model.addAttribute("libro", libro); // Añade el atributo libro a la vista consulta.html
        return "consulta";
    }

    // Responde a la petición POST de la ruta /modificar y devuelve la vista consulta (consulta.html)
    @PostMapping("/modificar")

    public String modificar(Libro libro, Model model) {
        bd.modificar(libro);
        ArrayList<Libro> libros = bd.getLibros();
        model.addAttribute("usuario", this.usuario);
        model.addAttribute("libros", libros);
        model.addAttribute("boton", "insertar");
        model.addAttribute("action", "/insertar");
        model.addAttribute("libro", null);
        return "consulta";
    }


}

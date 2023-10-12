package com.example.crudspring.controllers;

import com.example.crudspring.bean.Libro;
import com.example.crudspring.bean.Usuario;
import com.example.crudspring.service.BaseDatos3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("")
public class Controlador {

    @Autowired
    private BaseDatos3Service bd;
    private Usuario usuario;

    @GetMapping("/")
    public String mostrarFormularioAcceso(Model model) {
        model.addAttribute("titulo", "FORMULARIO DE ACCESO");
        return "login";
    }

    @PostMapping("/")
    public String procesarAcceso(Usuario usuario, Model model) {
        if (sonCredencialesValidas(usuario)) {
            cargarLibros(model, usuario);
            return "consulta";
        } else {
            model.addAttribute("error", "Credenciales incorrectas. Por favor, inténtalo de nuevo.");
            return "login";
        }
    }

    @PostMapping("/insertar")
    public String insertarLibro(Libro libro, Model model) {
        bd.insertar(libro);
        return cargarLibros(model, this.usuario);
    }

    @GetMapping("/borrado/{id}")
    public String borrarLibro(@PathVariable int id, Model model) {
        bd.borrar(id);
        return cargarLibros(model, this.usuario);
    }

    @GetMapping("/modificar/{id}")
    public String mostrarFormularioModificar(@PathVariable int id, Model model) {
        Libro libro = bd.getLibro(id);
        ArrayList<Libro> libros = bd.getLibros();
        model.addAttribute("usuario", this.usuario);
        model.addAttribute("libros", libros);
        model.addAttribute("boton", "Actualizar");
        model.addAttribute("action", "/modificar");
        model.addAttribute("libro", libro);
        return "consulta";
    }

    @PostMapping("/modificar")
    public String modificarLibro(Libro libro, Model model) {
        bd.modificar(libro);
        return cargarLibros(model, this.usuario);
    }

    private boolean sonCredencialesValidas(Usuario usuario) {
        return usuario.getNombre() != null && usuario.getPassword() != null && usuario.getNombre().equals("edu") && usuario.getPassword().equals("edu");
    }

    private String cargarLibros(Model model, Usuario usuario) {
        ArrayList<Libro> libros = bd.getLibros();
        model.addAttribute("usuario", usuario);
        model.addAttribute("libros", libros);
        model.addAttribute("boton", "insertar");
        model.addAttribute("action", "/insertar");
        model.addAttribute("libro", null);
        return "consulta";
    }
}

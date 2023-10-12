# Proyecto 0 - Spring Boot y Thymeleaf

Este es un proyecto de práctica guiada que utiliza Spring Boot y Thymeleaf.

## Descripción

Este proyecto es una introducción a la utilización de Spring Boot junto con Thymeleaf para crear aplicaciones web. El
proyecto incluye un sistema de acceso y funcionalidades para mostrar, insertar, borrar y modificar libros.

## Rutas

El proyecto define las siguientes rutas:

1. `@GetMapping("/")`: Muestra el formulario de acceso.
2. `@PostMapping("/")`: Procesa el formulario de acceso.
3. `@PostMapping("/insertar")`: Inserta un nuevo libro.
4. `@GetMapping("/borrado/{id}")`: Borra un libro con el ID especificado.
5. `@GetMapping("/modificar/{id}")`: Muestra el formulario para modificar un libro con el ID especificado.
6. `@PostMapping("/modificar")`: Modifica un libro.

## Instalación

Para instalar y ejecutar este proyecto, necesitarás tener instalado Java y Maven.

1. Clona o descarga este repositorio en tu máquina local:

```bash
git clone https://github.com/JostinCabascango/proyecto0_SpringBoot.git
```

2. Ejecuta la aplicación Spring Boot

```bash
mvn spring-boot:run
```

Si estás utilizando un IDE como Eclipse, puedes importar el proyecto directamente en el IDE y ejecutarlo desde allí.

## Uso

Una vez que el servidor esté en funcionamiento, puedes acceder a la aplicación a través de tu navegador web
en [localhost:8080/](http://localhost:8080/).

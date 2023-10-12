-- Creación de la tabla 'libros' si no existe
CREATE TABLE IF NOT EXISTS libros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    autor VARCHAR(50) NOT NULL,
    editorial VARCHAR(50) NOT NULL,
    fecha DATE NOT NULL,
    tematica VARCHAR(50) NOT NULL
    );
-- Creación de la tabla 'usuarios' si no existe
CREATE TABLE IF NOT EXISTS usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(30) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL
    );
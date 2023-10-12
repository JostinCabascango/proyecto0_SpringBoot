-- Inserciones en la tabla 'libros'
DELETE FROM libros;
INSERT IGNORE INTO libros (titulo, autor, editorial, fecha, tematica) VALUES
('El Quijote', 'Cervantes', 'Anaya', '1605-01-01', 'Novela'),
('El Señor de los Anillos', 'Tolkien', 'Minotauro', '1954-01-01', 'Fantasía'),
('El Principito', 'Saint-Exupéry', 'Salamandra', '1943-01-01', 'Infantil'),
('El Hobbit', 'Tolkien', 'Minotauro', '1937-01-01', 'Fantasía'),
('Cien años de soledad', 'García Márquez', 'Sudamericana', '1967-01-01', 'Novela'),
('El Código Da Vinci', 'Brown', 'Umbriel', '2003-01-01', 'Novela'),
('El Alquimista', 'Coelho', 'Planeta', '1988-01-01', 'Novela'),
('El nombre del viento', 'Rothfuss', 'Plaza & Janés', '2007-01-01', 'Fantasía'),
('El retrato de Dorian Gray', 'Wilde', 'Alianza', '1890-01-01', 'Novela'),
('1984', 'George Orwell', 'Secker & Warburg', '1949-01-01', 'Ciencia Ficción'),
('Don Quijote', 'Miguel de Cervantes', 'Anaya', '1605-01-01', 'Novela'),
('Matar un ruiseñor', 'Harper Lee', 'J. B. Lippincott & Co.', '1960-01-01', 'Novela'),
('La Odisea', 'Homero', 'Desconocida', '0000-01-01', 'Epopeya'), -- Cambia la fecha
('Crimen y Castigo', 'Fiodor Dostoievski', 'Editorial El Galeón', '1866-01-01', 'Novela'),
('Drácula', 'Bram Stoker', 'Archibald Constable and Company', '1897-01-01', 'Terror'),
('Moby-Dick', 'Herman Melville', 'Richard Bentley', '1851-01-01', 'Aventura'),
('Ulises', 'James Joyce', 'Sylvia Beach', '1922-01-01', 'Novela'),
('Cien años de soledad', 'Gabriel García Márquez', 'Sudamericana', '1967-01-01', 'Novela'),
('Harry Potter y la piedra filosofal', 'J.K. Rowling', 'Bloomsbury', '1997-01-01', 'Fantasía');
DELETE FROM usuarios;
-- Inserciones en la tabla 'usuarios'
INSERT IGNORE INTO usuarios (usuario, password) VALUES
('admin', '456'),
('itic', 'itic'),
('edu', 'edu');

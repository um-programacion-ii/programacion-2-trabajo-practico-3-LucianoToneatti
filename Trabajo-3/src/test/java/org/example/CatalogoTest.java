package org.example;

import org.example.estados.Estado;
import org.example.modelos.Catalogo;
import org.example.modelos.Libro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

class CatalogoTest {

    private Catalogo catalogo;
    private Libro libro1;
    private Libro libro2;
    private Libro libro3;

    @BeforeEach
    void setUp() {
        catalogo = new Catalogo();
        libro1 = new Libro("978-3-16-148410-0", "Clean Code", "Robert C. Martin");
        libro2 = new Libro("978-0-13-235088-4", "Clean Architecture", "Robert C. Martin");
        libro3 = new Libro("978-1-61-729494-5", "Effective Java", "Joshua Bloch", Estado.PRESTADO);

        catalogo.agregarLibro(libro1);
        catalogo.agregarLibro(libro2);
        catalogo.agregarLibro(libro3);
    }

    @Test
    void testBuscarPorIsbn_Existe() {
        Optional<Libro> libro = catalogo.buscarPorIsbn("978-3-16-148410-0");
        assertTrue(libro.isPresent());
        assertEquals("Clean Code", libro.get().getTitulo());
    }

    @Test
    void testBuscarPorIsbn_NoExiste() {
        Optional<Libro> libro = catalogo.buscarPorIsbn("000-0-00-000000-0");
        assertFalse(libro.isPresent());
    }

    @Test
    void testObtenerLibrosDisponibles() {
        List<Libro> disponibles = catalogo.obtenerLibrosDisponibles();
        assertEquals(2, disponibles.size());
        assertTrue(disponibles.contains(libro1));
        assertTrue(disponibles.contains(libro2));
        assertFalse(disponibles.contains(libro3));
    }
}


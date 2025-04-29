package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibroTest {


    //TEST del profesor como ejemplo
    @Test
    void testCrearLibroValido() {
        Libro libro = new Libro("978-3-16-148410-0", "Principito", "Manolo");

        assertEquals("978-3-16-148410-0", libro.getIsbn());
        assertEquals("Principito", libro.getTitulo());
        assertEquals("Manolo", libro.getAutor());
        assertEquals(Estado.DISPONIBLE, libro.getEstado());
    }

    //TEST para ver si cambia de estado el libro
    @Test
    void testCambioEstadoLibro() {
        Libro libro = new Libro("978-3-16-148410-0", "Principito", "Manolo");

        libro.setEstado(Estado.PRESTADO);
        assertEquals(Estado.PRESTADO, libro.getEstado());
    }
}

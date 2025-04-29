package org.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;

class SistemaPrestamosTest {

    @Mock
    private Catalogo catalogo;

    @InjectMocks
    private SistemaPrestamos sistemaPrestamos;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCrearPrestamo() {
        Libro libro = new Libro("123", "Titulo", "Autor");
        Prestamo prestamo = new Prestamo(LocalDate.now(), libro);

        assertEquals(LocalDate.now(), prestamo.getFechaPrestamo());
        assertEquals(libro, prestamo.getLibro());
    }

    @Test
    void testPrestarLibro() {
        Libro libro = new Libro("978-3-16-148410-0", "Clean Code", "Robert C. Martin");

        when(catalogo.buscarPorIsbn("978-3-16-148410-0")).thenReturn(Optional.of(libro));

        Prestamo prestamo = sistemaPrestamos.prestarLibro("978-3-16-148410-0");

        assertNotNull(prestamo);
        verify(catalogo).buscarPorIsbn("978-3-16-148410-0");
        assertEquals(Estado.PRESTADO, libro.getEstado());
    }

}

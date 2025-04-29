package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UsuariosTest {

    @Mock
    private Catalogo catalogo;

    @Mock
    private SistemaPrestamos sistemaPrestamos;

    @InjectMocks
    private GestionUsuarios gestionUsuarios;

    private Usuario usuario;
    private Prestamo prestamo;

    @BeforeEach
    void setUp() {
        gestionUsuarios = new GestionUsuarios();
        usuario = new Usuario("juan");
        gestionUsuarios.registrarUsuario(usuario);

        Libro libro = new Libro("978-3-16-148410-0", "Dora la exploradora", "Robert C. Martin");
        prestamo = new Prestamo(java.time.LocalDate.now(), libro);
    }

    @Test
    void testRegistrarPrestamo() {
        when(sistemaPrestamos.prestarLibro("978-3-16-148410-0")).thenReturn(prestamo);

        gestionUsuarios.registrarPrestamo("juan", "978-3-16-148410-0", sistemaPrestamos);

        verify(sistemaPrestamos).prestarLibro("978-3-16-148410-0");
        assertEquals(1, usuario.getHistorialPrestamos().size());
    }

    @Test
    void testRegistrarPrestamoUsuarioNoExiste() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            gestionUsuarios.registrarPrestamo("noExiste", "978-3-16-148410-0", sistemaPrestamos);
        });

        assertEquals("Usuario no encontrado", exception.getMessage());
    }
}


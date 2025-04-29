package org.example;

import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SistemaPrestamos {
    @Getter
    private List<Prestamo> prestamos;
    private final Catalogo catalogo;

    public SistemaPrestamos(Catalogo catalogo) {
        this.prestamos = new ArrayList<>();
        this.catalogo = catalogo;
    }

    public Prestamo prestarLibro(String isbn) {
        Optional<Libro> libroOptional = catalogo.buscarPorIsbn(isbn);
        if (libroOptional.isEmpty()) {
            throw new RuntimeException("Libro no encontrado");
        }

        Libro libro = libroOptional.get();
        if (libro.getEstado() == Estado.PRESTADO) {
            throw new RuntimeException("Libro no disponible");
        }
        libro.setEstado(Estado.PRESTADO);
        return new Prestamo(LocalDate.now(), libro);
    }


}

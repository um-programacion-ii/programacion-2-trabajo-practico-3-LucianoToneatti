package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Catalogo {

    private final List<Libro> libros;

    public Catalogo() {
        this.libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public Optional<Libro> buscarPorIsbn(String isbn) {
        return libros.stream()
                .filter(libro -> libro.getIsbn().equals(isbn))
                .findFirst();
    }

    public List<Libro> obtenerLibrosDisponibles() {
        return libros.stream()
                .filter(libro -> libro.getEstado() == Estado.DISPONIBLE)
                .toList();
    }
}

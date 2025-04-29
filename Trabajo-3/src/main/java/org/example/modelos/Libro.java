package org.example.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.estados.Estado;

@Data //Lo uso para generar los getters, setters y no escribirlos
@AllArgsConstructor //Este genera el constructor
@NoArgsConstructor // Y con este genero un costructor vacio

public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private Estado estado;

    public Libro(String isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.estado = Estado.DISPONIBLE;
    }
}


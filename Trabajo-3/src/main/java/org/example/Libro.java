package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Lo uso para generar los getters, setters y no escribirlos
@AllArgsConstructor //Este genera el constructor
@NoArgsConstructor // Y con este genero un costructor vacio

public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private Estado estado;
}


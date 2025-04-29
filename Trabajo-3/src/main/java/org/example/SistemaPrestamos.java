package org.example;

import java.util.ArrayList;
import java.util.List;

public class SistemaPrestamos {
    private List<Prestamo> prestamos;

    public SistemaPrestamos() {
        this.prestamos = new ArrayList<>();
    }

    public void registrarPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }
}

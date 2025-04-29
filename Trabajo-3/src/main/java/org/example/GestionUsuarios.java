package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GestionUsuarios {
    private List<Usuario> usuarios;

    public GestionUsuarios() {
        this.usuarios = new ArrayList<>();
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public List<Usuario> obtenerUsuarios() {
        return usuarios;
    }

    public void registrarPrestamo(String nombreUsuario, String isbn, SistemaPrestamos sistemaPrestamos) {
        Optional<Usuario> usuarioOptional = usuarios.stream()
                .filter(u -> u.getNombre().equals(nombreUsuario))
                .findFirst();

        if (usuarioOptional.isEmpty()) {
            throw new RuntimeException("Usuario no encontrado");
        }

        Prestamo prestamo = sistemaPrestamos.prestarLibro(isbn);
        usuarioOptional.get().agregarPrestamo(prestamo);
    }
}



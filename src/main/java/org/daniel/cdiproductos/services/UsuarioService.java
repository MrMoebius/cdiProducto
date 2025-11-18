package org.daniel.cdiproductos.services;

import org.daniel.cdiproductos.models.Usuario;

import java.util.Optional;

public interface UsuarioService {
    Optional<Usuario> login(String username, String password);
}

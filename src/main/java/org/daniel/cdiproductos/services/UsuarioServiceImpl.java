package org.daniel.cdiproductos.services;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import org.daniel.cdiproductos.models.Usuario;
import org.daniel.cdiproductos.repositorys.UsuarioRepository;
import org.daniel.cdiproductos.repositorys.UsuarioRepositoryImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

@RequestScoped
public class UsuarioServiceImpl implements UsuarioService{
    @Inject
    private UsuarioRepository usuarioRepository;

//    public UsuarioServiceImpl(Connection connection) {
//        this.usuarioRepository = new UsuarioRepositoryImpl(connection);
//    }

    @Inject
    private ProductoService productoService;

    @Override
    public Optional<Usuario> login(String username, String password) {
        try {
            return Optional.ofNullable(usuarioRepository.porUsername(username)).filter(u -> u.getPassword().equals(password));
        } catch (SQLException throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }
}

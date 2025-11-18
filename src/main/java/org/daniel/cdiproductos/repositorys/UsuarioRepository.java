package org.daniel.cdiproductos.repositorys;

import org.daniel.cdiproductos.models.Usuario;

import java.sql.SQLException;

public interface UsuarioRepository extends Repository<Usuario>{
    Usuario porUsername(String username) throws SQLException;
}

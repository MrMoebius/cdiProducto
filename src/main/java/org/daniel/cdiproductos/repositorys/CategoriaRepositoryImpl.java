package org.daniel.cdiproductos.repositorys;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.daniel.cdiproductos.models.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@ApplicationScoped  // Application porque no tienen estado. solo logica
public class CategoriaRepositoryImpl implements Repository<Categoria> {

    private final Connection conn;

    @Inject
    public CategoriaRepositoryImpl(@Named("producerConn") Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Categoria> listar() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from categorias")) {
            while (rs.next()) {
                Categoria categoria = getCategoria(rs);
                categorias.add(categoria);
            }
        }
        return categorias;
    }

    @Override
    public Categoria porId(Long id) throws SQLException {
        Categoria categoria = null;
        try (PreparedStatement stmt = conn.prepareStatement("select * from categorias as c where c.id=?")) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    categoria = getCategoria(rs);
                }
            }
        }
        return categoria;
    }

    @Override
    public void guardar(Categoria categoria) throws SQLException {
        // Implementar este método según tu lógica
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        // Implementar este método según tu lógica
    }

    private Categoria getCategoria(ResultSet rs) throws SQLException {
        Categoria categoria = new Categoria();
        categoria.setNombre(rs.getString("nombre"));
        categoria.setId(rs.getLong("id"));
        return categoria;
    }
}

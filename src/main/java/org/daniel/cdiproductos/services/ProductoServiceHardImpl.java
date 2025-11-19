package org.daniel.cdiproductos.services;

import org.daniel.cdiproductos.models.Categoria;
import org.daniel.cdiproductos.models.Producto;

import java.util.List;
import java.util.Optional;


public class ProductoServiceHardImpl implements ProductoService{


    // Esto realmente no se va a usar
    @Override
    public List<Producto> listar() {
        return List.of();
    }

    @Override
    public Optional<Producto> porId(Long id) {
        return Optional.empty();
    }

    @Override
    public void guardar(Producto producto) {

    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public List<Categoria> listarCategoria() {
        return List.of();
    }

    @Override
    public Optional<Categoria> porIdCategoria(Long id) {
        return Optional.empty();
    }
}

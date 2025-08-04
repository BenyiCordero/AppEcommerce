package com.bcss.shopall.service;

import com.bcss.shopall.domain.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {

    Categoria crearCategoria(Categoria categoria);
    void actualizarCategoria(Long id);
    void eliminarCategoria(Long id);
    Optional<Categoria> buscarCategoria(Long id);
    List<Categoria> listaCategorias();


}

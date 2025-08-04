package com.bcss.shopall.service;

import com.bcss.shopall.domain.Categoria;
import com.bcss.shopall.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public Categoria crearCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public void actualizarCategoria(Long id) {

    }

    @Override
    public void eliminarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }

    @Override
    public Optional<Categoria> buscarCategoria(Long id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public List<Categoria> listaCategorias() {
        return categoriaRepository.findAll();
    }
}

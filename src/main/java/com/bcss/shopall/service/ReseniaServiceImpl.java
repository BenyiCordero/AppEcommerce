package com.bcss.shopall.service;

import com.bcss.shopall.domain.Producto;
import com.bcss.shopall.domain.Resenia;
import com.bcss.shopall.repository.ReseniaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReseniaServiceImpl implements ReseniaService {

    private final ReseniaRepository reseniaRepository;
    private final ProductoService productoService;

    public ReseniaServiceImpl(ReseniaRepository reseniaRepository, ProductoService productoService) {
        this.reseniaRepository = reseniaRepository;
        this.productoService = productoService;
    }

    @Transactional
    public Resenia crearResenia(Resenia resenia) {
        Optional<Producto> producto = productoService.buscarProductoPorId(resenia.getProducto().getIdProducto());
        resenia.setProducto(producto.get());
        return reseniaRepository.save(resenia);
    }

    @Transactional
    public void actualizarResenia(Resenia resenia) {

    }

    @Override
    public Optional<Resenia> buscarPorId(Long id) {
        return reseniaRepository.findById(id);
    }

    @Override
    public List<Resenia> listaResenias() {
        return reseniaRepository.findAll();
    }

    @Override
    public List<Resenia> listaReseniasPorProducto(Long id) {
        return reseniaRepository.findByProducto(productoService.buscarProductoPorId(id).get());
    }
}

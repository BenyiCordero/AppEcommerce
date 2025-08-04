package com.bcss.shopall.service;

import com.bcss.shopall.domain.MetodoPago;
import com.bcss.shopall.repository.MetodoPagoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetodoPagoServiceImpl implements MetodoPagoService {

    private final MetodoPagoRepository metodoPagoRepository;

    public MetodoPagoServiceImpl(MetodoPagoRepository metodoPagoRepository) {
        this.metodoPagoRepository = metodoPagoRepository;
    }

    @Override
    public MetodoPago crearMetodoPago(MetodoPago metodoPago) {
        return metodoPagoRepository.save(metodoPago);
    }

    @Override
    public void actualizarMetodoPago(MetodoPago metodoPago) {

    }

    @Override
    public Optional<MetodoPago> buscarPorId(Long id) {
        return metodoPagoRepository.findById(id);
    }

    @Override
    public List<MetodoPago> listarMetodoPago() {
        return metodoPagoRepository.findAll();
    }
}

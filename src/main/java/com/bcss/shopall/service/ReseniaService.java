package com.bcss.shopall.service;

import com.bcss.shopall.domain.Resenia;

import java.util.List;
import java.util.Optional;

public interface ReseniaService {

    Resenia crearResenia(Resenia resenia);
    void actualizarResenia(Resenia resenia);
    Optional<Resenia> buscarPorId(Long id);
    List<Resenia> listaResenias();
    List<Resenia> listaReseniasPorProducto(Long id);

}

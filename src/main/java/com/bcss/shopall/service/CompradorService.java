package com.bcss.shopall.service;

import com.bcss.shopall.domain.Comprador;

import java.util.List;
import java.util.Optional;

public interface CompradorService {

    void actualizarComprador(Comprador comprador);
    void eliminarComprador(Long id);
    List<Comprador> listaCompradores();
    Optional<Comprador> buscarCompradorPorId(Long id);

}

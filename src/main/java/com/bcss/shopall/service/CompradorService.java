package com.bcss.shopall.service;

import com.bcss.shopall.dto.Comprador;

import java.util.List;
import java.util.Optional;

public interface CompradorService {

    void crearComprador(Comprador comprador);
    void actualizarComprador(Comprador comprador);
    void eliminarComprador(Long id);
    List<Comprador> listaCompradores();
    Optional<Comprador> buscarCompradorPorId(Long id);

}

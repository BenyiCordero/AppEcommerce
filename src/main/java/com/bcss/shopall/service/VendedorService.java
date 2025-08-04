package com.bcss.shopall.service;

import com.bcss.shopall.domain.Vendedor;

import java.util.List;
import java.util.Optional;

public interface VendedorService {

    void crearVendedor(Vendedor vendedor);
    void actualizarVendedor(Vendedor vendedor);
    void eliminarVendedor(Long id);
    List<Vendedor> listaVendedores();
    Optional<Vendedor> buscarVendedorPorId(Long id);

}

package com.bcss.shopall.service;

import com.bcss.shopall.domain.Tienda;

import java.util.List;
import java.util.Optional;

public interface TiendaService {

    Tienda crearTienda(Tienda tienda);
    void eliminarTienda(Long id);
    List<Tienda> listaPersonas();
    Optional<Tienda> obtenerTiendaById(Long id);

}

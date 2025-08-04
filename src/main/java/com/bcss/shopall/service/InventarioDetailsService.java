package com.bcss.shopall.service;

import com.bcss.shopall.domain.InventarioDetails;

import java.util.List;
import java.util.Optional;

public interface InventarioDetailsService {

    InventarioDetails crearInventarioDetails(InventarioDetails inventarioDetails);
    Optional<InventarioDetails> findById(Long id);
    List<InventarioDetails> findByInventarioId(Long inventarioId);

}

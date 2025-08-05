package com.bcss.shopall.service;

import com.bcss.shopall.domain.ProductoDetails;

import java.util.List;
import java.util.Optional;

public interface ProductoDetailsService {

    ProductoDetails crearInventarioDetails(ProductoDetails productoDetails);
    Optional<ProductoDetails> findById(Long id);
    List<ProductoDetails> findByInventarioId(Long inventarioId);

}

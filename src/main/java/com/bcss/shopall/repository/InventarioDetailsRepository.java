package com.bcss.shopall.repository;

import com.bcss.shopall.domain.Inventario;
import com.bcss.shopall.domain.Producto;
import com.bcss.shopall.domain.InventarioDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventarioDetailsRepository extends JpaRepository<InventarioDetails, Long> {

    List<InventarioDetails> findByInventario(Inventario inventario);
    Optional<InventarioDetails> findByProducto(Producto producto);

}

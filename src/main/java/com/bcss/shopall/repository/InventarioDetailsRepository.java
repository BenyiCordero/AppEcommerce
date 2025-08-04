package com.bcss.shopall.repository;

import com.bcss.shopall.domain.Inventario;
import com.bcss.shopall.domain.InventarioDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventarioDetailsRepository extends JpaRepository<InventarioDetails, Long> {

    List<InventarioDetails> findByInventario(Inventario inventario);

}

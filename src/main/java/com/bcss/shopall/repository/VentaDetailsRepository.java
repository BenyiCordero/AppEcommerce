package com.bcss.shopall.repository;

import com.bcss.shopall.domain.Venta;
import com.bcss.shopall.domain.VentaDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentaDetailsRepository extends JpaRepository<VentaDetails, Long> {

    List<VentaDetails> findByVenta(Venta venta);
    
}

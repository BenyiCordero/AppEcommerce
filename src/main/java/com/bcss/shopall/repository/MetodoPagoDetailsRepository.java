package com.bcss.shopall.repository;

import com.bcss.shopall.domain.Inventario;
import com.bcss.shopall.domain.MetodoPagoDetails;
import com.bcss.shopall.domain.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MetodoPagoDetailsRepository extends JpaRepository<MetodoPagoDetails, Long> {

    List<MetodoPagoDetails> findByVenta(Venta venta);

}

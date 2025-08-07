package com.bcss.shopall.repository;

import com.bcss.shopall.domain.Carrito;
import com.bcss.shopall.domain.CarritoDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarritoDetailsRepository extends JpaRepository<CarritoDetails, Long> {

    List<CarritoDetails> findByCarrito(Carrito carrito);
    @Query(value = "SELECT * FROM v_carritod", nativeQuery = true)
    List<CarritoDetails> findByComprador(Long id_comprador);

}

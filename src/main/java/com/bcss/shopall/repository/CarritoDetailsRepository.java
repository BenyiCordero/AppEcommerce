package com.bcss.shopall.repository;

import com.bcss.shopall.domain.CarritoDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarritoDetailsRepository extends JpaRepository<CarritoDetails, Long> {

    //Poner la query
    List<CarritoDetails> findByCarritoId(Long carritoId);

}

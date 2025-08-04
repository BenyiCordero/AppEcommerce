package com.bcss.shopall.repository;

import com.bcss.shopall.domain.Comprador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompradorRepository extends JpaRepository<Comprador,Long> {
}

package com.bcss.shopall.repository;

import com.bcss.shopall.dto.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor,Long> {
}

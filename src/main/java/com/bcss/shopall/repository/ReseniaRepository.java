package com.bcss.shopall.repository;

import com.bcss.shopall.domain.Comprador;
import com.bcss.shopall.domain.Producto;
import com.bcss.shopall.domain.Resenia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReseniaRepository extends JpaRepository<Resenia,Long> {

    List<Resenia> findByProducto(Producto producto);

}

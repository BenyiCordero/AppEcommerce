package com.bcss.shopall.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "VentaDetails")
public class VentaDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVentaDetails;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "total")
    private Double total;
    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "idProducto")
    private Producto producto;
    @ManyToOne
    @JoinColumn(name = "id_venta", referencedColumnName = "idVenta")
    private Venta venta;

}

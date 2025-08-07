package com.bcss.shopall.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "InventarioDetails")
public class InventarioDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInventarioDetails;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "precio")
    private Double precio;
    @ManyToOne
    @JoinColumn(name = "id_inventario", referencedColumnName = "idInventario")
    private Inventario inventario;
    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "idProducto")
    private Producto producto;

}

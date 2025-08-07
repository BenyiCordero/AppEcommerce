package com.bcss.shopall.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CarritoDetails")
public class CarritoDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCarritoDetails;
    @Column(name = "cantidad")
    private Integer cantidad;
    @ManyToOne
    @JoinColumn(name = "id_carrito", referencedColumnName = "idCarrito")
    private Carrito carrito;
    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "idProducto")
    private Producto producto;

}

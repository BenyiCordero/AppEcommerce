package com.bcss.shopall.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MetodoPagoDetails")
public class MetodoPagoDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMetodoPagoDetails;
    @Column(name = "cantidad")
    private Double cantidad;
    @ManyToOne
    @JoinColumn(name = "id_metodo_pago", referencedColumnName = "idMetodoPago")
    private MetodoPago metodoPago;
    @ManyToOne
    @JoinColumn(name = "id_venta", referencedColumnName = "idVenta")
    private Venta venta;

}

package com.bcss.shopall.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Resenia")
public class Resenia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResenia;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha")
    private Date fecha;
    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "idProducto")
    private Producto producto;

}

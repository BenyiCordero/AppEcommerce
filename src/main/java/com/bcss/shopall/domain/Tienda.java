package com.bcss.shopall.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Vienda")
public class Tienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTienda;
    @Column(name = "nombre")
    private String nombre;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_inventario", referencedColumnName = "idInventario")
    private Inventario inventario;

}

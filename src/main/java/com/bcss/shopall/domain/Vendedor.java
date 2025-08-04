package com.bcss.shopall.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Vendedor")
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVendedor;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona", referencedColumnName = "idPersona")
    private Persona persona;

}

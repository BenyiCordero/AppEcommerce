package com.bcss.shopall.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Comprador")
public class Comprador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComprador;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona" , referencedColumnName = "idPersona")
    private Persona persona;

}

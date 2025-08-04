package com.bcss.shopall.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "primerApellido")
    private String primerApellido;
    @Column(name = "segundoApellido")
    private String segundoApellido;
    @Column(name = "direccion")
    private String direccion;

}

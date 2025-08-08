package com.bcss.shopall.domain;

import com.bcss.shopall.auth.Rol;
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
    @Enumerated(EnumType.STRING)
    @Column(name = "rol")
    private Rol rol;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "primerApellido")
    private String primerApellido;
    @Column(name = "segundoApellido")
    private String segundoApellido;
    @Column(name = "direccion")
    private String direccion;

}

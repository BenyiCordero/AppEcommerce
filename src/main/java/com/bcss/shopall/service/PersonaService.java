package com.bcss.shopall.service;

import com.bcss.shopall.dto.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaService {

    void crearPersona(Persona persona);
    void actualizarPersona(Persona persona);
    List<Persona> listaPersonas();
    Optional<Persona> buscarPersonaById(Long id);

}

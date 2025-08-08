package com.bcss.shopall.controller;

import com.bcss.shopall.domain.Producto;
import com.bcss.shopall.domain.Resenia;
import com.bcss.shopall.dto.ReseniaDTO;
import com.bcss.shopall.exceptions.DatosNoValidosException;
import com.bcss.shopall.service.ProductoService;
import com.bcss.shopall.service.ReseniaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resenias")
public class ReseniaController {

    private final ReseniaService reseniaService;
    private final ProductoService productoService;

    public ReseniaController(ReseniaService reseniaService, ProductoService productoService) {
        this.reseniaService = reseniaService;
        this.productoService = productoService;
    }

    @PostMapping
    public ResponseEntity<?> crearResenia (@Valid @RequestBody ReseniaDTO reseniaDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new DatosNoValidosException("Error de validacion" , bindingResult);
        }
        Producto producto = productoService.buscarProductoPorId(reseniaDTO.idProducto()).get();
        Resenia resenia = new Resenia();

        resenia.setDescripcion(reseniaDTO.descripcion());
        resenia.setFecha(reseniaDTO.fecha());
        resenia.setProducto(producto);

        return ResponseEntity.status(HttpStatus.CREATED).body(reseniaService.crearResenia(resenia));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listaReseniasPorProducto(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(reseniaService.listaReseniasPorProducto(id));
    }

}

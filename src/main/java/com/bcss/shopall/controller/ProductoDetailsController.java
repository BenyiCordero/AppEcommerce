package com.bcss.shopall.controller;

import com.bcss.shopall.domain.ProductoDetails;
import com.bcss.shopall.domain.Producto;
import com.bcss.shopall.dto.ProductoDTO;
import com.bcss.shopall.service.CategoriaService;
import com.bcss.shopall.service.ProductoDetailsService;
import com.bcss.shopall.service.InventarioService;
import com.bcss.shopall.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class ProductoDetailsController {

    private final ProductoDetailsService productoDetailsService;
    private final ProductoService productoService;
    private final CategoriaService categoriaService;
    private final InventarioService inventarioService;

    public ProductoDetailsController(ProductoDetailsService productoDetailsService, ProductoService productoService, CategoriaService categoriaService, InventarioService inventarioService) {
        this.productoDetailsService = productoDetailsService;
        this.productoService = productoService;
        this.categoriaService = categoriaService;
        this.inventarioService = inventarioService;
    }

    @PostMapping
    public ResponseEntity<?> crearProducto(@RequestBody ProductoDTO productoDTO) {
        Producto producto = new Producto();
        ProductoDetails productoDetails = new ProductoDetails();

        producto.setDescripcion(productoDTO.descripcion());
        producto.setCodigo(productoDTO.codigo());
        producto.setCategoria(categoriaService.buscarCategoria(productoDTO.idCategoria()).get());
        productoService.crearProducto(producto);

        productoDetails.setProducto(producto);
        productoDetails.setInventario(inventarioService.buscarInventario(productoDTO.idInventario()).get());

        return ResponseEntity.status(HttpStatus.CREATED).body(productoDetailsService.crearInventarioDetails(productoDetails));
    }

    @GetMapping
    public ResponseEntity<?> listaProductos(){
        return ResponseEntity.status(HttpStatus.OK).body(productoService.listaProductos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> ListarProductosPorInventario(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(productoDetailsService.findByInventarioId(id));
    }

}

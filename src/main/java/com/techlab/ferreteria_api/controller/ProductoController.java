package com.techlab.ferreteria_api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.techlab.ferreteria_api.model.Producto;
import com.techlab.ferreteria_api.service.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> listarProductos() { return productoService.findAll(); }

    @GetMapping("/{id}")
    public Producto obtenerProducto(@PathVariable Long id) { return productoService.findById(id); }

    @PostMapping
    public Producto agregarProducto(@RequestBody Producto producto) { return productoService.save(producto); }

    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto producto) { return productoService.update(id, producto); }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) { productoService.deleteById(id); }
}

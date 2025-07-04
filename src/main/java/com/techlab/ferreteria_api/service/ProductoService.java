package com.techlab.ferreteria_api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.techlab.ferreteria_api.model.Producto;
import com.techlab.ferreteria_api.repository.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> findAll() { return productoRepository.findAll(); }
    public Producto findById(Long id) { return productoRepository.findById(id).orElse(null); }
    public Producto save(Producto producto) { return productoRepository.save(producto); }
    public void deleteById(Long id) { productoRepository.deleteById(id); }
    
    public Producto update(Long id, Producto productoActualizado) {
        Producto productoExistente = findById(id);
        if (productoExistente != null) {
            productoExistente.setNombre(productoActualizado.getNombre());
            productoExistente.setDescripcion(productoActualizado.getDescripcion());
            productoExistente.setPrecio(productoActualizado.getPrecio());
            productoExistente.setStock(productoActualizado.getStock());
            productoExistente.setCategoria(productoActualizado.getCategoria());
            productoExistente.setImagenUrl(productoActualizado.getImagenUrl());
            return productoRepository.save(productoExistente);
        }
        return null;
    }
}

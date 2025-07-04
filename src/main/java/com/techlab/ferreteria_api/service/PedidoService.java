package com.techlab.ferreteria_api.service;
import com.techlab.ferreteria_api.exception.StockInsuficienteException;
import com.techlab.ferreteria_api.model.DetallePedido;
import com.techlab.ferreteria_api.model.Pedido;
import com.techlab.ferreteria_api.model.Producto;
import com.techlab.ferreteria_api.repository.PedidoRepository;
import com.techlab.ferreteria_api.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Transactional // Asegura que toda la operación sea atómica
    public Pedido crearPedido(Pedido pedido) {
        double totalCalculado = 0.0;

        for (DetallePedido item : pedido.getItems()) {
            Producto producto = productoRepository.findById(item.getProducto().getId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + item.getProducto().getId()));

            // 1. Validar stock disponible
            if (producto.getStock() < item.getCantidad()) {
                throw new StockInsuficienteException("Stock insuficiente para: " + producto.getNombre());
            }

            // 2. Disminuir el stock del producto
            producto.setStock(producto.getStock() - item.getCantidad());
            productoRepository.save(producto);

            // 3. Calcular el costo total
            totalCalculado += producto.getPrecio() * item.getCantidad();
            item.setPedido(pedido); // Enlazar cada detalle con el pedido principal
        }

        pedido.setTotal(totalCalculado);
        pedido.setFecha(LocalDateTime.now());
        pedido.setEstado("PENDIENTE");

        return pedidoRepository.save(pedido);
    }
}

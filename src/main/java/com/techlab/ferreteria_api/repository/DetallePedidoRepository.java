package com.techlab.ferreteria_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.techlab.ferreteria_api.model.DetallePedido;
    
public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long> {
}

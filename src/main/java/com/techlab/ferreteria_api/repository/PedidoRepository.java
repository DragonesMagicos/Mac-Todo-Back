package com.techlab.ferreteria_api.repository;


    
import org.springframework.data.jpa.repository.JpaRepository;
import com.techlab.ferreteria_api.model.Pedido;
    
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}

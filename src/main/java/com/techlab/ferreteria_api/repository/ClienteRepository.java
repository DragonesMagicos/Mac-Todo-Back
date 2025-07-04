package com.techlab.ferreteria_api.repository;

import com.techlab.ferreteria_api.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Método para buscar un cliente por su email
    Optional<Cliente> findByEmail(String email);
}

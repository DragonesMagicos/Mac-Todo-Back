package com.techlab.ferreteria_api.service;

import com.techlab.ferreteria_api.model.Cliente;
import com.techlab.ferreteria_api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente loginOrRegister(Cliente clienteData) {
        // Busca si el cliente ya existe por email.
        return clienteRepository.findByEmail(clienteData.getEmail())
                .orElseGet(() -> {
                    // Si no existe, crea uno nuevo con todos los datos.
                    Cliente nuevoCliente = new Cliente();
                    nuevoCliente.setNombre(clienteData.getNombre());
                    nuevoCliente.setApellido(clienteData.getApellido());
                    nuevoCliente.setDni(clienteData.getDni());
                    nuevoCliente.setEmail(clienteData.getEmail());
                    return clienteRepository.save(nuevoCliente);
                });
    }
    public Cliente findByEmail(String email) {
        return clienteRepository.findByEmail(email).orElse(null);
    }

}

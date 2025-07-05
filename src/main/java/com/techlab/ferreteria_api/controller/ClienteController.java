package com.techlab.ferreteria_api.controller;

import com.techlab.ferreteria_api.model.Cliente;
import com.techlab.ferreteria_api.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/login")
    public Cliente loginOrRegister(@RequestBody Cliente cliente) {
        return clienteService.loginOrRegister(cliente);
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<Cliente> getClienteByEmail(@PathVariable String email) {
        Cliente cliente = clienteService.findByEmail(email);
        if (cliente != null) {
            // Si se encuentra, devuelve el cliente con un estado 200 OK.
            return ResponseEntity.ok(cliente);
        } else {
            // Si no se encuentra, devuelve un estado 404 Not Found.
            return ResponseEntity.notFound().build();
        }
    }

}


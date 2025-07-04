package com.techlab.ferreteria_api.controller;

import com.techlab.ferreteria_api.model.Cliente;
import com.techlab.ferreteria_api.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
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
}


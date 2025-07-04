package com.techlab.ferreteria_api.controller;

import com.techlab.ferreteria_api.model.Pedido;
import com.techlab.ferreteria_api.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public Pedido realizarPedido(@RequestBody Pedido pedido) {
        return pedidoService.crearPedido(pedido);
    }
}

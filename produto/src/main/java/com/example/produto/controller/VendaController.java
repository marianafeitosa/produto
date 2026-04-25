package com.example.produto.controller;

import com.example.produto.entity.Venda;
import com.example.produto.service.VendaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    private final VendaService service;

    public VendaController(VendaService service) {
        this.service = service;
    }

    @PostMapping
    public Venda criar(@RequestBody Venda venda) {
        return service.criar(venda);
    }

    @GetMapping
    public List<Venda> listar() {
        return service.listar();
    }

    @GetMapping("/cliente/{clienteId}")
    public List<Venda> buscarPorCliente(@PathVariable("clienteId") String clienteId) {
        return service.buscarPorCliente(clienteId);
    }
}
package com.example.produto.service;

import com.example.produto.entity.ItemVenda;
import com.example.produto.entity.Venda;
import com.example.produto.repository.VendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {

    private final VendaRepository repository;

    public VendaService(VendaRepository repository) {
        this.repository = repository;
    }

    public Venda criar(Venda venda) {
        double total = 0.0;

        for (ItemVenda item : venda.getProdutos()) {
            item.setSubtotal(item.getPreco() * item.getQuantidade());
            total += item.getSubtotal();
        }

        venda.setTotal(total);
        return repository.save(venda);
    }

    public List<Venda> listar() {
        return repository.findAll();
    }

    public List<Venda> buscarPorCliente(String clienteId) {
        return repository.findByClienteId(clienteId);
    }
}
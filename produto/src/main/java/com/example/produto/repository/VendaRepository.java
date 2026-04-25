package com.example.produto.repository;

import com.example.produto.entity.Venda;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface VendaRepository extends MongoRepository<Venda, String> {
    List<Venda> findByClienteId(String clienteId);
}
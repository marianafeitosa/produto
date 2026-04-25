package com.example.produto.service;

import com.example.produto.dto.ProdutoRequest;
import com.example.produto.entity.Produto;
import com.example.produto.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Produto criar(ProdutoRequest request) {
        Produto produto = new Produto();
        produto.setNome(request.getNome());
        produto.setPreco(request.getPreco());
        return repository.save(produto);
    }

    public List<Produto> listar() {
        return repository.findAll();
    }

    public Produto buscar(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public Produto atualizar(String id, ProdutoRequest request) {
        Produto produto = new Produto();
        produto.setId(id);
        produto.setNome(request.getNome());
        produto.setPreco(request.getPreco());
        return repository.save(produto);
    }

    public void deletar(String id) {
        repository.deleteById(id);
    }
}
package com.example.produto.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "vendas")
public class Venda {

    @Id
    private String id;
    private String clienteId;
    private List<ItemVenda> produtos;
    private Double total;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getClienteId() { return clienteId; }
    public void setClienteId(String clienteId) { this.clienteId = clienteId; }

    public List<ItemVenda> getProdutos() { return produtos; }
    public void setProdutos(List<ItemVenda> produtos) { this.produtos = produtos; }

    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }
}
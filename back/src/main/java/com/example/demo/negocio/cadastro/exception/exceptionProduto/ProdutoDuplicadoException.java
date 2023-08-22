package com.example.demo.negocio.cadastro.exception.exceptionProduto;

public class ProdutoDuplicadoException extends Exception {
    private static final long serialVersionUID = 1L;
    private String nomeProduto;

    public ProdutoDuplicadoException(String nomeProduto) {
        super("Produto duplicado com nome: " + nomeProduto);
        this.nomeProduto = nomeProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }
}

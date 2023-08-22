package com.example.demo.negocio.cadastro.exception.exceptionProduto;

public class ProdutoInvalidoException extends Exception {
    private static final long serialVersionUID = 1L;
    private String nomeProduto;

    public ProdutoInvalidoException(String nomeProduto) {
        super("Produto inválido: " + nomeProduto);
        this.nomeProduto = nomeProduto;
    }

    public String getNomeProduto() {
        return this.nomeProduto;
    }
}

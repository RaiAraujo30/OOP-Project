package com.example.demo.negocio.cadastro.exception.exceptionProduto;

public class ProdutoIdInvalidoException extends Exception {
    private static final long serialVersionUID = 1L;
    private Long id;

    public ProdutoIdInvalidoException(Long id) {
        super("Produto inválido: " + id);
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
}

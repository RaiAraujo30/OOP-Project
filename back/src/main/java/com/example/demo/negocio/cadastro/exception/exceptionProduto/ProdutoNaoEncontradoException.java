package com.example.demo.negocio.cadastro.exception.exceptionProduto;

public class ProdutoNaoEncontradoException extends Exception {
    private static final long serialVersionUID = 1L;
    private Long idProduto;

    public ProdutoNaoEncontradoException(Long idProduto) {
        super("Produto não encontrado com ID: " + idProduto);
        this.idProduto = idProduto;
    }

    public Long getIdProduto() {
        return idProduto;
    }
}

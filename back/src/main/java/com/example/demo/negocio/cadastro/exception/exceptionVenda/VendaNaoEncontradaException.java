package com.example.demo.negocio.cadastro.exception.exceptionVenda;

public class VendaNaoEncontradaException extends Exception {
    private static final long serialVersionUID = 1L;
    private long id;

    public VendaNaoEncontradaException(long id) {
        super("Venda não encontrada com o ID: " + id);
        this.id = id;
    }

    public long getId() {
        return id;
    }
}

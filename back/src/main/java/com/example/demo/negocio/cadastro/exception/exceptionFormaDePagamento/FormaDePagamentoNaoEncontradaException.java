package com.example.demo.negocio.cadastro.exception.exceptionFormaDePagamento;

public class FormaDePagamentoNaoEncontradaException extends Exception {
    private static final long serialVersionUID = 1L;
    private Long id;

    public FormaDePagamentoNaoEncontradaException(Long id) {
        super("Forma de pagamento não encontrada com o ID: " + id);
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
}

package com.example.demo.negocio.cadastro.exception.exceptionFormaDePagamento;

public class FormaDePagamentoInvalidaException extends Exception {
    private static final long serialVersionUID = 1L;
    private String nome;

    public FormaDePagamentoInvalidaException(String nome) {
        super("Forma de pagamento invalida");
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

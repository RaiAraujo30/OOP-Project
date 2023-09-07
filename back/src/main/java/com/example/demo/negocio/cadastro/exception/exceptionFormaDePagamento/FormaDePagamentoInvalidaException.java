package com.example.demo.negocio.cadastro.exception.exceptionFormaDePagamento;

public class FormaDePagamentoInvalidaException extends Exception {
    private static final long serialVersionUID = 1L;
    private String nomeFormaDePagamento;

    public FormaDePagamentoInvalidaException(String nomeFormaDePagamento) {
        super("Forma de pagamento invalida");
        this.nomeFormaDePagamento = nomeFormaDePagamento;
    }

    public String getNomeFormaDePagamento() {
        return this.nomeFormaDePagamento;
    }
}

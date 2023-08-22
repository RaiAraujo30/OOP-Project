package com.example.demo.negocio.cadastro.exception.exceptionFormaDePagamento;

public class FormaDePagamentoDuplicadaException extends Exception {
    private static final long serialVersionUID = 1L;
    private String nomeFormaDePagamento;

    public FormaDePagamentoDuplicadaException(String nomeFormaDePagamento) {
        super("Não é possível cadastrar duas formas de pagamento com o mesmo nome");
        this.nomeFormaDePagamento = nomeFormaDePagamento;
    }

    public String getNomeFormaDePagamento() {
        return this.nomeFormaDePagamento;
    }
}

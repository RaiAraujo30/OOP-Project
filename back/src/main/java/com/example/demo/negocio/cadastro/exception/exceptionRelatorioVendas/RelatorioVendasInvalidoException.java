package com.example.demo.negocio.cadastro.exception.exceptionRelatorioVendas;

public class RelatorioVendasInvalidoException extends Exception {
    private static final long serialVersionUID = 1L;

    public RelatorioVendasInvalidoException() {
        super("Relatório de vendas inválido");
    }
}

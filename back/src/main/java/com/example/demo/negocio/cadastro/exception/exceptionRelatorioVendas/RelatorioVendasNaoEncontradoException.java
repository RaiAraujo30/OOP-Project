package com.example.demo.negocio.cadastro.exception.exceptionRelatorioVendas;

public class RelatorioVendasNaoEncontradoException extends Exception {
    private static final long serialVersionUID = 1L;
    private long id;

    public RelatorioVendasNaoEncontradoException(long id) {
        super("Relatório de vendas não encontrado para o ID: " + id);
        this.id = id;
    }

    public long getId() {
        return id;
    }
}

package com.example.demo.negocio.cadastro.exception.exceptionMarcas;

public class MarcaNaoEncontradaException extends RuntimeException {
    private Long idMarca;

    public MarcaNaoEncontradaException(Long idMarca) {
        super("Marca não encontrada com ID: " + idMarca);
        this.idMarca = idMarca;
    }

    public Long getIdMarca() {
        return idMarca;
    }
}

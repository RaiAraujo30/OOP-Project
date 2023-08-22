package com.example.demo.negocio.cadastro.exception.exceptionMarcas;

public class MarcaInvalidaException extends RuntimeException {
    private String nomeMarca;

    public MarcaInvalidaException(String nomeMarca) {
        super("Marca inválida ou não encontrada: " + nomeMarca);
        this.nomeMarca = nomeMarca;
    }

    public String getNomeMarca() {
        return nomeMarca;
    }
}

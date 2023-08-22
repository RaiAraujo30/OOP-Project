package com.example.demo.negocio.cadastro.exception.exceptionMarcas;

public class MarcaDuplicadaException extends RuntimeException {
    private String nomeMarca;

    public MarcaDuplicadaException(String nomeMarca) {
        super("Não é possível cadastrar duas marcas com o mesmo nome: " + nomeMarca);
        this.nomeMarca = nomeMarca;
    }

    public String getNomeMarca() {
        return nomeMarca;
    }
}

package com.example.demo.negocio.cadastro.exception.exceptionCliente;

public class ClienteInvalidoException extends Exception {
    private static final long serialVersionUID = 1L;
    private String nome;

    public ClienteInvalidoException(String nome) {
        super("Cliente nao cadastrado");
        this.nome = nome;

    }

    public String getNome() {
        return nome;
    }
}

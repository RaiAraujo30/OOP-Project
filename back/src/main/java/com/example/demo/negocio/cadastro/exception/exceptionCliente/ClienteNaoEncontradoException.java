package com.example.demo.negocio.cadastro.exception.exceptionCliente;

public class ClienteNaoEncontradoException extends Exception {
    private static final long serialVersionUID = 1L;
    private Long clienteId;

    public ClienteNaoEncontradoException(Long clienteId) {
        super("Cliente não encontrado com o ID: " + clienteId);
        this.clienteId = clienteId;
    }

    public Long getClienteId() {
        return clienteId;
    }
}

package com.example.demo.negocio.cadastro.exception.exceptionCliente;

public class ClienteDuplicadoExcerption extends Exception {
    private static final long serialVersionUID = 1L;
    private String cpf;

    public ClienteDuplicadoExcerption (String cpf){
        super("Cliente ja cadastrado");
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
    
    
}

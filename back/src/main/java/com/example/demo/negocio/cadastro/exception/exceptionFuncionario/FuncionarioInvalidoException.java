package com.example.demo.negocio.cadastro.exception.exceptionFuncionario;

public class FuncionarioInvalidoException extends Exception {
    private static final long serialVersionUID = 1L;
    private String cpf;

    public FuncionarioInvalidoException(String cpf) {
        super("Funcionario não cadastrado");
        this.cpf = cpf;

    }

    public String getCpf() {
        return cpf;
    }

    
}

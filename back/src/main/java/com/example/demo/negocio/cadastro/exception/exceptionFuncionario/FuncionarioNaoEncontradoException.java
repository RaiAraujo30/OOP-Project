package com.example.demo.negocio.cadastro.exception.exceptionFuncionario;

public class FuncionarioNaoEncontradoException extends Exception {
    private static final long serialVersionUID = 1L;
    private Long FuncionarioId;

    public FuncionarioNaoEncontradoException(Long FuncionarioId) {
        super("Funcionario não encontrado com o ID: " + FuncionarioId);
        this.FuncionarioId = FuncionarioId;
    }

    public Long getFuncionarioId() {
        return FuncionarioId;
    }

    
}

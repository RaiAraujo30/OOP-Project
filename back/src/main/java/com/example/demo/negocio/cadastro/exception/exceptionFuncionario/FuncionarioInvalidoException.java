package com.example.demo.negocio.cadastro.exception.exceptionFuncionario;

public class FuncionarioInvalidoException extends Exception {
    private static final long serialVersionUID = 1L;
	private String nome;

    public FuncionarioInvalidoException(String nome){
    super ("Funcionario não cadastrado");
    this.nome = nome;

    
    }

    public String getNome() {
        return nome;
    }
}

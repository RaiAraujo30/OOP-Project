package com.example.demo.negocio.cadastro.exception;

public class FuncionarioDuplicadoException extends Exception {
    private static final long serialVersionUID = 1L;
	private String cpf;

    public FuncionarioDuplicadoException(String cpf) {
		super("Não é possível cadastrar dois usuários com o mesmo cpf");
		this.cpf = cpf;
	}
	
	public String getCpf() {
		return this.cpf;
	}
}
    


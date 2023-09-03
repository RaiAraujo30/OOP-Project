package com.example.demo.negocio.cadastro.exception.ExceptionItem;

public class ItemvazioException extends Exception {
    private static final long serialVersionUID = 1L;
    private String mensagem;

    public ItemvazioException(String mensagem) {
        super("Funcionario não cadastrado");
        this.mensagem = mensagem;

    }

    public String getMensagem() {
        return mensagem;
    }

}

package com.example.demo.negocio.cadastro.exception.exceptionVenda;

public class VendaInvalidaException extends Exception{
    private static final long serialVersionUID = 1L;
    private Long id;

    public VendaInvalidaException(Long id){
        super("Venda nao encontrada com o ID: " + id);
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    

}

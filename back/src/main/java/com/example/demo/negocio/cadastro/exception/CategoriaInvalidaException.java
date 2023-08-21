package com.example.demo.negocio.cadastro.exception;

public class CategoriaInvalidaException extends Exception {
    private static final long serialVersionUID = 1L;
	private String nomecategoria;

    public CategoriaInvalidaException(String nomecategoria) {
        super("Categoria não existente");
        this.nomecategoria = nomecategoria;
    }

    public String getNomecategoria() {
        return nomecategoria;
    }
    
}

package com.example.demo.negocio.cadastro.exception.exceptionCategoria;

public class CategoriaDuplicadaException extends Exception{
    private static final long serialVersionUID = 1L;
	private String nomecategoria;

    public CategoriaDuplicadaException (String nomecategoria){
        super("Não é possível cadastrar duas categorias com o mesmo nome");
        this.nomecategoria = nomecategoria;
    }
    public String getNomecategoria(){
        return this.nomecategoria;
    }
}

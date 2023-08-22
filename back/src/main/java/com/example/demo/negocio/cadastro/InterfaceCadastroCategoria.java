package com.example.demo.negocio.cadastro;

import java.util.List;

import com.example.demo.negocio.basica.Categoria;
import com.example.demo.negocio.cadastro.exception.exceptionCategoria.CategoriaDuplicadaException;
import com.example.demo.negocio.cadastro.exception.exceptionCategoria.CategoriaInvalidaException;


public interface InterfaceCadastroCategoria {

    Categoria procurarCategoriaNomecategoria(String nomecategoria) 
            throws CategoriaInvalidaException;

    Categoria salvarCategoria(Categoria categoria)   
            throws CategoriaDuplicadaException;

    List<Categoria> listarCategorias();

    boolean verificarExistenciaCategoriaId(Long id);

    Categoria localizarCategoriaId(Long id);
    
    void removerCategoriaNomecategoria(String nomecategoria) 
			throws CategoriaInvalidaException;

}

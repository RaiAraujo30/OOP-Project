package com.example.demo.negocio.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dados.InterfaceColecaoCategoria;
import com.example.demo.negocio.basica.Categoria;
import com.example.demo.negocio.cadastro.exception.exceptionCategoria.CategoriaDuplicadaException;
import com.example.demo.negocio.cadastro.exception.exceptionCategoria.CategoriaInvalidaException;

@Service
public class CadastroCategoria implements InterfaceCadastroCategoria {
    @Autowired
    private InterfaceColecaoCategoria colecaoCategoria;

    public Categoria procurarCategoriaNomecategoria(String nomecategoria) 
            throws CategoriaInvalidaException {
        Categoria u = colecaoCategoria.findByNomecategoria(nomecategoria);
        if(u == null){
            throw new CategoriaInvalidaException(nomecategoria);
        }
        return u;
    }

    public Categoria salvarCategoria(Categoria categoria)   
            throws CategoriaDuplicadaException{
        try {
            procurarCategoriaNomecategoria(categoria.getNomecategoria());
            throw new CategoriaDuplicadaException(categoria.getNomecategoria());
        } 
        catch(CategoriaInvalidaException err) {
            return colecaoCategoria.save(categoria);
        }
    }

    public List<Categoria> listarCategorias(){
        return colecaoCategoria.findAll();
    }

    public boolean verificarExistenciaCategoriaId(Long id) {
		return colecaoCategoria.existsById(id);
	}

	public Categoria localizarCategoriaId(Long id) {
		return colecaoCategoria.findById(id).orElse(null);
	}
	
	public void removerCategoriaNomecategoria(String nomecategoria) 
			throws CategoriaInvalidaException {
		Categoria u = procurarCategoriaNomecategoria(nomecategoria);
		colecaoCategoria.delete(u);
	}

    
    }



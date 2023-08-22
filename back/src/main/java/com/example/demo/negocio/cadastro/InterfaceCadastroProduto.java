package com.example.demo.negocio.cadastro;

import java.util.List;

import com.example.demo.negocio.basica.Produto;
import com.example.demo.negocio.cadastro.exception.exceptionProduto.ProdutoDuplicadoException;
import com.example.demo.negocio.cadastro.exception.exceptionProduto.ProdutoInvalidoException;
import com.example.demo.negocio.cadastro.exception.exceptionProduto.ProdutoNaoEncontradoException;


public interface InterfaceCadastroProduto {

    List<Produto> procurarProdutoPorNome(String nome) throws ProdutoInvalidoException;

    Produto salvarProduto(Produto produto) throws ProdutoDuplicadoException ;

    List<Produto> listarProdutos();

    boolean verificarExistenciaProdutoPorId(Long id);

    Produto localizarProdutoPorId(Long id);

    void removerProdutoPorId(Long id) throws ProdutoNaoEncontradoException;

}

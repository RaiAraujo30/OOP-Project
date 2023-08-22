package com.example.demo.negocio.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dados.InterfaceColecaoProduto;
import com.example.demo.negocio.basica.Produto;
import com.example.demo.negocio.cadastro.exception.exceptionProduto.ProdutoDuplicadoException;
import com.example.demo.negocio.cadastro.exception.exceptionProduto.ProdutoInvalidoException;
import com.example.demo.negocio.cadastro.exception.exceptionProduto.ProdutoNaoEncontradoException;

@Service
public class CadastroProduto implements InterfaceCadastroProduto {
    @Autowired
    private InterfaceColecaoProduto colecaoProduto;

    public List<Produto> procurarProdutoPorNome(String nome) throws ProdutoInvalidoException {
        List<Produto> produtos = colecaoProduto.findByNomeContainingIgnoreCase(nome);
        if (produtos.isEmpty()) {
            throw new ProdutoInvalidoException(nome);
        }
        return produtos;
    }

    public Produto salvarProduto(Produto produto) throws ProdutoDuplicadoException {
        try {
            procurarProdutoPorNome(produto.getNome());
            throw new ProdutoDuplicadoException(produto.getNome());
        } catch (ProdutoInvalidoException err) {
            return colecaoProduto.save(produto);
        }
    }

    public List<Produto> listarProdutos() {
        return colecaoProduto.findAll();
    }

    public boolean verificarExistenciaProdutoPorId(Long id) {
        return colecaoProduto.existsById(id);
    }

    public Produto localizarProdutoPorId(Long id) {
        return colecaoProduto.findById(id).orElse(null);
    }

    public void removerProdutoPorId(Long id) throws ProdutoNaoEncontradoException {
        if (!verificarExistenciaProdutoPorId(id)) {
            throw new ProdutoNaoEncontradoException(id);
        }
        colecaoProduto.deleteById(id);
    }
}

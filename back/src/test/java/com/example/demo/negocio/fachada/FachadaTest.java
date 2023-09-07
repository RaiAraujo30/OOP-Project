package com.example.demo.negocio.fachada;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.negocio.basica.Categoria;
import com.example.demo.negocio.basica.Marcas;
import com.example.demo.negocio.basica.Produto;

import com.example.demo.negocio.cadastro.exception.exceptionCategoria.CategoriaDuplicadaException;
import com.example.demo.negocio.cadastro.exception.exceptionCategoria.CategoriaInvalidaException;
import com.example.demo.negocio.cadastro.exception.exceptionProduto.ProdutoDuplicadoException;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
class FachadaTest {

    @Autowired
    private Fachada fachada;

    @BeforeEach

    @Test
    void testCadastrarProduto()
            throws ProdutoDuplicadoException, CategoriaInvalidaException, CategoriaDuplicadaException {
        String nomeProduto = "Produto Teste";
        String nomeCategoria = "Categoria Teste";
        String nomeMarca = "Marca Teste";
        double preco = 100.0;

        // Criar uma categoria e uma marca (se não existirem)
        Categoria categoria = new Categoria(nomeCategoria);
        fachada.salvarCategoria(categoria);
        Marcas marca = new Marcas(nomeMarca);
        fachada.salvarMarca(marca);

        // Criar o produto
        Produto produto = new Produto(nomeProduto, preco, marca, categoria);

        // Chamar o método de cadastro de produto na fachada
        Produto produtoCadastrado = fachada.salvarProduto(produto);

        // Verificar se o produto foi cadastrado corretamente
        assertNotNull(produtoCadastrado.getId()); // Verifica se o produto tem um ID atribuído
        assertEquals(nomeProduto, produtoCadastrado.getNome());
        assertEquals(preco, produtoCadastrado.getPreco());
        assertEquals(marca, produtoCadastrado.getMarca());
        assertEquals(categoria, produtoCadastrado.getCategoria());
    }
}
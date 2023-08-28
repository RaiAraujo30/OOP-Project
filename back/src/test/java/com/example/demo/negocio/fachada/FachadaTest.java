
package com.example.demo.negocio.fachada;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.negocio.basica.Categoria;
import com.example.demo.negocio.basica.Marcas;
import com.example.demo.negocio.basica.Produto;
import com.example.demo.negocio.cadastro.CadastroProduto;
import com.example.demo.negocio.cadastro.InterfaceCadastroCategoria;
import com.example.demo.negocio.cadastro.InterfaceCadastroMarcas;
import com.example.demo.negocio.cadastro.InterfaceCadastroProduto;
import com.example.demo.negocio.cadastro.exception.exceptionCategoria.CategoriaDuplicadaException;
import com.example.demo.negocio.cadastro.exception.exceptionCategoria.CategoriaInvalidaException;
import com.example.demo.negocio.cadastro.exception.exceptionMarcas.MarcaInvalidaException;
import com.example.demo.negocio.cadastro.exception.exceptionProduto.ProdutoDuplicadoException;

import jakarta.transaction.Transactional;


@SpringBootTest
@Transactional

class FachadTest {

    private Fachada fachada;
    
    private InterfaceCadastroCategoria cadastroCategoria;
    private InterfaceCadastroMarcas cadastroMarcas;
    private InterfaceCadastroProduto cadastroProduto;
    private InterfaceCadastroProduto cadastroProduto2;

    @BeforeEach
    void setUp() {
        cadastroCategoria = mock(InterfaceCadastroCategoria.class);
        cadastroMarcas = mock(InterfaceCadastroMarcas.class);
        cadastroProduto = mock(InterfaceCadastroProduto.class);
        cadastroProduto2 = new CadastroProduto(cadastroCategoria, cadastroMarcas, cadastroProduto);
    }

    @Test
    void testCadastrarProduto() throws ProdutoDuplicadoException, CategoriaInvalidaException, CategoriaDuplicadaException {
        String nomeProduto = "Produto Teste";
        String nomeCategoria = "Categoria Teste";
        String nomeMarca = "Marca Teste";
        double preco = 100.0;

        Categoria categoria = new Categoria(nomeCategoria);
        when(cadastroCategoria.procurarCategoriaNomecategoria(nomeCategoria)).thenReturn(null);
        when(cadastroCategoria.salvarCategoria(categoria)).thenReturn(categoria);

        Marcas marca = new Marcas(nomeMarca);
        when(cadastroMarcas.procurarMarcaNomemarca(nomeMarca)).thenReturn(null);
        when(cadastroMarcas.salvarMarca(marca)).thenReturn(marca);

        Produto produto = new Produto(nomeProduto, preco, marca, categoria);
        when(cadastroProduto.salvarProduto(produto)).thenReturn(produto);

        Produto result = cadastraProdutoFacade2.CadastrarProduto(nomeProduto, nomeCategoria, nomeMarca, preco);

        assertNotNull(result);
        assertEquals(nomeProduto, result.getNome());
        assertEquals(preco, result.getPreco());
        assertEquals(marca, result.getMarca());
        assertEquals(categoria, result.getCategoria());

        verify(cadastroCategoria, times(1)).procurarCategoriaNomecategoria(nomeCategoria);
        verify(cadastroCategoria, times(1)).salvarCategoria(categoria);
        verify(cadastroMarcas, times(1)).procurarMarcaNomemarca(nomeMarca);
        verify(cadastroMarcas, times(1)).salvarMarca(marca);
        verify(cadastroProduto, times(1)).salvarProduto(produto);
    }
}

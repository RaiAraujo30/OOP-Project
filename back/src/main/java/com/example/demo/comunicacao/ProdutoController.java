package com.example.demo.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.negocio.basica.Produto;
import com.example.demo.negocio.cadastro.exception.exceptionMarcas.MarcaInvalidaException;
import com.example.demo.negocio.cadastro.exception.exceptionMarcas.MarcaNaoEncontradaException;
import com.example.demo.negocio.cadastro.exception.exceptionProduto.ProdutoDuplicadoException;
import com.example.demo.negocio.cadastro.exception.exceptionProduto.ProdutoNaoEncontradoException;
import com.example.demo.negocio.fachada.Fachada;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    public Fachada fachada;

    @PostMapping("/cadastrarProduto")
    public ResponseEntity<?> cadastrarProduto(@RequestBody Produto produtoBody) {

        try {
            Produto produto = new Produto(produtoBody.getNome(), produtoBody.getPreco(), produtoBody.getMarca(),
                    produtoBody.getCategoria());
            produto = fachada.salvarProduto(produto);
            return new ResponseEntity<>(produto, HttpStatus.CREATED);
        } catch (ProdutoDuplicadoException | MarcaInvalidaException | MarcaNaoEncontradaException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listarProdutos")
    public ResponseEntity<List<Produto>> listarProdutos() {
        List<Produto> produtos = fachada.listarProdutos();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @DeleteMapping("Produto/{idProduto}")
    public ResponseEntity<String> deletarProduto(@PathVariable long idProduto) {
        try {
            fachada.removerProdutoPorId(idProduto);
            return new ResponseEntity<>("Produto removido com sucesso", HttpStatus.OK);
        } catch (ProdutoNaoEncontradoException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
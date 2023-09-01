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

import com.example.demo.negocio.basica.Categoria;

import com.example.demo.negocio.cadastro.exception.exceptionCategoria.CategoriaDuplicadaException;
import com.example.demo.negocio.cadastro.exception.exceptionCategoria.CategoriaInvalidaException;
import com.example.demo.negocio.fachada.Fachada;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    public Fachada fachada;

    @PostMapping("/salvarCategoria")
    public ResponseEntity<?> salvarCategoria(@RequestBody String nomeCategoria) {
        try {
            Categoria categoria = new Categoria(nomeCategoria);
            categoria = fachada.salvarCategoria(categoria);
            return new ResponseEntity<>(categoria, HttpStatus.CREATED);
        } catch (CategoriaDuplicadaException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listarCategorias")
    public ResponseEntity<List<Categoria>> listarCategoria() {
        List<Categoria> categorias = fachada.listarCategorias();
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }

    @DeleteMapping("/Categoria/{nomeCategoria}")
    public ResponseEntity<String> deletarCategoria(@PathVariable String nomeCategoria) {
        try {
            fachada.removerCategoriaNomecategoria(nomeCategoria);
            return new ResponseEntity<>("Categoria removida com sucesso", HttpStatus.OK);
        } catch (CategoriaInvalidaException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
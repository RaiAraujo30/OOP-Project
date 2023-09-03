package com.example.demo.comunicacao;

import java.util.List;
import java.util.Map;

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

import com.example.demo.negocio.basica.Marcas;

import com.example.demo.negocio.cadastro.exception.exceptionMarcas.MarcaDuplicadaException;
import com.example.demo.negocio.cadastro.exception.exceptionMarcas.MarcaInvalidaException;
import com.example.demo.negocio.fachada.Fachada;

@RestController
@RequestMapping("/api/marcas")
public class MarcaController {

    @Autowired
    public Fachada fachada;

    @PostMapping("/salvarMarca")
    public ResponseEntity<?> salvarMarca(@RequestBody Map<String, String> requestBody) {
        try {
            String nomeMarca = requestBody.get("marca"); // Acesse o nome da marca no JSON
            Marcas marca = new Marcas(nomeMarca);
            marca = fachada.salvarMarca(marca);
            return new ResponseEntity<>(marca, HttpStatus.CREATED);
        } catch (MarcaDuplicadaException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listarMarcas")
    public ResponseEntity<List<Marcas>> listarMarcas() {
        List<Marcas> marcas = fachada.listarMarcas();
        return new ResponseEntity<>(marcas, HttpStatus.OK);
    }

    @DeleteMapping("/removerMarca")
    public ResponseEntity<String> deletarMarca(@PathVariable Long IdMarca) {
        try {
            fachada.removerMarcaId(IdMarca);
            return new ResponseEntity<>("Marca removida com sucesso", HttpStatus.OK);
        } catch (MarcaInvalidaException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
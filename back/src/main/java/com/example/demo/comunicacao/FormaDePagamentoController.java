package com.example.demo.comunicacao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.negocio.basica.FormaDePagamento;
import com.example.demo.negocio.cadastro.exception.exceptionFormaDePagamento.FormaDePagamentoDuplicadaException;

import com.example.demo.negocio.fachada.Fachada;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/FormaDePagamento")
public class FormaDePagamentoController {

    @Autowired
    public Fachada fachada;

    @PostMapping("/salvarFormaDePagamento")
    public ResponseEntity<?> salvarFormaDePagamento(@RequestBody Map<String, String> requestBody) {
        try {
            String nomeFormaDePagamento = requestBody.get("formaDepagamento");
            FormaDePagamento formaDePagamento = new FormaDePagamento(nomeFormaDePagamento);
            formaDePagamento = fachada.salvarFormaDePagamento(formaDePagamento);
            return new ResponseEntity<>(formaDePagamento, HttpStatus.CREATED);
        } catch (FormaDePagamentoDuplicadaException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listarFormasDePagamento")
    public ResponseEntity<List<FormaDePagamento>> listarFormasDePagamento() {
        List<FormaDePagamento> formasdepagamento = fachada.listarFormasDePagamento();
        return new ResponseEntity<>(formasdepagamento, HttpStatus.OK);
    }

}

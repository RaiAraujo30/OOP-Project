package com.example.demo.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.negocio.basica.Venda;
import com.example.demo.negocio.fachada.Fachada;

@RestController
@RequestMapping("/api/relatorioVenda")
public class RelatorioVendasController {

    @Autowired
    public Fachada fachada;

    @GetMapping("/relatorioVenda")
    public List<Venda> relatorioVendas() {
        return fachada.listarVendas();
    }
}
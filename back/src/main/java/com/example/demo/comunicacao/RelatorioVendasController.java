package com.example.demo.comunicacao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.negocio.basica.RelatorioVendas;
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

    @GetMapping("/relatoriosPorPeriodo")
    public ResponseEntity<List<RelatorioVendas>> buscarRelatoriosVendasPorPeriodo(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataInicio,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataFim) {
        try {
            List<RelatorioVendas> relatorios = fachada.buscarRelatoriosVendasPorPeriodo(dataInicio, dataFim);
            return new ResponseEntity<>(relatorios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

package com.example.demo.negocio.cadastro;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dados.InterfaceColecaoRelatorioVendas;
import com.example.demo.negocio.basica.RelatorioVendas;


@Service
public class CadastroRelatorioVendas implements InterfaceCadastroRelatorioVendas {

    @Autowired
    private InterfaceColecaoRelatorioVendas colecaoRelatorioVendas;
    

    public RelatorioVendas salvarRelatorioVendas(RelatorioVendas relatorioVendas) {
        return colecaoRelatorioVendas.save(relatorioVendas);
    }

    public List<RelatorioVendas> listarRelatoriosVendas() {
        return colecaoRelatorioVendas.findAll();
    }
    

    public List<RelatorioVendas> buscarRelatoriosVendasPorData(Date data) {
        return colecaoRelatorioVendas.findByData(data);
    }

    public List<RelatorioVendas> buscarRelatoriosVendasPorPeriodo(Date dataInicio, Date dataFim){
        return colecaoRelatorioVendas.findByDataInicioBetween(dataInicio, dataFim);
    }

    public List<RelatorioVendas> buscarRelatoriosVendasPorTotalVendas(double totalVendas) {
        return colecaoRelatorioVendas.findByTotalVendas(totalVendas);
    }

    public List<RelatorioVendas> buscarRelatoriosVendasComTotalVendasMaiorOuIgual(double totalVendas) {
        return colecaoRelatorioVendas.findByTotalVendasGreaterThanEqual(totalVendas);
    }
}
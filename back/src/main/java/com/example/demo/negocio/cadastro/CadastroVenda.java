package com.example.demo.negocio.cadastro;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dados.InterfaceColecaoVenda;
import com.example.demo.negocio.basica.Venda;
import com.example.demo.negocio.cadastro.exception.exceptionVenda.VendaInvalidaException;
import com.example.demo.negocio.cadastro.exception.exceptionVenda.VendaNaoEncontradaException;

@Service
public class CadastroVenda implements InterfaceCadastroVenda {

    @Autowired
    private InterfaceColecaoVenda colecaoVenda;

    @Override
    public Venda buscarVendaId(long id) throws VendaInvalidaException {
        Venda venda = colecaoVenda.findById(id);
        if(venda == null){
            throw new VendaInvalidaException(id);
        }
        return venda;
    }

    @Override
    public List<Venda> buscarVendasPorData(Date data) {
        return colecaoVenda.findByData(data);
    }

    @Override
    public List<Venda> buscarVendasPorValorTotal(double valor) {
        return colecaoVenda.findByTotal(valor);
    }

    @Override
    public List<Venda> buscarVendasComValorTotalMaiorOuIgual(double valor) {
        return colecaoVenda.findByTotalGreaterThanEqual(valor);
    }

    @Override
    public Venda salvarVenda(Venda venda) {
        return colecaoVenda.save(venda);
    }

    @Override
    public List<Venda> listarVendas() {
        return colecaoVenda.findAll();
    }

    @Override
    public boolean verificarExistenciaVendaPorId(long id) {
        return colecaoVenda.existsById(id);
    }

   

    @Override
    public void removerVendaPorId(long id) throws VendaNaoEncontradaException {
        if (!verificarExistenciaVendaPorId(id)) {
            throw new VendaNaoEncontradaException(id);
        }
        colecaoVenda.deleteById(id);
    }
}

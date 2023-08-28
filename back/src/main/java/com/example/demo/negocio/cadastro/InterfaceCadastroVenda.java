package com.example.demo.negocio.cadastro;

import java.util.Date;
import java.util.List;

import com.example.demo.negocio.basica.Venda;
import com.example.demo.negocio.cadastro.exception.exceptionVenda.VendaInvalidaException;
import com.example.demo.negocio.cadastro.exception.exceptionVenda.VendaNaoEncontradaException;

public interface InterfaceCadastroVenda {

    Venda buscarVendaId(long id) throws VendaInvalidaException;

    List<Venda> buscarVendasPorData(Date data);

    List<Venda> buscarVendasPorValorTotal(double valor);

    List<Venda> buscarVendasComValorTotalMaiorOuIgual(double valor);

    Venda salvarVenda(Venda venda);

    List<Venda> listarVendas();

    boolean verificarExistenciaVendaPorId(long id);

    void removerVendaPorId(long id) throws VendaNaoEncontradaException;

}
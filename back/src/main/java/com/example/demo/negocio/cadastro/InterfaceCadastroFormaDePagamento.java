package com.example.demo.negocio.cadastro;

import java.util.List;

import com.example.demo.negocio.basica.FormaDePagamento;
import com.example.demo.negocio.cadastro.exception.exceptionFormaDePagamento.FormaDePagamentoNaoEncontradaException;


public interface InterfaceCadastroFormaDePagamento {

    
    List<FormaDePagamento> listarFormasDePagamento();

    boolean verificarExistenciaFormaDePagamentoId(Long id);

    FormaDePagamento localizarFormaDePagamentoId(Long id);

    void removerFormaDePagamentoId(Long id) 
            throws FormaDePagamentoNaoEncontradaException;
    
}

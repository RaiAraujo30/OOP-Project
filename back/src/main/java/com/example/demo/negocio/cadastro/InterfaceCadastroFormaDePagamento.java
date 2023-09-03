package com.example.demo.negocio.cadastro;

import java.util.List;

import com.example.demo.negocio.basica.FormaDePagamento;
import com.example.demo.negocio.cadastro.exception.exceptionFormaDePagamento.FormaDePagamentoDuplicadaException;
import com.example.demo.negocio.cadastro.exception.exceptionFormaDePagamento.FormaDePagamentoInvalidaException;
import com.example.demo.negocio.cadastro.exception.exceptionFormaDePagamento.FormaDePagamentoNaoEncontradaException;

public interface InterfaceCadastroFormaDePagamento {

    List<FormaDePagamento> listarFormasDePagamento();

    boolean verificarExistenciaFormaDePagamentoId(Long id);

    FormaDePagamento localizarFormaDePagamentoId(Long id);

    void removerFormaDePagamentoId(Long id)
            throws FormaDePagamentoNaoEncontradaException;

    FormaDePagamento salvarFormaDePagamento(FormaDePagamento formaDePagamento)
            throws FormaDePagamentoDuplicadaException;

    FormaDePagamento procurarFormaDePagamentoNome(String nome)
            throws FormaDePagamentoInvalidaException;
}

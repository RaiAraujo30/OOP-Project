package com.example.demo.negocio.cadastro;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dados.InterfaceColecaoFormaDePagamento;
import com.example.demo.negocio.basica.FormaDePagamento;
import com.example.demo.negocio.cadastro.exception.exceptionFormaDePagamento.FormaDePagamentoNaoEncontradaException;

@Service
public class CadastroFormaDePagamento implements InterfaceCadastroFormaDePagamento {
    @Autowired
    private InterfaceColecaoFormaDePagamento colecaoFormaDePagamento;

 

    public List<FormaDePagamento> listarFormasDePagamento() {
        return colecaoFormaDePagamento.findAll();
    }

    public boolean verificarExistenciaFormaDePagamentoId(Long id) {
        return colecaoFormaDePagamento.existsById(id);
    }

    public FormaDePagamento localizarFormaDePagamentoId(Long id) {
        return colecaoFormaDePagamento.findById(id).orElse(null);
    }

    public void removerFormaDePagamentoId(Long id) 
            throws FormaDePagamentoNaoEncontradaException {
        if (!verificarExistenciaFormaDePagamentoId(id)) {
            throw new FormaDePagamentoNaoEncontradaException(id);
        }
        colecaoFormaDePagamento.deleteById(id);
    }

   
}

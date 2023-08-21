package com.example.demo.negocio.cadastro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.negocio.basica.FormaDePagamento;
import com.example.demo.dados.InterfaceColecaoFormaDePagamento;
@Service
public class CadastroFormaDePagamento implements InterfaceCadastroFormaDePagamento {
    @Autowired
    private InterfaceColecaoFormaDePagamento colecaoFormaDePagamento;


}
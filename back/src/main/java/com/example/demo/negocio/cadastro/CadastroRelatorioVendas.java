package com.example.demo.negocio.cadastro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.negocio.basica.RelatorioVendas;
import com.example.demo.dados.InterfaceColecaoRelatorioVendas;
@Service

public class CadastroRelatorioVendas implements InterfaceCadastroRelatorioVendas {
    @Autowired
    private InterfaceColecaoRelatorioVendas colecaoRelatorioVendas;


}
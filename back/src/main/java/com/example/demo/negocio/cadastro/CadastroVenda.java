package com.example.demo.negocio.cadastro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.negocio.basica.Venda;
import com.example.demo.dados.InterfaceColecaoVenda;
@Service

public class CadastroVenda implements InterfaceCadastroVenda {
    @Autowired
    private InterfaceColecaoVenda colecaoVenda;

}
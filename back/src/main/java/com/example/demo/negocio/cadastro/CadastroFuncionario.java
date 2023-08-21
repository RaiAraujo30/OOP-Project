package com.example.demo.negocio.cadastro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.negocio.basica.Funcionario;
import com.example.demo.dados.InterfaceColecaoFuncionario;
@Service

public class CadastroFuncionario implements InterfaceCadastroFuncionario {
    @Autowired
    private InterfaceColecaoFuncionario colecaoFuncionario;


}
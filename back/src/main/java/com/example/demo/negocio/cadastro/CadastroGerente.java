package com.example.demo.negocio.cadastro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.negocio.basica.Gerente;
import com.example.demo.dados.InterfaceColecaoGerente;
@Service

public class CadastroGerente implements InterfaceCadastroGerente {
    @Autowired
    private InterfaceColecaoGerente colecaoGerente;


}
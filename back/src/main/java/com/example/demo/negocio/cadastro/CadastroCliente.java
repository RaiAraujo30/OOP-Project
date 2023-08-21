package com.example.demo.negocio.cadastro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dados.InterfaceColecaoCliente;
import com.example.demo.negocio.basica.Cliente;

@Service
public class CadastroCliente implements InterfaceCadastroCliente {
    @Autowired
    private InterfaceColecaoCliente colecaoCliente;


}
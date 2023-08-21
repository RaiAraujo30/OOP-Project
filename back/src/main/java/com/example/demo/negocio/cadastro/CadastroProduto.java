package com.example.demo.negocio.cadastro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.negocio.basica.Produto;
import com.example.demo.dados.InterfaceColecaoProduto;
@Service

public class CadastroProduto implements InterfaceCadastroProduto {
    @Autowired
    private InterfaceColecaoProduto colecaoProduto;


}
package com.example.demo.negocio.cadastro;

import java.util.List;

import com.example.demo.negocio.basica.Marcas;
import com.example.demo.negocio.cadastro.exception.exceptionMarcas.MarcaDuplicadaException;
import com.example.demo.negocio.cadastro.exception.exceptionMarcas.MarcaInvalidaException;
import com.example.demo.negocio.cadastro.exception.exceptionMarcas.MarcaNaoEncontradaException;


public interface InterfaceCadastroMarcas {

    
    Marcas procurarMarcaNomemarca(String nomemarca) 
    throws MarcaInvalidaException;

    Marcas salvarMarca(Marcas marca) 
    throws MarcaDuplicadaException;

    List<Marcas> listarMarcas();

    boolean verificarExistenciaMarcaId(Long id);

    Marcas localizarMarcaId(Long id);

    void removerMarcaId(Long id) 
    throws MarcaNaoEncontradaException;
    
}


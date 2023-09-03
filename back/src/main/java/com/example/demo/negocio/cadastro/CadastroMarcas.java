package com.example.demo.negocio.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dados.InterfaceColecaoMarcas;
import com.example.demo.negocio.basica.Marcas;
import com.example.demo.negocio.cadastro.exception.exceptionMarcas.MarcaDuplicadaException;
import com.example.demo.negocio.cadastro.exception.exceptionMarcas.MarcaInvalidaException;
import com.example.demo.negocio.cadastro.exception.exceptionMarcas.MarcaNaoEncontradaException;

@Service
public class CadastroMarcas implements InterfaceCadastroMarcas {

    @Autowired
    private InterfaceColecaoMarcas colecaoMarcas;

    public Marcas procurarMarcaNomemarca(String nomemarca)
            throws MarcaInvalidaException {
        Marcas marca = colecaoMarcas.findByNomemarcaContainingIgnoreCase(nomemarca);
        if (marca == null) {
            throw new MarcaInvalidaException(nomemarca);
        }
        return marca;
    }

    public Marcas salvarMarca(Marcas marca)
            throws MarcaDuplicadaException {
        try {
            procurarMarcaNomemarca(marca.getNomemarca());
            throw new MarcaDuplicadaException(marca.getNomemarca());
        } catch (MarcaInvalidaException err) {
            return colecaoMarcas.save(marca);
        }
    }

    public List<Marcas> listarMarcas() {
        return colecaoMarcas.findAll();
    }

    public boolean verificarExistenciaMarcaId(Long id) {
        return colecaoMarcas.existsById(id);
    }

    public Marcas localizarMarcaId(Long id) {
        return colecaoMarcas.findById(id).orElse(null);
    }

    public void removerMarcaId(Long id)
            throws MarcaNaoEncontradaException {
        if (!verificarExistenciaMarcaId(id)) {
            throw new MarcaNaoEncontradaException(id);
        }
        colecaoMarcas.deleteById(id);
    }

}

package com.example.demo.negocio.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.negocio.basica.Funcionario;
import com.example.demo.negocio.cadastro.exception.exceptionFuncionario.FuncionarioDuplicadoException;
import com.example.demo.negocio.cadastro.exception.exceptionFuncionario.FuncionarioInvalidoException;
import com.example.demo.negocio.cadastro.exception.exceptionFuncionario.FuncionarioNaoEncontradoException;
import com.example.demo.dados.InterfaceColecaoFuncionario;

@Service

public class CadastroFuncionario implements InterfaceCadastroFuncionario {

    @Autowired
    private InterfaceColecaoFuncionario colecaoFuncionario;

    public Funcionario procurarFuncionarioCpf(String cpf) throws FuncionarioInvalidoException {
        Funcionario funcionario = colecaoFuncionario.findByCpf(cpf);
        if (funcionario == null) {
            throw new FuncionarioInvalidoException(cpf);
        }
        return funcionario;
    }

    public Funcionario salvFuncionario(Funcionario funcionario) throws FuncionarioDuplicadoException {
        try {
            procurarFuncionarioCpf(funcionario.getCpf());
            throw new FuncionarioDuplicadoException(funcionario.getCpf());
        } catch (FuncionarioInvalidoException err) {
            return colecaoFuncionario.save(funcionario);
        }
    }

    public List<Funcionario> listarFuncionarios() {
        return colecaoFuncionario.findAll();
    }

    public boolean VerificarExistenciaFuncionario(Long id) {
        return colecaoFuncionario.existsById(id);
    }

    public Funcionario localizarFuncionario(Long id) {
        return colecaoFuncionario.findById(id).orElse(null);
    }

    public void RemoverFuncionario(Long id) throws FuncionarioNaoEncontradoException {
        if (!VerificarExistenciaFuncionario(id)) {
            throw new FuncionarioNaoEncontradoException(id);
        }
        colecaoFuncionario.deleteById(id);
    }

}
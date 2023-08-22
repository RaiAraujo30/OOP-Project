package com.example.demo.negocio.cadastro;

import java.util.List;

import com.example.demo.negocio.basica.Funcionario;
import com.example.demo.negocio.cadastro.exception.exceptionFuncionario.FuncionarioDuplicadoException;
import com.example.demo.negocio.cadastro.exception.exceptionFuncionario.FuncionarioInvalidoException;
import com.example.demo.negocio.cadastro.exception.exceptionFuncionario.FuncionarioNaoEncontradoException;


public interface InterfaceCadastroFuncionario {

    Funcionario procurarFuncionarioCpf (String cpf) throws  FuncionarioInvalidoException;

    List<Funcionario> procurarFuncionarioNome(String nome)
        throws FuncionarioInvalidoException;

    Funcionario salvFuncionario(Funcionario funcionario) throws FuncionarioDuplicadoException;

    List<Funcionario> listarFuncionarios();

    boolean VerificarExistenciaFuncionario(Long id);

    Funcionario localizarFuncionario(Long id);

    void RemoverFuncionario(Long id) 
    throws FuncionarioNaoEncontradoException;
}

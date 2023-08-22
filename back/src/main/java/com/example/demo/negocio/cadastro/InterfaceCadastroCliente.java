package com.example.demo.negocio.cadastro;

import java.util.List;

import com.example.demo.negocio.basica.Cliente;
import com.example.demo.negocio.cadastro.exception.exceptionCliente.ClienteDuplicadoExcerption;
import com.example.demo.negocio.cadastro.exception.exceptionCliente.ClienteInvalidoException;
import com.example.demo.negocio.cadastro.exception.exceptionCliente.ClienteNaoEncontradoException;


public interface InterfaceCadastroCliente {

    List<Cliente> procurarClienteNome(String nome)
            throws ClienteInvalidoException;

    Cliente SalvarCliente (Cliente cliente) 
                throws ClienteDuplicadoExcerption ;

    List<Cliente> listarClientes();

    boolean verificarExistenciaClienteId (Long id);

    Cliente localizarClienteId(Long id);
    
    void removerClienteId (Long id)
         throws ClienteNaoEncontradoException;

}

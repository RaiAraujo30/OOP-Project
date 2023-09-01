package com.example.demo.negocio.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dados.InterfaceColecaoCliente;
import com.example.demo.negocio.cadastro.exception.exceptionCliente.ClienteDuplicadoExcerption;
import com.example.demo.negocio.cadastro.exception.exceptionCliente.ClienteInvalidoException;
import com.example.demo.negocio.cadastro.exception.exceptionCliente.ClienteNaoEncontradoException;
import com.example.demo.negocio.basica.Cliente;

@Service
public class CadastroCliente implements InterfaceCadastroCliente {
    @Autowired
    private InterfaceColecaoCliente colecaoCliente;

    public List<Cliente> procurarClienteNome(String nome)
            throws ClienteInvalidoException {
        List<Cliente> clientes = colecaoCliente.findByNomeContainingIgnoreCase(nome);
        if (clientes.isEmpty()) {
            throw new ClienteInvalidoException(nome);
        }
        return clientes;
    }

    public Cliente SalvarCliente(Cliente cliente)
            throws ClienteDuplicadoExcerption {
        try {
            procurarClienteNome(cliente.getCpf());
            throw new ClienteDuplicadoExcerption(cliente.getCpf());
        } catch (ClienteInvalidoException err) {
            return colecaoCliente.save(cliente);
        }
    }

    public List<Cliente> listarClientes() {
        return colecaoCliente.findAll();
    }

    public boolean verificarExistenciaClienteId(Long id) {
        return colecaoCliente.existsById(id);
    }

    public Cliente localizarClienteId(Long id) {
        return colecaoCliente.findById(id).orElse(null);
    }

    public void removerClienteId(Long id)
            throws ClienteNaoEncontradoException {
        if (!verificarExistenciaClienteId(id)) {
            throw new ClienteNaoEncontradoException(id);
        }
        colecaoCliente.deleteById(id);
    }
}

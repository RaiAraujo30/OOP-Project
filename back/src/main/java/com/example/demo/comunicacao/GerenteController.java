package com.example.demo.comunicacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.negocio.basica.Cliente;
import com.example.demo.negocio.basica.Funcionario;
import com.example.demo.negocio.cadastro.exception.exceptionCliente.ClienteNaoEncontradoException;
import com.example.demo.negocio.cadastro.exception.exceptionFuncionario.FuncionarioNaoEncontradoException;
import com.example.demo.negocio.fachada.Fachada;

@RestController
@RequestMapping("/api/Gerente")
public class GerenteController {

    @Autowired
    public Fachada fachada;

    @DeleteMapping("/removerCliente/{idCliente}")
    public String DeletarCliente(@PathVariable Long idCliente) throws ClienteNaoEncontradoException {
        Cliente cliente = fachada.localizarClienteId(idCliente);
        cliente.setId(idCliente);
        fachada.removerClienteId(idCliente);
        return "ok";
    }

    @DeleteMapping("/removerFuncionario/{idFuncionario}")
    public String DeletarFuncionario(@PathVariable Long idFuncionario) throws FuncionarioNaoEncontradoException {
        Funcionario funcionario = fachada.localizarFuncionario(idFuncionario);
        funcionario.setId(idFuncionario);
        fachada.RemoverFuncionario(idFuncionario);
        return "ok";
    }

}

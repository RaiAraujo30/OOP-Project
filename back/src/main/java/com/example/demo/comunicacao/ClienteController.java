package com.example.demo.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.negocio.basica.Cliente;
import com.example.demo.negocio.cadastro.exception.exceptionCliente.ClienteDuplicadoExcerption;
import com.example.demo.negocio.fachada.Fachada;

@RestController
@RequestMapping("/api/Cliente")
public class ClienteController {

    @Autowired
    public Fachada fachada;

    @GetMapping("/listarClientes")
    public List<Cliente> listarClientes() {
        return fachada.listarClientes();
    }

    @PostMapping("/salvarCliente")
    public ResponseEntity<?> salvarCliente(@RequestBody Cliente clientebody) {
        try {
            Cliente cliente = new Cliente(clientebody.getNome(), clientebody.getCpf(), clientebody.getEndereco());
            cliente = fachada.SalvarCliente(cliente);
            return new ResponseEntity<>(cliente, HttpStatus.CREATED);
        } catch (ClienteDuplicadoExcerption e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

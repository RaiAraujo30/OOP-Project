package com.example.demo.dados;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.negocio.basica.Cliente;

@Repository
public interface InterfaceColecaoCliente extends JpaRepository<Cliente, Long>{

    public Cliente findById(long id);
    public Cliente findByCpf(String cpf);
    public List<Cliente> findByNomeContainingIgnoreCase(String nome);

}

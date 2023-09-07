package com.example.demo.dados;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.negocio.basica.Funcionario;

public interface InterfaceColecaoFuncionario extends JpaRepository<Funcionario, Long> {

    public Funcionario findById(long id);

    public Funcionario findByCpf(String cpf);

    public List<Funcionario> findByNomeContainingIgnoreCase(String nome);

}

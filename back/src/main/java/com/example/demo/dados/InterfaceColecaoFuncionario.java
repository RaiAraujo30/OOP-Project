package com.example.demo.dados;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.negocio.basica.Funcionario;

@Repository
public interface InterfaceColecaoFuncionario extends JpaRepository<Funcionario, Long>{
    
    public Funcionario findByCpf(String cpf);
    public Funcionario findByNome(String nome);
}

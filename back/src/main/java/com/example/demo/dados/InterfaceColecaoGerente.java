package com.example.demo.dados;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.negocio.basica.Gerente;

@Repository
public interface InterfaceColecaoGerente extends JpaRepository<Gerente, Long>{
    
}

package com.example.demo.dados;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.negocio.basica.Venda;

@Repository
public interface InterfaceColecaoVenda extends JpaRepository<Venda, Long> {
    
}
package com.example.demo.dados;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.negocio.basica.FormaDePagamento;

@Repository

public interface InterfaceColecaoFormaDePagamento extends JpaRepository<FormaDePagamento, Long> {

    public FormaDePagamento findById(long id);

    public FormaDePagamento findByNome(String nome);

}

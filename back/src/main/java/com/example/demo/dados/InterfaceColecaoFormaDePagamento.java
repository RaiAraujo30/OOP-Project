package com.example.demo.dados;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.negocio.basica.FormaDePagamento;

public interface InterfaceColecaoFormaDePagamento extends JpaRepository<FormaDePagamento, Long> {

    public FormaDePagamento findById(long id);

    public FormaDePagamento findByNome(String nome);

}

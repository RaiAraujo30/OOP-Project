package com.example.demo.dados;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.negocio.basica.Categoria;

public interface InterfaceColecaoCategoria extends JpaRepository<Categoria, Long> {

    public Categoria findByNomecategoria(String nomecategoria);

}

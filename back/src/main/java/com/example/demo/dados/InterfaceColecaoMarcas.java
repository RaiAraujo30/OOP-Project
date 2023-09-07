package com.example.demo.dados;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.negocio.basica.Marcas;

public interface InterfaceColecaoMarcas extends JpaRepository<Marcas, Long> {

    public Marcas findById(long id);

    public Marcas findByNomemarcaContainingIgnoreCase(String nomemarca);

}

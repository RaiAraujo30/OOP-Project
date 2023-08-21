package com.example.demo.dados;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.negocio.basica.Marcas;

@Repository
public interface InterfaceColecaoMarcas extends JpaRepository<Marcas, Long>{

    public Marcas findById(long id);
    public List<Marcas> findByNomeContainingIgnoreCase(String nomemarca);

}

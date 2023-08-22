package com.example.demo.dados;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.negocio.basica.Categoria;

@Repository
public interface InterfaceColecaoCategoria extends JpaRepository<Categoria, Long>{
    
    public Categoria findByNomecategoria(String nomecategoria);


}

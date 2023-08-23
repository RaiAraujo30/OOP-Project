package com.example.demo.negocio.basica;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String nomecategoria;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNomecategoria() {
        return nomecategoria;
    }
    public void setNomecategoria(String nomecategoria) {
        this.nomecategoria = nomecategoria;
    }
    public Categoria(String nomecategoria) {
        this.nomecategoria = nomecategoria;
    }

    
    
}
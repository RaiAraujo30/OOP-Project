package com.example.demo.negocio.basica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.ManyToMany;


@Entity

public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String nome;
    private double preco;

    @ManyToOne
    private Marcas marca;

    @ManyToMany
    private Categoria categoria;

    

    public long getId() {
        return id;
    }



    public void setId(long id) {
        this.id = id;
    }



    public String getNome() {
        return nome;
    }



    public void setNome(String nome) {
        this.nome = nome;
    }



    public double getPreco() {
        return preco;
    }



    public void setPreco(double preco) {
        this.preco = preco;
    }



    public Marcas getMarca() {
        return marca;
    }



    public void setMarca(Marcas marca) {
        this.marca = marca;
    }



    public Categoria getCategoria() {
        return categoria;
    }



    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }



    public Produto(String nome, double preco, Marcas marca, Categoria categoria) {
        this.nome = nome;
        this.preco = preco;
        this.marca = marca;
        this.categoria = categoria;
    }



    
    
    
    
}
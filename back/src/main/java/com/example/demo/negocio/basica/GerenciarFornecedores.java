package com.example.demo.negocio.basica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity

public class GerenciarFornecedores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Fornecedor> fornecedores;

    public GerenciarFornecedores() {
        this.fornecedores = new ArrayList<>();
    }

    public void adicionarFornecedor(Fornecedor fornecedor) {
        fornecedores.add(fornecedor);
    }

    public void removerFornecedor(Fornecedor fornecedor) {
        fornecedores.remove(fornecedor);
    }

    public List<Fornecedor> getFornecedores() {
        return fornecedores;
    }
}

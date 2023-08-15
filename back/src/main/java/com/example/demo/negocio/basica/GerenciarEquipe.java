package com.example.demo.negocio.basica;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity

public class GerenciarEquipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private List<Funcionario> equipe;

    public GerenciarEquipe() {
        this.equipe = new ArrayList<>();
    }

    public void adicionarMembro(Funcionario membro) {
        equipe.add(membro);
    }

    public void removerMembro(Funcionario membro) {
        equipe.remove(membro);
    }

    public List<Funcionario> getEquipe() {
        return equipe;
    }
    
}
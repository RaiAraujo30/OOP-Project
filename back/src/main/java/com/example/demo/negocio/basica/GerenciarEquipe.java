package com.example.demo.negocio.basica;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

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

    @OneToMany
    @Cascade(CascadeType.ALL)
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
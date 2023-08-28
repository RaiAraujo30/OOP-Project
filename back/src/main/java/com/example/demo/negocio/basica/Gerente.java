package com.example.demo.negocio.basica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity

public class Gerente extends Funcionario {
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
    private List<RelatorioVendas> relatorios;

    public Gerente(String nome, String cpf) {
        super(nome, cpf);
        this.relatorios = new ArrayList<>();
    }

    public void gerarRelatorioVendas(Date periodo) {
        RelatorioVendas relatorio = new RelatorioVendas(periodo);
        relatorios.add(relatorio);
    }

    public List<RelatorioVendas> getRelatorios() {
        return relatorios;
    }


    
}
    
    

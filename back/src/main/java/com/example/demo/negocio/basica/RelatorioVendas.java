package com.example.demo.negocio.basica;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity


public class RelatorioVendas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private Date data;
    private Date periodo;
    private double totalVendas;

    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public Date getPeriodo() {
        return periodo;
    }
    public void setPeriodo(Date periodo) {
        this.periodo = periodo;
    }
    public double getTotalVendas() {
        return totalVendas;
    }
    public void setTotalVendas(double totalVendas) {
        this.totalVendas = totalVendas;
    }
    
    public void incrementarTotalVendas(double totalVenda) {
        this.totalVendas += totalVenda;
    }

    public RelatorioVendas(Date periodo) {
        this.data = new Date();
        this.periodo = periodo;
        this.totalVendas = 0.0; // Inicialmente o total de vendas é zero
    }

    

}

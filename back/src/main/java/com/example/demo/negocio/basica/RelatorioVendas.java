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
    private Date dataInicio;
    private Date dataFim;
    
    private double totalVendas;

    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public Date getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }
    public Date getDataFim() {
        return dataFim;
    }
    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
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

    public RelatorioVendas() {
        this.totalVendas = 0.0; // Inicialmente o total de vendas é zero
    }
    
    public RelatorioVendas(Date data) {
        this.data = data;
        this.totalVendas = 0.0;
    }
    public RelatorioVendas(Date dataInicio, Date dataFim) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.totalVendas = 0.0; // Inicialmente o total de vendas é zero
    }
 
    

}

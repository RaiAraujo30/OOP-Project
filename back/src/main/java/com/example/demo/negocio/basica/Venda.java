package com.example.demo.negocio.basica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity

public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private Date data;
    private double total;

    @ManyToOne
    private Funcionario funcionario;

    @OneToMany
    private List<Item> itens;

    @ManyToOne
    private FormaDePagamento formaDePagamento;

    @ManyToOne
    private Cliente cliente;

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public FormaDePagamento getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(FormaDePagamento formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    

    public Venda(Cliente cliente,Date data, double total) {
        this.data = data;
        this.total = total;
        this.cliente = cliente;
    }

    public Venda(Cliente cliente, Funcionario funcionario) {
        this.cliente = cliente;
        this.funcionario = funcionario;

        this.itens = new ArrayList<>();
        this.data = new Date();
        this.total = 0.0;
    }

    public void adicionarItem(Produto produto, int quantidade) {
        Item item = new Item(produto, quantidade);
        itens.add(item);
    }

    public void removerItem(Item item) {
        itens.remove(item);
    }
    
    public double calcularTotal() {
        double total = 0.0;
        for (Item item : itens) {
            total += item.getTotal();
        }
        return total;
    }

    
}
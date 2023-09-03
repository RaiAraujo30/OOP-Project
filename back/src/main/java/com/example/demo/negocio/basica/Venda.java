package com.example.demo.negocio.basica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

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

    @ManyToOne
    private Funcionario funcionario;

    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Item> itens;

    @ManyToOne
    private FormaDePagamento formaDePagamento;

    @ManyToOne
    private Cliente cliente;

    private double total;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

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

    public Venda() {
        this.itens = new ArrayList<>();
        this.data = new Date();
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
package com.example.demo.negocio.basica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FormaDePagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    

    private long id;
    private String dinheiro;
    private String cartao;
    private String pix;
    private String hibrido;

    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getDinheiro() {
        return dinheiro;
    }
    public void setDinheiro(String dinheiro) {
        this.dinheiro = dinheiro;
    }
    public String getCartao() {
        return cartao;
    }
    public void setCartao(String cartao) {
        this.cartao = cartao;
    }
    public String getPix() {
        return pix;
    }
    public void setPix(String pix) {
        this.pix = pix;
    }
    public String getHibrido() {
        return hibrido;
    }
    public void setHibrido(String hibrido) {
        this.hibrido = hibrido;
    }
    
    public FormaDePagamento(String dinheiro, String cartao, String pix, String hibrido) {
        this.dinheiro = dinheiro;
        this.cartao = cartao;
        this.pix = pix;
        this.hibrido = hibrido;
    }
    public FormaDePagamento() {
    }

    
}

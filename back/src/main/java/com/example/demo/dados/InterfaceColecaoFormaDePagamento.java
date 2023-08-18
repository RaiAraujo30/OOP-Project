package com.example.demo.dados;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.negocio.basica.FormaDePagamento;


@Repository

public interface InterfaceColecaoFormaDePagamento extends JpaRepository<FormaDePagamento, Long>{
    
public FormaDePagamento findById(long id);
public List<FormaDePagamento> findByDinheiroContainingIgnoreCase(String dinheiro);
public List<FormaDePagamento> findByHibridoContainingIgnoreCase(String hibrido);
public List<FormaDePagamento> findByCartaoContainingIgnoreCase(String cartao);
public List<FormaDePagamento> findByPixContainingIgnoreCase(String pix);


}

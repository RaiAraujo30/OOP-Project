
package com.example.demo.dados;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.negocio.basica.Venda;

@Repository
public interface InterfaceColecaoVenda extends JpaRepository<Venda, Long> {
    
    public Venda findById(long id);
    public List<Venda> findByData(Date data);
    public List<Venda> findByDataBetween(Date dataInicio, Date dataFim);
    public List<Venda> findByTotal (double valor);
    public List<Venda> findByTotalGreaterThanEqual(double valor);
    public List<Venda> findByTotalLessThanEqual(double valor);
    public List<Venda> findByClienteNomeContainingIgnoreCase(String nome);

}

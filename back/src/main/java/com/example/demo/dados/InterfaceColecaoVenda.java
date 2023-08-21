package com.example.demo.dados;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.negocio.basica.Venda;

@Repository
public interface InterfaceColecaoVenda extends JpaRepository<Venda, Long> {
    
    public Venda findById(long id);
    public List<Venda> findByDataBetween(Date dataInicio, Date dataFim);
    public List<Venda> findByTotalGreaterThanEqual(double valor);
    public List<Venda> findByTotalLessThanEqual(double valor);
<<<<<<< HEAD
<<<<<<< HEAD
=======
    public List<Venda> findByFuncionarioNomeContainingIgnoreCase(String nome);
>>>>>>> parent of 6e8d575 (refazendo as interfaces p/ o test)
=======
    public List<Venda> findByFuncionario(String nome);
>>>>>>> parent of 11d4827 (Iniciando cadastro)
    public List<Venda> findByClienteNomeContainingIgnoreCase(String nome);

}

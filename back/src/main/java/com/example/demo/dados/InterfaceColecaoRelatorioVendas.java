package com.example.demo.dados;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.negocio.basica.RelatorioVendas;

@Repository
public interface InterfaceColecaoRelatorioVendas extends JpaRepository<RelatorioVendas, Long>{

    public RelatorioVendas findById(long id);
    public List<RelatorioVendas> findByData(Date data);
    public List<RelatorioVendas> findByPeriodoContainingIgnoreCase(Date dataInicio, Date dataFim);
    public List<RelatorioVendas> findByTotalVendas(double totalVendas);
    public List<RelatorioVendas> findByTotalVendasGreaterThanEqual(double totalVendas);

}
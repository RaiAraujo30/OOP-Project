
package com.example.demo.dados;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.negocio.basica.RelatorioVendas;

public interface InterfaceColecaoRelatorioVendas extends JpaRepository<RelatorioVendas, Long> {

    public RelatorioVendas findById(long id);

    public List<RelatorioVendas> findByData(Date data);

    List<RelatorioVendas> findByDataInicioBetween(Date dataInicio, Date dataFim);

    public List<RelatorioVendas> findByTotalVendas(double totalVendas);

    public List<RelatorioVendas> findByTotalVendasGreaterThanEqual(double totalVendas);

}

package com.example.demo.dados;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.negocio.basica.Produto;

@Repository
public interface InterfaceColecaoProduto extends JpaRepository<Produto, Long>{

    public Produto findById(long id);
    public List<Produto> findByNomeContainingIgnoreCase(String nome);
    public List<Produto> findByPreco(double preco);
    public List<Produto> findByMarcaContainingIgnoreCase(String marca);
    public List<Produto> findByCategoriaContainingIgnoreCase(String categoria);


}

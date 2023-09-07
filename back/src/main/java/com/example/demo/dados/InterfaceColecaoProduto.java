package com.example.demo.dados;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.negocio.basica.Categoria;
import com.example.demo.negocio.basica.Marcas;
import com.example.demo.negocio.basica.Produto;

public interface InterfaceColecaoProduto extends JpaRepository<Produto, Long> {

    public Produto findById(long id);

    public List<Produto> findByNomeContainingIgnoreCase(String nome);

    public List<Produto> findByPreco(double preco);

    public List<Produto> findByMarca(Marcas marca);

    public List<Produto> findByCategoria(Categoria categoria);

}

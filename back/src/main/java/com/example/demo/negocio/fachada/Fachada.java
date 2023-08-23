package com.example.demo.negocio.fachada;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.negocio.basica.Cliente;
import com.example.demo.negocio.basica.Item;
import com.example.demo.negocio.basica.Produto;
import com.example.demo.negocio.basica.RelatorioVendas;
import com.example.demo.negocio.basica.Venda;
import com.example.demo.negocio.cadastro.InterfaceCadastroProduto;
import com.example.demo.negocio.cadastro.InterfaceCadastroRelatorioVendas;
import com.example.demo.negocio.cadastro.InterfaceCadastroVenda;
import com.example.demo.negocio.cadastro.exception.exceptionProduto.ProdutoIdInvalidoException;


@Service
public class Fachada {

     @Autowired
    private InterfaceCadastroVenda cadastroVenda;
    
    @Autowired
    private InterfaceCadastroProduto cadastroProduto;
    
    @Autowired
    private InterfaceCadastroRelatorioVendas cadastroRelatorioVendas;

    public Venda realizarVenda(Cliente cliente, List<Item> itens) throws ProdutoIdInvalidoException{
        double totalVenda = 0.0;

          for (Item item : itens) {
            Produto produto = cadastroProduto.localizarProdutoPorId(item.getProduto().getId());
      
            if (produto == null) {
                throw new ProdutoIdInvalidoException(item.getProduto().getId());
            }
                  
            totalVenda += produto.getPreco() * item.getQuantidade();
        }

        // Criar a venda
        Venda venda = new Venda(cliente, new Date(), totalVenda);
        venda = cadastroVenda.salvarVenda(venda);

        Date dataAtual = new Date();
        List<RelatorioVendas> relatorios = cadastroRelatorioVendas.buscarRelatoriosVendasPorData(dataAtual);
        RelatorioVendas relatorio;
        if (relatorios.isEmpty()) {
            relatorio = new RelatorioVendas(dataAtual);
            relatorio = cadastroRelatorioVendas.salvarRelatorioVendas(relatorio);
        } else {
            relatorio = relatorios.get(0);
        }

        // Incrementar o total de vendas no relatório
        relatorio.incrementarTotalVendas(totalVenda);
        cadastroRelatorioVendas.salvarRelatorioVendas(relatorio);

        return venda;
    }

    
    
}

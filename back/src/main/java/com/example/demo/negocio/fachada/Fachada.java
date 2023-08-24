 /* 
package com.example.demo.negocio.fachada;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.negocio.basica.Categoria;
import com.example.demo.negocio.basica.Cliente;
import com.example.demo.negocio.basica.FormaDePagamento;
import com.example.demo.negocio.basica.Funcionario;
import com.example.demo.negocio.basica.Item;
import com.example.demo.negocio.basica.Marcas;
import com.example.demo.negocio.basica.Produto;
import com.example.demo.negocio.basica.RelatorioVendas;
import com.example.demo.negocio.basica.Venda;
import com.example.demo.negocio.cadastro.InterfaceCadastroCategoria;
import com.example.demo.negocio.cadastro.InterfaceCadastroCliente;
import com.example.demo.negocio.cadastro.InterfaceCadastroFormaDePagamento;
import com.example.demo.negocio.cadastro.InterfaceCadastroFuncionario;
import com.example.demo.negocio.cadastro.InterfaceCadastroMarcas;
import com.example.demo.negocio.cadastro.InterfaceCadastroProduto;
import com.example.demo.negocio.cadastro.InterfaceCadastroRelatorioVendas;
import com.example.demo.negocio.cadastro.InterfaceCadastroVenda;
import com.example.demo.negocio.cadastro.exception.exceptionCategoria.CategoriaDuplicadaException;
import com.example.demo.negocio.cadastro.exception.exceptionCategoria.CategoriaInvalidaException;
import com.example.demo.negocio.cadastro.exception.exceptionCliente.ClienteDuplicadoExcerption;
import com.example.demo.negocio.cadastro.exception.exceptionCliente.ClienteInvalidoException;
import com.example.demo.negocio.cadastro.exception.exceptionCliente.ClienteNaoEncontradoException;
import com.example.demo.negocio.cadastro.exception.exceptionFormaDePagamento.FormaDePagamentoNaoEncontradaException;
import com.example.demo.negocio.cadastro.exception.exceptionFuncionario.FuncionarioDuplicadoException;
import com.example.demo.negocio.cadastro.exception.exceptionFuncionario.FuncionarioInvalidoException;
import com.example.demo.negocio.cadastro.exception.exceptionFuncionario.FuncionarioNaoEncontradoException;
import com.example.demo.negocio.cadastro.exception.exceptionProduto.ProdutoDuplicadoException;
import com.example.demo.negocio.cadastro.exception.exceptionProduto.ProdutoIdInvalidoException;
import com.example.demo.negocio.cadastro.exception.exceptionProduto.ProdutoInvalidoException;
import com.example.demo.negocio.cadastro.exception.exceptionProduto.ProdutoNaoEncontradoException;
import com.example.demo.negocio.cadastro.exception.exceptionVenda.VendaInvalidaException;
import com.example.demo.negocio.cadastro.exception.exceptionVenda.VendaNaoEncontradaException;



@Service
public class Fachada {

    @Autowired
    private InterfaceCadastroVenda cadastroVenda;
    @Autowired
    private InterfaceCadastroFuncionario cadastroFuncionario;
    @Autowired
    private InterfaceCadastroFormaDePagamento cadastroFormaDePagamento;
    @Autowired
    private InterfaceCadastroCliente cadastroCliente;
    @Autowired
    private InterfaceCadastroProduto cadastroProduto;
    @Autowired
    private InterfaceCadastroCategoria cadastroCategoria;
    @Autowired
    private InterfaceCadastroMarcas cadastroMarcas;  
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

    public RelatorioVendas gerarRelatorioPorPeriodo (Date inicio, Date fim) {
        List<RelatorioVendas> relatorios = cadastroRelatorioVendas.buscarRelatoriosVendasPorPeriodo(inicio, fim);

        double totalVendas = 0.0;

        for (RelatorioVendas relatorio : relatorios) {
            totalVendas += relatorio.getTotalVendas();
        }

        RelatorioVendas relatorioConsolidado = new RelatorioVendas();
        relatorioConsolidado.setDataInicio(inicio);
        relatorioConsolidado.setDataFim(fim);
        relatorioConsolidado.setTotalVendas(totalVendas);

        return relatorioConsolidado;
}

    public Produto CadastrarProduto (String nomeProduto, String nomeCategoria, String nomeMarca, double preco) throws ProdutoDuplicadoException, CategoriaInvalidaException, CategoriaDuplicadaException {
        Categoria categoria = cadastroCategoria.procurarCategoriaNomecategoria(nomeCategoria);
        if(categoria == null){
                categoria = new Categoria(nomeCategoria);
                categoria = cadastroCategoria.salvarCategoria(categoria);
        }   

        Marcas marca = cadastroMarcas.procurarMarcaNomemarca(nomeMarca);
        if (marca == null){
                marca = new Marcas(nomeMarca);
                marca = cadastroMarcas.salvarMarca(marca);
        }
        Produto produto = new Produto(nomeProduto, preco, marca, categoria);
        produto = cadastroProduto.salvarProduto(produto);

        return produto;
    }

    public Categoria procurarCategoriaNomecategoria(String nomecategoria) 
            throws CategoriaInvalidaException {
                return cadastroCategoria.procurarCategoriaNomecategoria(nomecategoria);
            }
    public Categoria salvarCategoria(Categoria categoria)   
            throws CategoriaDuplicadaException{
                return cadastroCategoria.salvarCategoria(categoria);
            }
    public List<Categoria> listarCategorias(){
        return cadastroCategoria.listarCategorias();
    }
    public boolean verificarExistenciaCategoriaId(Long id){
        return cadastroCategoria.verificarExistenciaCategoriaId(id);
    }
    public Categoria localizarCategoriaId(Long id){
        return cadastroCategoria.localizarCategoriaId(id);
    }
    public void removerCategoriaNomecategoria(String nomecategoria) 
			throws CategoriaInvalidaException  {
                cadastroCategoria.removerCategoriaNomecategoria(nomecategoria);
            }
    
            
    public List<Cliente> procurarClienteNome(String nome)
            throws ClienteInvalidoException{
                return cadastroCliente.procurarClienteNome(nome);
            }
    public Cliente SalvarCliente (Cliente cliente) 
                throws ClienteDuplicadoExcerption{
                    return cadastroCliente.SalvarCliente(cliente);
                }
    public List<Cliente> listarClientes(){
        return cadastroCliente.listarClientes();
    }
    public boolean verificarExistenciaClienteId (Long id){
        return cadastroCliente.verificarExistenciaClienteId(id);
    }
    public Cliente localizarClienteId(Long id){
        return cadastroCliente.localizarClienteId(id);
    }
    public void removerClienteId (Long id)
         throws ClienteNaoEncontradoException{
            cadastroCliente.removerClienteId(id);
         }

    public List<FormaDePagamento> listarFormasDePagamento(){
        return cadastroFormaDePagamento.listarFormasDePagamento();
    }
    public boolean verificarExistenciaFormaDePagamentoId(Long id){
        return cadastroFormaDePagamento.verificarExistenciaFormaDePagamentoId(id);
    }
    public FormaDePagamento localizarFormaDePagamentoId(Long id){
        return cadastroFormaDePagamento.localizarFormaDePagamentoId(id); 
    }
    public void removerFormaDePagamentoId(Long id) throws FormaDePagamentoNaoEncontradaException{
        cadastroFormaDePagamento.removerFormaDePagamentoId(id);
    }
    
    public Funcionario procurarFuncionarioCpf (String cpf) throws FuncionarioInvalidoException{
        return cadastroFuncionario.procurarFuncionarioCpf(cpf);
    }
    public List<Funcionario> procurarFuncionarioNome(String nome)throws FuncionarioInvalidoException{
        return cadastroFuncionario.procurarFuncionarioNome(nome);
    }
    public Funcionario salvFuncionario(Funcionario funcionario) throws FuncionarioDuplicadoException{
        return cadastroFuncionario.salvFuncionario(funcionario);
    }
    public List<Funcionario> listarFuncionarios(){
        return cadastroFuncionario.listarFuncionarios();
    }
    public boolean VerificarExistenciaFuncionario(Long id){
        return cadastroFuncionario.VerificarExistenciaFuncionario(id);
    }
    public Funcionario localizarFuncionario(Long id){
        return cadastroFuncionario.localizarFuncionario(id);
    }
    public void RemoverFuncionario(Long id) throws FuncionarioNaoEncontradoException{
        cadastroFuncionario.RemoverFuncionario(id);
    }


    
    public Marcas procurarMarcaNomemarca(String nomemarca){
        return cadastroMarcas.procurarMarcaNomemarca(nomemarca);
    }
    public Marcas salvarMarca(Marcas marca){
        return cadastroMarcas.salvarMarca(marca);
    }
    public List<Marcas> listarMarcas(){
        return cadastroMarcas.listarMarcas();
    }
    public boolean verificarExistenciaMarcaId(Long id){
        return cadastroMarcas.verificarExistenciaMarcaId(id);
    } 
    public Marcas localizarMarcaId(Long id){
        return cadastroMarcas.localizarMarcaId(id);
    }
    public void removerMarcaId(Long id) {
         cadastroMarcas.removerMarcaId(id);
    }

    public List<Produto> procurarProdutoPorNome(String nome) throws ProdutoInvalidoException{
        return cadastroProduto.procurarProdutoPorNome(nome);
    }

    public Produto salvarProduto(Produto produto) throws ProdutoDuplicadoException{
        return cadastroProduto.salvarProduto(produto);
    }

    public List<Produto> listarProdutos(){
        return cadastroProduto.listarProdutos();
    }

    public boolean verificarExistenciaProdutoPorId(Long id){
        return cadastroProduto.verificarExistenciaProdutoPorId(id);
    }

    public Produto localizarProdutoPorId(Long id){
        return cadastroProduto.localizarProdutoPorId(id);
    }

    public void removerProdutoPorId(Long id) throws ProdutoNaoEncontradoException{
        cadastroProduto.removerProdutoPorId(id);
    }


    public RelatorioVendas salvarRelatorioVendas(RelatorioVendas relatorio){
        return cadastroRelatorioVendas.salvarRelatorioVendas(relatorio);
    }

    public List<RelatorioVendas> listarRelatoriosVendas(){
        return cadastroRelatorioVendas.listarRelatoriosVendas();
    }

    public List<RelatorioVendas> buscarRelatoriosVendasPorData(Date data){
        return cadastroRelatorioVendas.buscarRelatoriosVendasPorData(data);
    }
    
    public List<RelatorioVendas> buscarRelatoriosVendasPorPeriodo(Date dataInicio, Date dataFim){
        return cadastroRelatorioVendas.buscarRelatoriosVendasPorPeriodo(dataInicio, dataFim);
    }

    public List<RelatorioVendas> buscarRelatoriosVendasPorTotalVendas(double totalVendas){
        return cadastroRelatorioVendas.buscarRelatoriosVendasPorTotalVendas(totalVendas);
    }
    
    public List<RelatorioVendas> buscarRelatoriosVendasComTotalVendasMaiorOuIgual(double totalVendas){
        return cadastroRelatorioVendas.buscarRelatoriosVendasComTotalVendasMaiorOuIgual(totalVendas);
    }


    public Venda buscarVendaId(long id) throws VendaInvalidaException{
        return cadastroVenda.buscarVendaId(id);
    }

    public List<Venda> buscarVendasPorData(Date data){
        return cadastroVenda.buscarVendasPorData(data);
    }

    public List<Venda> buscarVendasPorValorTotal(double valor){
        return cadastroVenda.buscarVendasPorValorTotal(valor);
    }

    public List<Venda> buscarVendasComValorTotalMaiorOuIgual(double valor){
        return cadastroVenda.buscarVendasComValorTotalMaiorOuIgual(valor);
    }

    public Venda salvarVenda(Venda venda){
        return cadastroVenda.salvarVenda(venda);
    }

    public List<Venda> listarVendas(){
        return cadastroVenda.listarVendas();
    }

    public boolean verificarExistenciaVendaPorId(long id){
        return cadastroVenda.verificarExistenciaVendaPorId(id);
    }

    public void removerVendaPorId(long id) throws VendaNaoEncontradaException{
        cadastroVenda.removerVendaPorId(id);
    }
    
        }
        */
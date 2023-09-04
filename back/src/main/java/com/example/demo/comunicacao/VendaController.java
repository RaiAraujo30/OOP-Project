package com.example.demo.comunicacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.negocio.basica.Cliente;
import com.example.demo.negocio.basica.FormaDePagamento;
import com.example.demo.negocio.basica.Funcionario;
import com.example.demo.negocio.basica.Item;
import com.example.demo.negocio.basica.Produto;
import com.example.demo.negocio.basica.Venda;
import com.example.demo.negocio.cadastro.exception.ExceptionItem.ItemvazioException;
import com.example.demo.negocio.cadastro.exception.exceptionCliente.ClienteInvalidoException;
import com.example.demo.negocio.cadastro.exception.exceptionFormaDePagamento.FormaDePagamentoDuplicadaException;
import com.example.demo.negocio.cadastro.exception.exceptionFuncionario.FuncionarioDuplicadoException;
import com.example.demo.negocio.cadastro.exception.exceptionFuncionario.FuncionarioInvalidoException;
import com.example.demo.negocio.cadastro.exception.exceptionProduto.ProdutoDuplicadoException;
import com.example.demo.negocio.cadastro.exception.exceptionVenda.VendaInvalidaException;
import com.example.demo.negocio.fachada.Fachada;

@RestController
@RequestMapping("/api/venda")
public class VendaController {

    @Autowired
    public Fachada fachada;

    @PostMapping("/realizarVenda")
    public ResponseEntity<?> realizarVendar(@RequestBody Venda vendaBody)
            throws FuncionarioDuplicadoException, ProdutoDuplicadoException {
        try {
            for (Item item : vendaBody.getItens()) {
                Produto Produto = fachada.localizarProdutoPorId(item.getProduto().getId());
                item.setProduto(Produto);
            }
            Funcionario funcionario = fachada.localizarFuncionario(vendaBody.getFuncionario().getId());
            vendaBody.setFuncionario(funcionario);
            Cliente cliente = fachada.localizarClienteId(vendaBody.getCliente().getId());
            FormaDePagamento formaDePagamento = fachada
                    .localizarFormaDePagamentoId(vendaBody.getFormaDePagamento().getId());
            vendaBody.setFormaDePagamento(formaDePagamento);
            vendaBody.setCliente(cliente);
            Venda novaVenda = fachada.realizarVenda(vendaBody.getCliente(), vendaBody.getFuncionario(),
                    vendaBody.getItens(), vendaBody.getFormaDePagamento());
            return new ResponseEntity<>(novaVenda, HttpStatus.CREATED);
        } catch (VendaInvalidaException | ClienteInvalidoException | FuncionarioInvalidoException | ItemvazioException
                | FormaDePagamentoDuplicadaException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}

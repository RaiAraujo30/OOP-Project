package com.example.demo.dados;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.negocio.basica.Cliente;
import com.example.demo.negocio.basica.Endereco;
import com.example.demo.negocio.basica.Funcionario;
import com.example.demo.negocio.basica.FormaDePagamento;
import com.example.demo.negocio.basica.Venda;

@SpringBootTest

class InterfaceColecaoVendaTest {

    @Autowired
    private InterfaceColecaoVenda colecaoVenda;

    @Test
    void testFindByDataBetween() {

// Crie um endereço de teste
Endereco endereco = new Endereco("Rua A", 123, "12345-678", "Bairro X", "Cidade Y", "Estado Z");

// Crie um cliente de teste
Cliente cliente = new Cliente("Nome Cliente", "cliente@example.com", endereco);



// Crie um funcionário de teste com o endereço
Funcionario funcionario = new Funcionario("Nome Funcionário", "Vendedor", endereco);

// Crie algumas vendas de teste com datas variadas
Venda venda1 = new Venda(cliente, funcionario);
venda1.setData(new Date()); // Data atual
colecaoVenda.save(venda1);

Venda venda2 = new Venda(cliente, funcionario);
Date dataOntem = new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000); // Data de ontem
venda2.setData(dataOntem);
colecaoVenda.save(venda2);

Venda venda3 = new Venda(cliente, funcionario);
Date dataAmanha = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000); // Data de amanhã
venda3.setData(dataAmanha);
colecaoVenda.save(venda3);

// Chame o método de consulta para buscar as vendas entre dataOntem e dataAmanha
List<Venda> vendasEntreDatas = colecaoVenda.findByDataBetween(dataOntem, dataAmanha);

// Verifique os resultados
assertEquals(2, vendasEntreDatas.size());
assertTrue(vendasEntreDatas.contains(venda2));
assertTrue(vendasEntreDatas.contains(venda1));
assertFalse(vendasEntreDatas.contains(venda3));
    }




    

}

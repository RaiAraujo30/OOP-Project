package com.example.demo.dados;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.negocio.basica.Endereco;
import com.example.demo.negocio.basica.Funcionario;

@SpringBootTest
class InterfaceColecaoFuncionarioTest {

    @Autowired
    private InterfaceColecaoFuncionario colecaoFuncionario;

    @Test
    void cadastrarTest() {
        // Crie um endereço de teste
        Endereco endereco = new Endereco("Rua A", 123, "12345-678", "Bairro X", "Cidade Y", "Estado Z");

        // Crie um Funcionario de teste
        // Inicialização
        long qtdFuncionario = colecaoFuncionario.count();
        Funcionario u = new Funcionario("Rai", "2342", endereco);

        // Interação
        colecaoFuncionario.save(u);
        long qtdFuncionario2 = colecaoFuncionario.count();

        // Verificação
        assertEquals(qtdFuncionario + 1, qtdFuncionario2);
    }
}

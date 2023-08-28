
package com.example.demo.negocio.cadastro;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.negocio.basica.Endereco;
import com.example.demo.negocio.basica.Funcionario;
import com.example.demo.negocio.cadastro.exception.exceptionFuncionario.FuncionarioDuplicadoException;


@SpringBootTest
class CadastroFuncionarioTest {

    @Autowired
    private InterfaceCadastroFuncionario cadastroFuncionario;

    @Test
    void testarCadastroCpfDuplicado(){
        String cpf ="123123";
        Endereco endereco = new Endereco("Rua A", 123, "12345-678", "Bairro X", "Cidade Y", "Estado Z");
        Endereco endereco2 = new Endereco("Rua B", 123, "12345-678", "Bairro X", "Cidade Y", "Estado Z");

        Funcionario u1 = new Funcionario("Rai", cpf);
        Funcionario u2 = new Funcionario("Igor", cpf);
        u1.setEndereco(endereco);
        u2.setEndereco(endereco2);

        FuncionarioDuplicadoException exception = assertThrows(FuncionarioDuplicadoException.class, () -> {
            cadastroFuncionario.salvFuncionario(u1);
            cadastroFuncionario.salvFuncionario(u2);
        }
        );
        assertEquals(exception.getCpf(),cpf);
        assertTrue(exception.getMessage().contains("mesmo cpf"));

    }

}

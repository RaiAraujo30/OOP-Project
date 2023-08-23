package com.example.demo.negocio.cadastro;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.negocio.basica.Endereco;
import com.example.demo.negocio.basica.Funcionario;
import com.example.demo.dados.InterfaceColecaoFuncionario;

@SpringBootTest
class CadastroFuncionarioTest {

    @Autowired
    private CadastroFuncionario cadastroFuncionario;

    @MockBean
    private InterfaceColecaoFuncionario colecaoFuncionario;

    private Funcionario funcionario;

    @BeforeEach
    void setUp() {
        Endereco endereco = new Endereco("Rua A", 123, "12345-678", "Bairro X", "Cidade Y", "Estado Z");
        funcionario = new Funcionario("Rai","3424", endereco);
    }

    @Test
    void testProcurarFuncionarioCpf() {
        when(colecaoFuncionario.findByCpf(anyString())).thenReturn(funcionario);

        try {
            Funcionario resultado = cadastroFuncionario.procurarFuncionarioCpf("123.456.789-00");
            assertEquals(funcionario, resultado);
        } catch (Exception e) {
            fail("Exceção não esperada: " + e.getMessage());
        }
    }

      @Test
    void testProcurarFuncionarioNome() {
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(funcionario);

        when(colecaoFuncionario.findByNomeContainingIgnoreCase(anyString())).thenReturn(funcionarios);

        try {
            List<Funcionario> resultados = cadastroFuncionario.procurarFuncionarioNome("Nome");
            assertEquals(funcionarios, resultados);
        } catch (Exception e) {
            fail("Exceção não esperada: " + e.getMessage());
        }
    }

    @Test
    void testSalvFuncionario() {
        when(colecaoFuncionario.save(any())).thenReturn(funcionario);

        try {
            Funcionario resultado = cadastroFuncionario.salvFuncionario(funcionario);
            assertEquals(funcionario, resultado);
        } catch (Exception e) {
            fail("Exceção não esperada: " + e.getMessage());
        }
    }

    @Test
    void testListarFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(funcionario);

        when(colecaoFuncionario.findAll()).thenReturn(funcionarios);

        List<Funcionario> resultados = cadastroFuncionario.listarFuncionarios();
        assertEquals(funcionarios, resultados);
    }

}
package com.example.demo.comunicacao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class FuncionarioControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testListarFuncionarios() {
        ResponseEntity<String> response = restTemplate.getForEntity(
                "/api/Funcionarios/listarFuncionarios", String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        // Adicione verificações adicionais com base na estrutura da resposta JSON
    }

    @Test
    void testSalvarFuncionario() {
        String funcionarioBodyJson = "{ \"nome\": \"João\", \"cpf\": \"12345678901\", \"endereco\": \"Rua A\" }";

        ResponseEntity<String> response = restTemplate.postForEntity(
                "/api/Funcionarios/salvFuncionario", funcionarioBodyJson, String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        // Adicione verificações adicionais com base na estrutura da resposta JSON
    }
}
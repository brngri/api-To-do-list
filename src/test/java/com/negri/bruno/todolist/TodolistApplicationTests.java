package com.negri.bruno.todolist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDate;
import com.negri.bruno.todolist.entity.EntityTodo;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class TodolistApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testCreateTodoSuccess() {
		var todo = new EntityTodo("Atividade 01", "Fazer pagina 56", false, LocalDate.parse("2024-05-09"));
		webTestClient
			.post()
			.uri("/todo") // posta
			.bodyValue(todo) // valor corpo
			.exchange() // requisição
			.expectStatus().isOk() //espera Ok
			.expectBody()
			.jsonPath("$").isArray() 
			.jsonPath("$.length()").isEqualTo(1)
			.jsonPath("$[0].titulo").isEqualTo(todo.getTitulo())
			.jsonPath("$[0].descricao").isEqualTo(todo.getDescricao())
			.jsonPath("$[0].realizado").isEqualTo(todo.getRealizado())
			.jsonPath("$[0].data").isEqualTo(todo.getData().toString());


	}

	@Test
	void testCreateTodoFailure() {
	}

}

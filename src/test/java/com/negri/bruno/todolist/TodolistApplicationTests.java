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
				.uri("/todo") // porta
				.bodyValue(todo) // valor corpo
				.exchange() // requisição
				.expectStatus().isOk() //espera Ok
				.expectBody()
				.jsonPath("$").isArray() 
				.jsonPath("$[0].titulo").isEqualTo(todo.getTitulo())
				.jsonPath("$[0].descricao").isEqualTo(todo.getDescricao())
				.jsonPath("$[0].realizado").isEqualTo(todo.getRealizado())
				.jsonPath("$[0].data").isEqualTo(todo.getData().toString());


		}

		@Test
		void testCreateTodoFailure() {
			webTestClient
				.post()
				.uri("/todo")
				.bodyValue(
					new EntityTodo("","",false,LocalDate.parse("2024-05-09"))
				).exchange()
				.expectStatus().isBadRequest();
		}

		@Test
		void testListTodoSuccess(){
			webTestClient
				.get()
				.uri("/todo")
				.exchange()
				.expectStatus().isOk();
		}

		@Test
		void testListTodoFailure(){
			webTestClient
			.get()
			.uri("/")
			.exchange()
			.expectStatus().isNotFound();
		}


		@Test
		void testUpdateTodoSuccess(){

			var todo = new EntityTodo("Atividade teste", "descrução", false, LocalDate.parse("2024-05-09"));
			webTestClient
			.post()
			.uri("/todo")
			.bodyValue(todo)
			.exchange()
			.expectStatus().isOk();

			var todoUpdate = new EntityTodo("tarefaAtt","testar",true,LocalDate.parse("2025-10-23"));
			webTestClient
			.put()
			.uri("/todo/{id}",1)
			.bodyValue(todoUpdate)
			.exchange()
			.expectStatus().isOk()
			.expectBody()
			.jsonPath("$").isArray() 
			.jsonPath("$[0].titulo").isEqualTo(todoUpdate.getTitulo())
			.jsonPath("$[0].descricao").isEqualTo(todoUpdate.getDescricao())
			.jsonPath("$[0].realizado").isEqualTo(todoUpdate.getRealizado())
			.jsonPath("$[0]data").isEqualTo(todoUpdate.getData().toString());
		}

		@Test
		void testUpdateTodoFailure(){

			var todo = new EntityTodo("Atividade teste", "descrução", false, LocalDate.parse("2024-05-09"));
			webTestClient
			.post()
			.uri("/todo")
			.bodyValue(todo)
			.exchange()
			.expectStatus().isOk();

			var todoUpdate = new EntityTodo("","",true,LocalDate.parse("2025-10-23"));
			webTestClient
			.put()
			.uri("/todo/{id}",1)
			.bodyValue(todoUpdate)
			.exchange()
			.expectStatus().isBadRequest();
		}

		@Test
		void testDeleteTodoSuccess01(){
			var todo = new EntityTodo("Atividade teste", "descrução", false, LocalDate.parse("2024-05-09"));
			
			webTestClient
			.delete()
			.uri("/todo/{id}", 1)
			.exchange()
			.expectStatus().isOk();
		}

		@Test
		void testDeleteTodoSuccess02(){
			var todo = new EntityTodo("Atividade teste", "descrução", false, LocalDate.parse("2024-05-09"));
			
			webTestClient
			.delete()
			.uri("/todo/{id}", "1")
			.exchange()
			.expectStatus().isOk();
		}

		@Test
		void testDeleteTodoFailure(){
			var todo = new EntityTodo("Atividade teste", "descrução", false, LocalDate.parse("2024-05-09"));

			webTestClient
			.delete()
			.uri("todo/{id}","abc")
			.exchange()
			.expectStatus().isBadRequest();
		}
	}

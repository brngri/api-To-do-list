package com.negri.bruno.todolist.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "lista")
@Getter
@Setter
public class EntityTodo {
    
    // Construtor padrão (obrigatório para o Jackson)
    public EntityTodo() {
    }

    // Construtor com argumentos (opcional, mas útil)
    public EntityTodo(String titulo, String descricao, boolean realizado, LocalDate data) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.realizado = realizado;
        this.data = data;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private boolean realizado;
    private LocalDate data;
}

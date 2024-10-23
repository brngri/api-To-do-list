package com.negri.bruno.todolist.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.GenerationType;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class EntityTodo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String titulo;
    private String descricao;
    @Column(nullable = false)
    private boolean realizado;
    private String data;
}

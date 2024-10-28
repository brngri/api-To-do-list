package com.negri.bruno.todolist.controller;

import java.util.List;


import org.springframework.web.bind.annotation.RestController;

import com.negri.bruno.todolist.entity.EntityTodo;
import com.negri.bruno.todolist.service.ServiceTodo;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/todo")

public class ControllerTodo {

    private ServiceTodo serviceTodo;

    public ControllerTodo(ServiceTodo serviceTodo){
        this.serviceTodo = serviceTodo;

    }

    @PostMapping
    List<EntityTodo> create(@RequestBody @Valid EntityTodo todo){
        return serviceTodo.create(todo);
    }

    @GetMapping
    List<EntityTodo> list(){
        return serviceTodo.list();
    }

    @PutMapping("{id}")
    List<EntityTodo> update(@PathVariable Long id,@RequestBody @Valid EntityTodo todo){
        todo.setId(id);
        return serviceTodo.update(todo);
    }


    @DeleteMapping("{id}")
    List<EntityTodo> delete(@PathVariable Long id){
        return serviceTodo.delete(id);
    }
}

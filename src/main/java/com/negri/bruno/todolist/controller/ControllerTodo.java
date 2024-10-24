package com.negri.bruno.todolist.controller;

import java.util.List;


import org.springframework.web.bind.annotation.RestController;

import com.negri.bruno.todolist.entity.EntityTodo;
import com.negri.bruno.todolist.service.ServiceTodo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/todo")

public class ControllerTodo {

    private final ServiceTodo serviceTodo;

    public ControllerTodo(ServiceTodo serviceTodo){
        this.serviceTodo = serviceTodo;

    }

    @PostMapping
    public List<EntityTodo> create(EntityTodo todo){
        return serviceTodo.create(todo);
    }

    @GetMapping
    public List<EntityTodo> list(){
        return serviceTodo.list();
    }

    @PutMapping
    public List<EntityTodo> update(EntityTodo todo){
        return serviceTodo.update(todo);
    }


    @DeleteMapping("{id}")
    public List<EntityTodo> delete(@PathVariable Long id){
        return serviceTodo.delete(id);
    }
}

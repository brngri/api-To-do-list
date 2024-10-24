package com.negri.bruno.todolist.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.negri.bruno.todolist.entity.EntityTodo;
import com.negri.bruno.todolist.repository.RepositoryTodo;

@Service
public class ServiceTodo {

    public final RepositoryTodo repositoryTodo;

    public ServiceTodo(RepositoryTodo repositoryTodo){
        this.repositoryTodo = repositoryTodo;
    }
    
    public List<EntityTodo> create(EntityTodo todo){
        repositoryTodo.save(todo);
        return list();
    }

    public List<EntityTodo> update(EntityTodo todo){
        repositoryTodo.save(todo);
        return list();
    }

    public List<EntityTodo> list(){
        Sort sort = Sort.by("Date").descending();
        return repositoryTodo.findAll(sort);
    }

    public List<EntityTodo> delete(Long id){
        repositoryTodo.deleteById(id);
        return list();
    }


}

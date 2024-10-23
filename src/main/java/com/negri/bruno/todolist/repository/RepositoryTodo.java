package com.negri.bruno.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.negri.bruno.todolist.entity.EntityTodo;

public interface RepositoryTodo extends JpaRepository<EntityTodo, Long>{
    
}

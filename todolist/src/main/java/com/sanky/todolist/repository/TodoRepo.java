package com.sanky.todolist.repository;

import com.sanky.todolist.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepo extends JpaRepository<Todo,Integer> {

}

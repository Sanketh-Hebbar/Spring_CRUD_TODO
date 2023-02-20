package com.sanky.todolist.service;

import com.sanky.todolist.model.Todo;
import com.sanky.todolist.repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service             //spring bean
public class TodoService {
    @Autowired
    private TodoRepo repository;

    public Todo saveTodo(Todo todo){
        return repository.save(todo);
    }

    public List<Todo> saveManyTodo(List<Todo> todos){
        return repository.saveAll(todos);
    }

    public List<Todo> getTodos(){
        return repository.findAll();
    }

    public Todo getTodoById(int id){
        return repository.findById(id).orElse(null);
    }

   public String removeFromList(int id){
        repository.deleteById(id);
        return "Item:"+id+" removed";
   }

   public Todo updateTodo(Todo todo){
        Todo existingTodo=repository.findById(todo.getId()).orElse(null);
        existingTodo.setTitle(todo.getTitle());
        existingTodo.setDone(todo.isDone());
        return repository.save(existingTodo);
   }

//    public Todo updateTodo(Todo todo,int id){
//        Todo existingTodo=repository.findById(id).orElse(null);
//        existingTodo.setTitle(todo.getTitle());
//        existingTodo.setDone(todo.isDone());
//        return repository.save(existingTodo);
//    }



}

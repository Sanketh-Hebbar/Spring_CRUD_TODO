package com.sanky.todolist.controller;

import com.sanky.todolist.model.Todo;
import com.sanky.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/Todo")
public class TodoController {
    @Autowired          //used to inject class dependencies automatically

    private TodoService service;
    @PostMapping("/add")
    public Todo addTodo(@RequestBody Todo todo){
        return service.saveTodo(todo);
    }
    @PostMapping("/addmany")
    public List<Todo> addManyTodo(@RequestBody List<Todo> todoList){
        return service.saveManyTodo(todoList);
    }
    @GetMapping("/getAll")
    public List<Todo> getAll(){
        return service.getTodos();
    }
    @GetMapping("/getByID/{id}")
    public Todo getByID(@PathVariable int id){
        return service.getTodoById(id);
    }

    @DeleteMapping("/remove/{id}")
    public String remove(@PathVariable int id){
        return service.removeFromList(id);
    }

    @PutMapping("/Update")
    public Todo update(@RequestBody Todo todo){
        return service.updateTodo(todo);
    }


//    @PutMapping("/Update/{id}")
//    public Todo update(@RequestBody Todo todo,@PathVariable int id){
//        return service.updateTodo(todo,id);
//    }







}

package com.gmdt.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gmdt.todo.exception.TodoNotFoundException;
import com.gmdt.todo.model.Todo;
import com.gmdt.todo.repository.ITodoRepository;
import com.gmdt.todo.validator.ITodoValidator;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping(path = "/api/todos")
public class TodoController {

    @Autowired
    private ITodoRepository repository;

    @Autowired
    private ITodoValidator validator;

   

    @GetMapping
    @Operation(summary = "Get all todos", description = "Returns a list of all todo items.")
    public List<Todo> getAll(){
        return repository.findAll();
    }

    @GetMapping("{id}")
    @Operation(summary = "Get a todo by ID", description = "Returns the todo item with the specified ID.")
    public Todo getById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new TodoNotFoundException(id));
    }

    @PostMapping
    @Operation(summary = "Create a new todo", description = "Creates a new todo item with the given details.")
    public Todo create(@RequestBody Todo entity) {
        validator.validate((entity));
        return repository.save(entity);
    }
    
    @PutMapping("{id}")
    @Operation(summary = "Update a todo", description = "Updates an existing todo item with the specified ID.")
    public Todo update(@PathVariable long id, @RequestBody Todo entity) {
        validator.validate(entity);
        var todo = getById(id);
        todo.setTitle(entity.getTitle());
        todo.setDescription(entity.getDescription());
        todo.setComplete(entity.getComplete());
        repository.save(todo);
        return todo;
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Delete a todo", description = "Deletes the todo item with the specified ID.")
    public void delete(@PathVariable Long id){
        repository.deleteById(id);
    }

}

package com.gmdt.todo.exception;

public class TodoNotFoundException extends RuntimeException {
    public TodoNotFoundException(Long id){
        super("Todo with %s does not exist".formatted(id));
    }
}

package com.gmdt.todo.exception;

public class TodoBadRequestException  extends RuntimeException {
    public TodoBadRequestException(String message){
        super(message);
    }
}

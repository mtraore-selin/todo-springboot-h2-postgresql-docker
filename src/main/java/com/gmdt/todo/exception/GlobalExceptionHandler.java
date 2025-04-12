package com.gmdt.todo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gmdt.todo.model.ApiError;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ApiError> handlerException(Exception exception){
        return new ResponseEntity<>(new ApiError(exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = TodoBadRequestException.class)
    public ResponseEntity<ApiError> handlerException(TodoBadRequestException exception){
        return new ResponseEntity<>(new ApiError(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = TodoNotFoundException.class)
    public ResponseEntity<ApiError> handlerException(TodoNotFoundException exception){
        return new ResponseEntity<>(new ApiError(exception.getMessage()), HttpStatus.NOT_FOUND);
    }

}

package com.gmdt.todo.validator;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.gmdt.todo.exception.TodoBadRequestException;
import com.gmdt.todo.model.Todo;

import utils.Stringutils;

@Service
public class TodoValidator implements ITodoValidator {
    @Override
    public void validate(Todo todo){
        if(Stringutils.isBlank(todo.getTitle())){
            throw new TodoBadRequestException("title is mandatory");
        }
          if(Stringutils.isBlank(todo.getDescription())){
            throw new TodoBadRequestException("description is mandatory");
        }
          if(Objects.isNull(todo.getComplete())){
            throw new TodoBadRequestException("complete is mandatory");
        }
    }
}

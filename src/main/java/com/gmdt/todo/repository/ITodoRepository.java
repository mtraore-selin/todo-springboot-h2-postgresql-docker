package com.gmdt.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gmdt.todo.model.Todo;

@Repository
public interface ITodoRepository extends JpaRepository<Todo, Long> {

}

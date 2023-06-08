package com.example.demo.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Todo;
import com.example.demo.service.TodoService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/todos")
@AllArgsConstructor

public class TodoController {
	
	private final TodoService toDoService;

	@PostMapping
	public ResponseEntity<Todo> createTODo(@RequestBody Todo toDo) {
		return ResponseEntity.status(HttpStatus.CREATED).body(toDoService.createToDo(toDo));
	}

	@GetMapping
	public ResponseEntity<Iterable<Todo>> getAllToDos() {
		return ResponseEntity.status(HttpStatus.OK).body(toDoService.fetchAllToDos());
	}
	
	@PutMapping("{toDoId}")
	public ResponseEntity<Todo> updatTodoById(@PathVariable("toDoId") Integer id, @RequestBody Todo toDo) {
		return ResponseEntity.status(HttpStatus.OK).body(toDoService.updateByIdTodo(id, toDo));
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteTodoById(@PathVariable Integer id) {
		 toDoService.deleteTodoById(id);
	}
}

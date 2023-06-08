package com.example.demo.service;

import java.util.Optional;

import com.example.demo.model.Todo;

public interface TodoService {
	
	public Todo createToDo(Todo toDo);
	
	public  Iterable<Todo> fetchAllToDos();
	
	public Todo updateByIdTodo(int id, Todo Todo);
	public void deleteTodoById(int id);

}

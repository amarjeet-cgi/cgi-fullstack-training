package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Todo;
import com.example.demo.repository.TodoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {
	
	private final TodoRepository todoRepository;

	@Override
	public Todo createToDo(Todo todo) {
		// TODO Auto-generated method stub
		return todoRepository.save(todo);
	}

	@Override
	public Iterable<Todo> fetchAllToDos() {
		// TODO Auto-generated method stub
		return todoRepository.findAll();
	}

	@Override
	public Optional<Todo> updateByIdTodo(int id, Todo todo) {
		Todo value = null;
		// TODO Auto-generated method stub
		Optional<Todo> todos = todoRepository.findById(id);
		
		if (todos.get().getToDoId() == id) {
			todos.get().setToDoName(todo.getToDoName());
			todos.get().setIsCompleted(todo.getIsCompleted());
			
			
			
			  return todos;
		}
		else {
			return null;
		}
	
	}

}

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
	public Todo updateByIdTodo(int id, Todo Todo) {
		// TODO Auto-generated method stub
		Optional<Todo> todoFromDb = todoRepository.findById(id);

		 

        if (todoFromDb.isPresent()) {

            Todo t = todoFromDb.get();

            t.setToDoName(Todo.getToDoName());

            t.setIsCompleted(Todo.getIsCompleted());

            return todoRepository.save(t);

        } else

            return null;

    
	}
	
	public void deleteTodoById(int id) {
		todoRepository.deleteById(id);
	}
}

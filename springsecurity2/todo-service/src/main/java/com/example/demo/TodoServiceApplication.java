package com.example.demo;

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.TodoRepository;
import com.example.demo.model.Completed;
import com.example.demo.model.Todo;
import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class TodoServiceApplication implements CommandLineRunner {
	private TodoRepository todoRepository;

	public static void main(String[] args) {
		SpringApplication.run(TodoServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		todoRepository.save(new Todo(1, "Compile", Completed.YES));
//		toDoRepository.save(new Todo(1, "Compile", Completed.YES));
		todoRepository.save(new Todo(2, "Test", Completed.NO));
		todoRepository.save(new Todo(3, "CDeploy", Completed.NO));

	}
}

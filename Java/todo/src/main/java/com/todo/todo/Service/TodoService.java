package com.todo.todo.Service;

import com.todo.todo.Model.Todo;
import com.todo.todo.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    TodoRepository todoRepository;

    public Todo createTodo (Todo todo) {
        return todoRepository.save(todo);
    }

    public Optional<Todo> getTodo (Long id) {
        return todoRepository.findById(id);
    }

    public List<Todo> getAllTodo() {
        return (List<Todo>) todoRepository.findAll();
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

    public Todo updateTodo (Todo todo) {
        return todoRepository.save(todo);
    }
}

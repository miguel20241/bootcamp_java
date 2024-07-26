package com.todo.todo.Service;

import com.todo.todo.Model.Todo;
import com.todo.todo.Repository.TodoRepository;
import com.todo.todo.dto.TodoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    @Autowired
    TodoRepository todoRepository;

    public Todo createTodo (Todo todo) {
        return todoRepository.save(todo);
    }

    public TodoDTO getTodo (Long id) {
        Todo todo = todoRepository.findById(id).orElse(null);

        if (todo != null) {
            return new TodoDTO(todo);
        }
        return null;
    }

    public List<TodoDTO> getAllTodo() {
        List<Todo> todoList = todoRepository.findAll();

        List<TodoDTO> todoDTOList = new ArrayList<>();;

        for (Todo todo : todoList) {
            TodoDTO todoDTO = new TodoDTO(todo);
            todoDTOList.add(todoDTO);
        }

        return todoDTOList;
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

    public Todo updateTodo (Todo todo) {
        return todoRepository.save(todo);
    }
}

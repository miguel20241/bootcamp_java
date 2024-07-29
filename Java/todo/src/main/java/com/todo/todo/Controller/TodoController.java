package com.todo.todo.Controller;

import com.todo.todo.Model.Todo;
import com.todo.todo.Service.TodoService;
import com.todo.todo.dto.TodoDTO;
import com.todo.todo.dto.TodoUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api")
public class TodoController {
    @Autowired
    TodoService todoService;

    @PostMapping("/todo")
    public ResponseEntity<Todo> postTodo(@RequestBody Todo todo) {
        Todo newTodo = todoService.createTodo(todo);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newTodo.getId())
                .toUri();
       return ResponseEntity.status(CREATED).header(HttpHeaders.LOCATION, String.valueOf(location)).body(newTodo);
    }

    @GetMapping("/todo/{id}")
    public ResponseEntity<?> getTodo(@PathVariable Long id) {
        TodoDTO todoDTO = todoService.getTodo(id);

        if (todoDTO == null) {
            return ResponseEntity.status(NO_CONTENT).body(null);
        }
        return ResponseEntity.status(OK).body(todoDTO);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllTodo() {
        List<TodoDTO> todoDTOList = todoService.getAllTodo();

        if (todoDTOList == null) {
            return ResponseEntity.status(NO_CONTENT).body(null);
        }
        return ResponseEntity.status(OK).body(todoDTOList);
    }


    @DeleteMapping("/todo/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable("id") Long id) {
        todoService.deleteTodo(id);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/todo/{id}")
    public ResponseEntity<Todo> postTodo(@PathVariable Long id, @RequestBody TodoUpdateDto todo) {
        Todo newTodo = todoService.updateTodo(id, todo);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newTodo.getId())
                .toUri();
        return ResponseEntity.status(CREATED).header(HttpHeaders.LOCATION, String.valueOf(location)).body(newTodo);
    }
}

package com.todo.todo.Controller;

import com.todo.todo.Model.Todo;
import com.todo.todo.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.RequestPath;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.ServerResponse;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

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

    @GetMapping("/todo")
    public ResponseEntity<Optional<Todo>> getTodo(@RequestParam Long id) {
        return ResponseEntity.status(OK).body(todoService.getTodo(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<Todo>> getAllTodo() {
        return ResponseEntity.status(OK).body(todoService.getAllTodo());
        //return todoService.getAllTodo();
    }

    //Delete con pathVariable
    /*@DeleteMapping("/todo/{id}")
    public void deleteTodo(@PathVariable("id") Long id) {
        todoService.deleteTodo(id);
    }*/

    // Delete con requestParam
    @DeleteMapping("/todo")
    public ResponseEntity<?> deleteTodo(@RequestParam Long id) {
        todoService.deleteTodo(id);

        return ResponseEntity.noContent().build();
    }
}

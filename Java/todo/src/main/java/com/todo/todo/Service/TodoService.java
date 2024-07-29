package com.todo.todo.Service;

import com.todo.todo.Model.Todo;
import com.todo.todo.Model.User;
import com.todo.todo.Repository.TodoRepository;
import com.todo.todo.dto.TodoDTO;
import com.todo.todo.dto.TodoUpdateDto;
import com.todo.todo.dto.UserUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        List<TodoDTO> todoDTOList = new ArrayList<>();

        for (Todo todo : todoList) {
            TodoDTO todoDTO = new TodoDTO(todo);
            todoDTOList.add(todoDTO);
        }

        return todoDTOList;
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

    public Todo updateTodo (Long id, TodoUpdateDto todoUpdateDto) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);

        if (optionalTodo.isPresent()) {
            Todo todoDB = optionalTodo.get();
            // Reflejar y actualizar campos
            Field[] fields = TodoUpdateDto.class.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Object newValueFromPost = ReflectionUtils.getField(field, todoUpdateDto);
                if (newValueFromPost != null) {
                    Field userFieldName = ReflectionUtils.findField(Todo.class, field.getName());
                    if (userFieldName != null) {
                        userFieldName.setAccessible(true);
                        ReflectionUtils.setField(userFieldName, todoDB, newValueFromPost);
                    }
                }
            }

            return todoRepository.save(todoDB);
        } else {
            throw new RuntimeException("ToDo no encontrado");
        }
    }
}

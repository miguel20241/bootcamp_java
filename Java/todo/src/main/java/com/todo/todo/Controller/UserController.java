package com.todo.todo.Controller;

import com.todo.todo.Model.User;
import com.todo.todo.Service.UserService;
import com.todo.todo.dto.UserDTO;
import com.todo.todo.dto.UserUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/user")
    public ResponseEntity<User> postUser(@RequestBody User user) {
        User newUser = userService.createUser(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newUser.getId())
                .toUri();
        return ResponseEntity.status(CREATED).header(HttpHeaders.LOCATION, String.valueOf(location)).body(newUser);

    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        UserDTO userDTO = userService.getUser(id);
        if (userDTO == null) {
            return ResponseEntity.status(NO_CONTENT).body(null);
        }
        return ResponseEntity.status(OK).body(userDTO);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable Long id) {
        userService.deleteUser(id);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/user/{id}")
    public ResponseEntity<User> putUser(@PathVariable Long id, @RequestBody UserUpdateDto user) {
        User updateUser = userService.updateUser(id, user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .buildAndExpand(updateUser.getId())
                .toUri();
        return ResponseEntity.status(CREATED).header(HttpHeaders.LOCATION, String.valueOf(location)).body(updateUser);
    }
}

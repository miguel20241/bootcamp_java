package com.todo.todo.dto;

import com.todo.todo.Model.Todo;
import com.todo.todo.Model.User;

public class TodoDTO {
    private long id;
    private String task;
    private User user;
    private boolean isDone;

    public TodoDTO() {
    }

    public TodoDTO(Todo todo) {
        this.id = todo.getId();
        this.task = todo.getTask();
        this.user = todo.getUser();
        this.isDone = todo.isDone();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTask() {

        return "Tarea: " + task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}

package com.todo.todo.dto;

import com.todo.todo.Model.Todo;

public class TodoDTO {
    private long id;
    private String task;
    private String user;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}

package com.todo.todo.dto;

import com.todo.todo.Model.User;

public class TodoUpdateDto {
    private String task;
    private User user;
    private boolean isDone;

    public String getTask() {
        return task;
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

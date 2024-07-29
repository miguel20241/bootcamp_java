package com.todo.todo.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String task;

    @ManyToOne()
    @JoinColumn(name="user_id")
    @JsonIgnoreProperties("todo")
    private User user;
    private boolean isDone;

    public Todo() {}

    public Todo(long id, String task, boolean isDone, User user) {
        this.id = id;
        this.task = task;
        this.isDone = isDone;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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


    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", task='" + task + '\'' +
                ", user='" + user + '\'' +
                ", isDone=" + isDone +
                '}';
    }
}

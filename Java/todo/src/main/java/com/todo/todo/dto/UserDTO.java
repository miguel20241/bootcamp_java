package com.todo.todo.dto;

import com.todo.todo.Model.Todo;
import com.todo.todo.Model.User;
import java.time.LocalDate;
import java.util.List;

public class UserDTO {
    private Long id;
    private String userName;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private String password;
    private List<Todo> todo;


    public UserDTO() {
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.userName = user.getUserName();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.birthDate = user.getBirthDate();
        this.password = user.getPassword();
        this.todo = user.getTodo();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getBirthDate() {
        LocalDate today = LocalDate.now();
        int todayDay = today.getDayOfMonth();
        int todayMonth = today.getMonthValue();
        int birthDateDay = birthDate.getDayOfMonth();
        int birthDateMonth = birthDate.getMonthValue();

        int age = today.getYear() - birthDate.getYear();

        if (todayMonth < birthDateMonth) {
            age --;
        } else if (todayMonth == birthDateMonth && todayDay < birthDateDay) {
            age --;
        }

        return age;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<Todo> getTodo() {
        return todo;
    }

    public void setTodo(List<Todo> todo) {
        this.todo = todo;
    }

    public String getPassword() {
        return "*******";
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

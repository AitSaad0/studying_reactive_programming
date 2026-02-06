package com.example.demo.entity;

public class User {

    public User(String id) {
        this.id = id;
    }
    private String id;
    private String name;
    private int age;


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
}

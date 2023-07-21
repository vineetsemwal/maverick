package com.example.demo;

import java.util.Objects;

public class AppUser {

    private int id;
    private String name;
    private int age;
    private String password;

    public AppUser(){

    }
    public AppUser(int id, String name,String password, int age){
        setId(id);
        setName(name);
        setPassword(password);
        setAge(age);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return id == appUser.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

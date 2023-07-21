package com.example.demo;

public class User {
    private int counter=0;
    private String username;
    public int getCounter() {
        return counter;
    }
    public void setCounter(int counter) {
        this.counter = counter;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "counter=" + counter +
                ", username='" + username + '\'' +
                '}';
    }
}

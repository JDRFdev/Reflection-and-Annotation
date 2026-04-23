package com.mini.test;

public class Person {
        private String name;
        private int old;
        private String email;

    public Person(String name, int old, String email) {
        this.name = name;
        this.old = old;
        this.email = email;
    }

    public Person() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOld(int old) {
        this.old = old;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public int getOld() {
        return old;
    }

    public String getEmail() {
        return email;
    }
}

package com.JDRFdev;

public class Restaurant {
    private String name;
    @Inyect
    private Chef chef;

    public Chef getChef() {
        return chef;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.JDRFdev;

@Component_
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
    public void serv(){
        System.out.println("The Chef is cooking with the oven, that meal smells delicious :))");
    }
    public void setName(String name) {
        this.name = name;
    }
}

package com.JDRFdev;

@Component_
public class Oven {
    @Value("oven.name")
    private String mark;

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }
}

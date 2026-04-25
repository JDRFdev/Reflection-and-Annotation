package com.JDRFdev;

@Component_
public class Chef {
    private String name;
    @Inyect
    private Oven ovn;

    public Oven getOvn() {
        return ovn;
    }

    public void setOvn(Oven ovn) {
        this.ovn = ovn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

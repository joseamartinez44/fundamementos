package com.sm.fundamentos.bean;

public class MyBeanWithPropertiesImplement implements MyBeanWithProperties {
    private final String name;
    private final String lastname;

    public MyBeanWithPropertiesImplement(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    @Override
    public void function() {
        System.out.println(name + " " + lastname);
    }
}

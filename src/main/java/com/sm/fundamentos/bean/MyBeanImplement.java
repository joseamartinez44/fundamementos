package com.sm.fundamentos.bean;

public class MyBeanImplement implements MyBean {
    @Override
    public void print() {
        System.out.println("Hola desde mi propia implementación de Bean");
    }
}

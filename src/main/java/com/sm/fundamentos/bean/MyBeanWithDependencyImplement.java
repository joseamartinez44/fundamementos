package com.sm.fundamentos.bean;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency {
    private final MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printBeanWithDependency() {
        var numero = 1;
        System.out.println(myOperation.sum(numero));
        System.out.println("Hola desde la implementación de un Bean con dependencia");
    }
}

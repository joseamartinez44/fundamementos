package com.sm.fundamentos.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency {
    Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);
    private final MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printBeanWithDependency() {
        LOGGER.info("Hemos ingresado al método printWithDependency");
        var numero = 1;
        LOGGER.debug("El número enviado a la función es : " + numero);
        System.out.println(myOperation.sum(numero));
        System.out.println("Hola desde la implementación de un Bean con dependencia");
    }
}

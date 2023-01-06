package com.sm.fundamentos.configuration;

import com.sm.fundamentos.bean.MyBean;
import com.sm.fundamentos.bean.MyBeanImplementTwo;
import com.sm.fundamentos.bean.MyBeanWithDependency;
import com.sm.fundamentos.bean.MyBeanWithDependencyImplement;
import com.sm.fundamentos.bean.MyOperation;
import com.sm.fundamentos.bean.MyOperationImplement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {
    @Bean
    public MyBean beanBean() {
//        Para implementar otra clase, basta cambiar el nombre de la clase a instanciar y ya no se cambia nada en la clase principal de main
//        return new MyBeanImplement();
        return new MyBeanImplementTwo();
    }

    @Bean
    public MyOperation beanOperation() {
        return new MyOperationImplement();
    }

    @Bean
    public MyBeanWithDependency beanWithDependency(MyOperation myOperation) {
        return new MyBeanWithDependencyImplement(myOperation);
    }
}

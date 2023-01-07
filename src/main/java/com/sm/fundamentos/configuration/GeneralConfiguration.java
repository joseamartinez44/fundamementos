package com.sm.fundamentos.configuration;

import com.sm.fundamentos.bean.MyBeanWithPropertiesImplement;
import com.sm.fundamentos.bean.MyBeanWithProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// https://tuhrig.de/using-configurationproperties-to-separate-service-and-configuration/

@Configuration
public class GeneralConfiguration {
    @Value("${value.name}")
    private String name;

    @Value("${value.lastname}")
    private String lastname;

    @Value("${value.random}")
    private String random;

    @Bean
    public MyBeanWithProperties beanWithProperties() {
        return new MyBeanWithPropertiesImplement(name, lastname);
    };
}

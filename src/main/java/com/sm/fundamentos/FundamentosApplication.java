package com.sm.fundamentos;

import com.sm.fundamentos.bean.MyBean;
import com.sm.fundamentos.bean.MyBeanWithDependency;
import com.sm.fundamentos.bean.MyBeanWithProperties;
import com.sm.fundamentos.component.ComponentDependency;
import com.sm.fundamentos.pojo.UserPojo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

    private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

    //	La variable es una interfaz y no una clase concreta y no se pone @Autowired porque la inyección se hace en el constructor
    private final ComponentDependency componentDependency;
    private final MyBean myBean;
    private final MyBeanWithDependency myBeanWithDependency;
    private final MyBeanWithProperties myBeanWithProperties;
    private final UserPojo userPojo;

    //	Si dos componentes implementan la misma dependencia, hay que poner la anotación Qualifier con el nombre del componente empezando en minúscula
    //	Se inyecta la dependencia en el constructor
    public FundamentosApplication(
            @Qualifier("componentImplementTwo") ComponentDependency componentDependency,
            MyBean myBean,
            MyBeanWithDependency myBeanWithDependency,
            MyBeanWithProperties myBeanWithProperties,
            UserPojo userPojo) {
        this.componentDependency = componentDependency;
        this.myBean = myBean;
        this.myBeanWithDependency = myBeanWithDependency;
        this.myBeanWithProperties = myBeanWithProperties;
        this.userPojo = userPojo;
    }

    public static void main(String[] args) {
        SpringApplication.run(FundamentosApplication.class, args);
    }

    @Override
    public void run(String... args) {
        componentDependency.saludar();
        myBean.print();
        myBeanWithDependency.printBeanWithDependency();
        myBeanWithProperties.function();
        System.out.println(userPojo.getEmail() + " " + userPojo.getPassword() + " " + userPojo.getAge());

        try {
            int value = 10 / 0;
            LOGGER.debug("El valor de la variable value es: " + value);
        } catch (Exception e) {
//            O usar get.stackTrace();
            LOGGER.error("Esto es un error de la aplicación: " + e.getMessage());
        }


    }
}

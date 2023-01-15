package com.sm.fundamentos;

import com.sm.fundamentos.bean.MyBean;
import com.sm.fundamentos.bean.MyBeanWithDependency;
import com.sm.fundamentos.bean.MyBeanWithProperties;
import com.sm.fundamentos.component.ComponentDependency;
import com.sm.fundamentos.entity.User;
import com.sm.fundamentos.pojo.UserPojo;
import com.sm.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

    private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);
    //	La variable es una interfaz y no una clase concreta y no se pone @Autowired porque la inyección se hace en el constructor
    private final ComponentDependency componentDependency;
    private final MyBean myBean;
    private final MyBeanWithDependency myBeanWithDependency;
    private final MyBeanWithProperties myBeanWithProperties;
    private final UserPojo userPojo;
    private final UserRepository userRepository;

    //	Si dos componentes implementan la misma dependencia, hay que poner la anotación Qualifier con el nombre del componente empezando en minúscula
    //	Se inyecta la dependencia en el constructor
    public FundamentosApplication(
            @Qualifier("componentImplementTwo") ComponentDependency componentDependency,
            MyBean myBean,
            MyBeanWithDependency myBeanWithDependency,
            MyBeanWithProperties myBeanWithProperties,
            UserPojo userPojo,
            UserRepository userRepository) {
        this.componentDependency = componentDependency;
        this.myBean = myBean;
        this.myBeanWithDependency = myBeanWithDependency;
        this.myBeanWithProperties = myBeanWithProperties;
        this.userPojo = userPojo;
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(FundamentosApplication.class, args);
    }

    @Override
    public void run(String... args) {
//        ejemplosAnteriores();
        saveUsersInDataBase();
    }

    private void saveUsersInDataBase() {
        User user1 = new User("John", "john@domain.com", LocalDate.of(2021, 3, 13));
        User user2 = new User("Marco", "marco@domain.com", LocalDate.of(2021, 12, 8));
        User user3 = new User("Daniela", "daniela@domain.com", LocalDate.of(2021, 9, 8));
        User user4 = new User("Marisol", "marisol@domain.com", LocalDate.of(2021, 6, 18));
        User user5 = new User("Karen", "karen@domain.com", LocalDate.of(2021, 1, 1));
        User user6 = new User("Carlos", "carlos@domain.com", LocalDate.of(2021, 7, 7));
        User user7 = new User("Enrique", "enrique@domain.com", LocalDate.of(2021, 11, 12));
        User user8 = new User("Luis", "luis@domain.com", LocalDate.of(2021, 2, 27));
        User user9 = new User("Paola", "paola@domain.com", LocalDate.of(2021, 4, 10));
        User user10 = new User("Carol", "carol@domain.com", LocalDate.of(2021, 7, 15));
        User user11 = new User("Denji", "denji@doamin.com", LocalDate.of(2021, 10, 13));

        List<User> list = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10);
        list.forEach(userRepository::save);
//        Otra forma de hacer lo anterior es: userRepository.saveAll(list);
    }

    private void ejemplosAnteriores() {
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

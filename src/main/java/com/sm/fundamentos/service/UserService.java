package com.sm.fundamentos.service;

import com.sm.fundamentos.entity.User;
import com.sm.fundamentos.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final Log LOG = LogFactory.getLog(UserService.class);
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    La anotación Transactional sirve para aplicar el ACID de las bases de datos (Atomicity, Consistency, Isolation and Durability), para hacer rollback y no dejar hacer commit a la base de datos
    @Transactional
    public void saveTransactional(List<User> users) {
        users.stream()
                .peek(user -> LOG.info("Usuario insertado: " + user))
                .forEach(user -> userRepository.save(user));
//               Otra forma es así: .forEach(userRepository::save);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}

package com.sm.fundamentos.configuration;

import com.sm.fundamentos.caseUses.GetUser;
import com.sm.fundamentos.caseUses.GetUserImplement;
import com.sm.fundamentos.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {
    @Bean
    GetUser getUser(UserService userService) {
        return new GetUserImplement(userService);
    }
}

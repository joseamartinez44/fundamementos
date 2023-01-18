package com.sm.fundamentos.caseUses;

import com.sm.fundamentos.entity.User;
import com.sm.fundamentos.service.UserService;

import java.util.List;

public class GetUserImplement implements GetUser {
    private final UserService userService;

    public GetUserImplement(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAll() {
        return userService.getAllUsers();
    }
}

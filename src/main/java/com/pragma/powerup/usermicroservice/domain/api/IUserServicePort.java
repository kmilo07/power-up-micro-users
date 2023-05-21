package com.pragma.powerup.usermicroservice.domain.api;

import com.pragma.powerup.usermicroservice.domain.model.User;

import java.util.Optional;

public interface IUserServicePort {
    void createUser(User user);
    void deleteUser(User user);

    Optional<String> getRoleByUserId(Long userId);
}

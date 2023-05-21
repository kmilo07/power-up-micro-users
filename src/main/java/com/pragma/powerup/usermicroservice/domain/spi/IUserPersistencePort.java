package com.pragma.powerup.usermicroservice.domain.spi;

import com.pragma.powerup.usermicroservice.domain.model.User;

import java.util.Optional;

public interface IUserPersistencePort {
    void createUser(User user);
    void deleteUser(User user);

    Optional<String> getRoleByUserId(Long userId);
}

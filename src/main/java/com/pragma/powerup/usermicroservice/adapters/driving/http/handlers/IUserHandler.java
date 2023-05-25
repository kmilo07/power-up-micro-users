package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.UserRequestDto;

import java.util.Optional;

public interface IUserHandler {
    void createUser(UserRequestDto userRequestDto);
    void deleteUser(UserRequestDto userRequestDto);
    Optional<String> getRoleByUserId(Long userId);

    Optional<Long> getUserIdByEmail(String email);
}

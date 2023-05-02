package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.EmailAlreadyExistsException;
import com.pragma.powerup.usermicroservice.domain.api.IUserServicePort;
import com.pragma.powerup.usermicroservice.domain.model.User;
import com.pragma.powerup.usermicroservice.domain.spi.IUserPersistencePort;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserUseCase implements IUserServicePort {
    private static final  String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    private final IUserPersistencePort userPersistencePort;

    public UserUseCase(IUserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public void createUser(User user) {
        if (!validateEmail(user.getEmail())){
            throw new EmailAlreadyExistsException();
        }
        userPersistencePort.createUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userPersistencePort.deleteUser(user);
    }

    private boolean validateEmail(String email) {
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }


}

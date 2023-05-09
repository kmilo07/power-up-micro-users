package com.pragma.powerup.usermicroservice.domain.usecase;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pragma.powerup.usermicroservice.configuration.Constants;
import com.pragma.powerup.usermicroservice.configuration.security.exception.TokenException;
import com.pragma.powerup.usermicroservice.domain.api.IUserServicePort;
import com.pragma.powerup.usermicroservice.domain.exceptions.BirthdateIsEmptyException;
import com.pragma.powerup.usermicroservice.domain.exceptions.UserDoesNotHavePermissionException;
import com.pragma.powerup.usermicroservice.domain.exceptions.UserIsMinorException;
import com.pragma.powerup.usermicroservice.domain.model.User;
import com.pragma.powerup.usermicroservice.domain.spi.IUserPersistencePort;

import java.time.LocalDate;
import java.time.Period;
import java.util.Base64;
import java.util.HashMap;


public class UserUseCase implements IUserServicePort {
    private final IUserPersistencePort userPersistencePort;

    public UserUseCase(IUserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public void createUser(User user, String token) {
        String role = getRole(token);
        validateBirthdate(user.getBirthdate());
        setRoleDependingOnUserRole(user,role);
        userPersistencePort.createUser(user);
    }

    private void setRoleDependingOnUserRole(User user, String role){
        switch (role) {
            case Constants.ADMIN_ROLE_NAME -> setRole(user, Constants.OWNER_ROLE_ID);
            case Constants.OWNER_ROLE_NAME -> setRole(user, Constants.EMPLOYER_ROLE_ID);
            default -> throw new UserDoesNotHavePermissionException();
        }
    }

    private void setRole(User user, Long roleId){
        user.setIdRol(roleId);
    }

    @Override
    public void deleteUser(User user) {
        userPersistencePort.deleteUser(user);
    }

    public void validateBirthdate(LocalDate birthday){
        validateBirthdateNotEmpty(birthday);
        validateUserIsOlder(birthday);
    }

    public void validateBirthdateNotEmpty(LocalDate birthday){
        if (birthday == null){
            throw new BirthdateIsEmptyException();
        }
    }

    private void validateUserIsOlder(LocalDate birthday) {
        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(birthday, currentDate);
        if (age.getYears() < 18) {
            throw new UserIsMinorException();
        }
    }

    private String getRole(String token){
        String payload = token.split("\\.")[1];
        String json = new String(Base64.getDecoder().decode(payload));
        String role;
        ObjectMapper mapper = new ObjectMapper();
        try {
            role = mapper.readValue(json, HashMap.class).get("roles").toString();
        } catch (JsonProcessingException e) {
            throw new TokenException();
        }
        return role.replace("[","").replace("]","");
    }
}

package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.configuration.Constants;
import com.pragma.powerup.usermicroservice.domain.api.IUserServicePort;
import com.pragma.powerup.usermicroservice.domain.exceptions.BirthdateIsEmptyException;
import com.pragma.powerup.usermicroservice.domain.exceptions.UserDoesNotHavePermissionException;
import com.pragma.powerup.usermicroservice.domain.exceptions.UserIsMinorException;
import com.pragma.powerup.usermicroservice.domain.model.User;
import com.pragma.powerup.usermicroservice.domain.spi.IUserPersistencePort;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDate;
import java.time.Period;


public class UserUseCase implements IUserServicePort {
    private final IUserPersistencePort userPersistencePort;

    public UserUseCase(IUserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public void createUser(User user) {
        String role = SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().findFirst().orElseThrow(UserDoesNotHavePermissionException::new).toString();
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

}

package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.domain.api.IUserServicePort;
import com.pragma.powerup.usermicroservice.domain.exceptions.BirthdateIsEmptyException;
import com.pragma.powerup.usermicroservice.domain.exceptions.UserIsMinorException;
import com.pragma.powerup.usermicroservice.domain.model.User;
import com.pragma.powerup.usermicroservice.domain.spi.IUserPersistencePort;

import java.time.LocalDate;
import java.time.Period;


public class UserUseCase implements IUserServicePort {
    private final IUserPersistencePort userPersistencePort;

    public UserUseCase(IUserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public void createUser(User user) {
        validateBirthdate(user.getBirthdate());
        userPersistencePort.createUser(user);
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

     /*TODO
3. el usuario quedara con el rol propietario.
    * */
}

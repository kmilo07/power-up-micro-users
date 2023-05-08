package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.domain.api.IUserServicePort;
import com.pragma.powerup.usermicroservice.domain.model.User;
import com.pragma.powerup.usermicroservice.domain.spi.IUserPersistencePort;


public class UserUseCase implements IUserServicePort {
    private final IUserPersistencePort userPersistencePort;

    public UserUseCase(IUserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public void createUser(User user) {
        userPersistencePort.createUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userPersistencePort.deleteUser(user);
    }

     /*TODO
    * "1. Al crear una cuenta, se deben solicitar los siguientes campos obligatorios:
Nombre, Apellido, DocumentoDeIdentidad, celular, fechaNacimiento, correo y clave(encriptada con bcrypt)
2. Se debe verificar estructura de email válida, el teléfono debe contener un máximo de 13 caracteres y puede contener el símbolo +. Ejemplo: +573005698325, El documento de identidad debe ser únicamente numérico.
3. el usuario quedara con el rol propietario.
4. El usuario debe ser mayor de edad"
    * */
}

package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.*;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IRoleRepository;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IUserRepository;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers.IUserEntityMapper;
import com.pragma.powerup.usermicroservice.domain.model.User;
import com.pragma.powerup.usermicroservice.domain.spi.IUserPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Transactional
public class UserMysqlAdapter implements IUserPersistencePort {
    private final IUserRepository userRepository;
    private final IRoleRepository roleRepository;
    private final IUserEntityMapper userEntityMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public void createUser(User user) {
        if (userRepository.findByDniNumber(user.getDniNumber()).isPresent()) {
            throw new UserAlreadyExistsException();
        }
        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new EmailAlreadyExistsException();
        }
        if(roleRepository.findById(user.getIdRol()).isEmpty()){
            throw new RoleNotFoundException();
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(userEntityMapper.toEntity(user));
    }

    @Override
    public void deleteUser(User user) {
        if (userRepository.findByDniNumber(user.getDniNumber()).isPresent()) {
            userRepository.deleteById(user.getId());
        }
        else {
            throw new UserNotFoundException();
        }
    }



}

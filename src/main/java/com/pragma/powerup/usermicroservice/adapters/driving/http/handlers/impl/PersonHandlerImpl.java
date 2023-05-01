package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.impl;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.PersonRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonHandlerImpl implements IPersonHandler {
    private final IPersonServicePort personServicePort;
    private final IPersonRequestMapper personRequestMapper;

    @Override
    public void savePerson(PersonRequestDto personRequestDto) {
        personServicePort.savePerson(personRequestMapper.toPerson(personRequestDto));
    }
}

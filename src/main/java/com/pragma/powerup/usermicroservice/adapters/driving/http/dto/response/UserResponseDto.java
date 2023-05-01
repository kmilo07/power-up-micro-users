package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class UserResponseDto {
    private String name;
    private String surname;
    private String dniNumber;
    private String phone;
    private LocalDate birthDate;
    private String email;
    private Long idRol;
}

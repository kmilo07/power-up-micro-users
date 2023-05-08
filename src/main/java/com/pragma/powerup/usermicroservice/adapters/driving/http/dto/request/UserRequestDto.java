package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request;

import com.pragma.powerup.usermicroservice.configuration.Constants;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class UserRequestDto {
    private Long id;
    @NotBlank()
    @Size(min = 3, max = 20)
    private String name;
    @NotBlank()
    @Size(min = 3, max = 20)
    private String surname;
    @NotBlank
    @Pattern(regexp = Constants.REGEX_DOCUMENT_DIGITS, message = "El número de documento que ha ingresado no es válido")
    private String dniNumber;
    @NotBlank()
    @Pattern(regexp = Constants.REGEX_PHONE, message = "El número de celular que ha ingresado no es válido")
    private String phone;
    private LocalDate birthdate;
    @NotBlank
    @Email
    private String email;
    @NotBlank()
    private String password;
    private Long idRol;
}

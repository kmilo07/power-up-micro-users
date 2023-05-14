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
    @NotBlank(message = Constants.MANDATORY_NAME)
    @Size(min = 3, max = 20, message = Constants.NAME_IS_INVALID)
    private String name;
    @NotBlank(message = Constants.MANDATORY_SURNAME)
    @Size(min = 3, max = 20, message = Constants.SURNAME_IS_INVALID)
    private String surname;
    @NotBlank(message = Constants.MANDATORY_DOCUMENT)
    @Pattern(regexp = Constants.REGEX_DOCUMENT_DIGITS, message = Constants.DOCUMENT_IS_INVALID)
    private String dniNumber;
    @NotBlank(message = Constants.MANDATORY_PHONE)
    @Pattern(regexp = Constants.REGEX_PHONE, message = Constants.PHONE_IS_INVALID)
    private String phone;
    private LocalDate birthdate;
    @NotBlank(message = Constants.MANDATORY_EMAIL)
    @Email(message = Constants.EMAIL_IS_INVALID)
    private String email;
    @NotBlank(message = Constants.MANDATORY_PASSWORD)
    private String password;
}

package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRequestDtoTest {

    private final String GOOD_NAME ="Camilo";
    private final String GOOD_SURNAME = "Gil";
    private final String GOOD_DOCUMENT = "12345664";
    private final String GOOD_PHONE = "3001122211";
    private final LocalDate TODAY = LocalDate.now();
    private final String GOOD_EMAIL = "milo@gmail.com";
    private final String PASSWORD = "1234";

    @Autowired
    private Validator validator;

    private UserRequestDto requestDto;

    @BeforeEach
    void setUp(){
        requestDto = new UserRequestDto(GOOD_NAME,GOOD_SURNAME, GOOD_DOCUMENT, GOOD_PHONE,TODAY,GOOD_EMAIL,PASSWORD);
    }

    @DisplayName("Valida si el campo nombre es vacío")
    @Test
    void validUserRequestDtoWithBadNameEmpty(){
        String EMPTY_NAME = "";
        requestDto = new UserRequestDto(EMPTY_NAME,GOOD_SURNAME, GOOD_DOCUMENT, GOOD_PHONE,TODAY,GOOD_EMAIL,PASSWORD);

        Set<ConstraintViolation<UserRequestDto>> violations = validator.validate(requestDto);

        assertEquals(2, violations.size());

        for (ConstraintViolation<UserRequestDto> violation : violations) {
            System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
        }
    }

    @DisplayName("Valida si el campo nombre tiene menos caracteres de los permitidos")
    @Test
    void validUserRequestDtoWithBadNameMin(){
        String BAD_NAME_MIN = "c";
        requestDto = new UserRequestDto(BAD_NAME_MIN,GOOD_SURNAME, GOOD_DOCUMENT, GOOD_PHONE,TODAY,GOOD_EMAIL,PASSWORD);

        Set<ConstraintViolation<UserRequestDto>> violations = validator.validate(requestDto);

        assertEquals(1, violations.size());

        for (ConstraintViolation<UserRequestDto> violation : violations) {
            System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
        }
    }

    @DisplayName("Valida si el campo nombre tiene más caracteres de los permitidos")
    @Test
    void validUserRequestDtoWithBadNameMax(){
        String BAD_NAME_MAX = "lkajdslkfjaskldfjlkfiqoerufnamcakdfjqeifjskajsdlfkjsdlkfjdlksjflkajklsjsdkljfklasjdfjkldsjk";
        requestDto = new UserRequestDto(BAD_NAME_MAX,GOOD_SURNAME, GOOD_DOCUMENT, GOOD_PHONE,TODAY,GOOD_EMAIL,PASSWORD);

        Set<ConstraintViolation<UserRequestDto>> violations = validator.validate(requestDto);

        assertEquals(1, violations.size());

        for (ConstraintViolation<UserRequestDto> violation : violations) {
            System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
        }
    }

    @DisplayName("Valida si el campo apellido es vacío")
    @Test
    void validUserRequestDtoWithBadSurnameEmpty(){
        String EMPTY_SURNAME = "";
        requestDto = new UserRequestDto(GOOD_NAME, EMPTY_SURNAME, GOOD_DOCUMENT, GOOD_PHONE,TODAY,GOOD_EMAIL,PASSWORD);

        Set<ConstraintViolation<UserRequestDto>> violations = validator.validate(requestDto);

        assertEquals(2, violations.size());

        for (ConstraintViolation<UserRequestDto> violation : violations) {
            System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
        }
    }

    @DisplayName("Valida si el campo apellido es menor a lo permitido")
    @Test
    void validUserRequestDtoWithBadSurnameMin(){
        String BAD_SURNAME_MIN = "G";
        requestDto = new UserRequestDto(GOOD_NAME, BAD_SURNAME_MIN, GOOD_DOCUMENT, GOOD_PHONE,TODAY,GOOD_EMAIL,PASSWORD);

        Set<ConstraintViolation<UserRequestDto>> violations = validator.validate(requestDto);

        assertEquals(1, violations.size());

        for (ConstraintViolation<UserRequestDto> violation : violations) {
            System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
        }
    }

    @DisplayName("Valida si el campo apellido es mayor a lo permitido")
    @Test
    void validUserRequestDtoWithBadSurnameMax(){
        String BAD_SURNAME_MAX = "lkajdslkfjaskldfjlkfiqoerufnamcakdfjqeifjskajsdlfkjsdlkfjdlksjflkajklsjsdkljfklasjdfjkldsjk";
        requestDto = new UserRequestDto(GOOD_NAME, BAD_SURNAME_MAX, GOOD_DOCUMENT, GOOD_PHONE,TODAY,GOOD_EMAIL,PASSWORD);

        Set<ConstraintViolation<UserRequestDto>> violations = validator.validate(requestDto);

        assertEquals(1, violations.size());

        for (ConstraintViolation<UserRequestDto> violation : violations) {
            System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
        }
    }

    @DisplayName("Valida si el campo document es vacío")
    @Test
    void validUserRequestDtoWithBadDocumentEmpty(){
        String EMPTY_DOCUMENT = "";
        requestDto = new UserRequestDto(GOOD_NAME,GOOD_SURNAME, EMPTY_DOCUMENT, GOOD_PHONE,TODAY,GOOD_EMAIL,PASSWORD);

        Set<ConstraintViolation<UserRequestDto>> violations = validator.validate(requestDto);

        assertEquals(2, violations.size());

        for (ConstraintViolation<UserRequestDto> violation : violations) {
            System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
        }
    }

    @DisplayName("Valida si el campo document es menor al permitido")
    @Test
    void validUserRequestDtoWithBadDocumentMin(){
        String BAD_DOCUMENT_MIN = "12";
        requestDto = new UserRequestDto(GOOD_NAME,GOOD_SURNAME, BAD_DOCUMENT_MIN, GOOD_PHONE,TODAY,GOOD_EMAIL,PASSWORD);

        Set<ConstraintViolation<UserRequestDto>> violations = validator.validate(requestDto);

        assertEquals(1, violations.size());

        for (ConstraintViolation<UserRequestDto> violation : violations) {
            System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
        }
    }

    @DisplayName("Valida si el campo document es mayor al permitido")
    @Test
    void validUserRequestDtoWithBadDocumentMax(){
        String BAD_DOCUMENT_MAX = "123456642341";
        requestDto = new UserRequestDto(GOOD_NAME,GOOD_SURNAME, BAD_DOCUMENT_MAX, GOOD_PHONE,TODAY,GOOD_EMAIL,PASSWORD);

        Set<ConstraintViolation<UserRequestDto>> violations = validator.validate(requestDto);

        assertEquals(1, violations.size());

        for (ConstraintViolation<UserRequestDto> violation : violations) {
            System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
        }
    }

    @DisplayName("Valida si el campo teléfono es vacío")
    @Test
    void validUserRequestDtoWithBadPhoneEmpty(){
        String EMPTY_PHONE = "";
        requestDto = new UserRequestDto(GOOD_NAME,GOOD_SURNAME, GOOD_DOCUMENT, EMPTY_PHONE,TODAY,GOOD_EMAIL,PASSWORD);

        Set<ConstraintViolation<UserRequestDto>> violations = validator.validate(requestDto);

        assertEquals(2, violations.size());

        for (ConstraintViolation<UserRequestDto> violation : violations) {
            System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
        }
    }

    @DisplayName("Valida si el campo teléfono es menor al permitido")
    @Test
    void validUserRequestDtoWithBadPhoneMin(){
        String BAD_PHONE_MIN = "30";
        requestDto = new UserRequestDto(GOOD_NAME,GOOD_SURNAME, GOOD_DOCUMENT, BAD_PHONE_MIN,TODAY,GOOD_EMAIL,PASSWORD);

        Set<ConstraintViolation<UserRequestDto>> violations = validator.validate(requestDto);

        assertEquals(1, violations.size());

        for (ConstraintViolation<UserRequestDto> violation : violations) {
            System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
        }
    }

    @DisplayName("Valida si el campo teléfono es mayor al permitido")
    @Test
    void validUserRequestDtoWithBadPhoneMax(){
        String BAD_PHONE_MAX = "300000000000000000000";
        requestDto = new UserRequestDto(GOOD_NAME,GOOD_SURNAME, GOOD_DOCUMENT, BAD_PHONE_MAX,TODAY,GOOD_EMAIL,PASSWORD);

        Set<ConstraintViolation<UserRequestDto>> violations = validator.validate(requestDto);

        assertEquals(1, violations.size());

        for (ConstraintViolation<UserRequestDto> violation : violations) {
            System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
        }
    }

    @DisplayName("Valida si el campo correo es vacío")
    @Test
    void validUserRequestDtoWithBadEmailEmpty(){
        String EMPTY_EMAIL = "";
        requestDto = new UserRequestDto(GOOD_NAME,GOOD_SURNAME, GOOD_DOCUMENT, GOOD_PHONE,TODAY, EMPTY_EMAIL,PASSWORD);

        Set<ConstraintViolation<UserRequestDto>> violations = validator.validate(requestDto);

        assertEquals(1, violations.size());

        for (ConstraintViolation<UserRequestDto> violation : violations) {
            System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
        }
    }

    @DisplayName("Valida si el campo correo es invalido")
    @Test
    void validUserRequestDtoWithBadEmail1(){
        String BAD_EMAIL1 = "milo@";
        requestDto = new UserRequestDto(GOOD_NAME,GOOD_SURNAME, GOOD_DOCUMENT, GOOD_PHONE,TODAY, BAD_EMAIL1,PASSWORD);

        Set<ConstraintViolation<UserRequestDto>> violations = validator.validate(requestDto);

        assertEquals(1, violations.size());

        for (ConstraintViolation<UserRequestDto> violation : violations) {
            System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
        }
    }

    @DisplayName("Valida si el campo correo es invalido")
    @Test
    void validUserRequestDtoWithBadEmail2(){
        String BAD_EMAIL2 = "milo@gmail.";
        requestDto = new UserRequestDto(GOOD_NAME,GOOD_SURNAME, GOOD_DOCUMENT, GOOD_PHONE,TODAY, BAD_EMAIL2,PASSWORD);

        Set<ConstraintViolation<UserRequestDto>> violations = validator.validate(requestDto);

        assertEquals(1, violations.size());

        for (ConstraintViolation<UserRequestDto> violation : violations) {
            System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
        }
    }

    @DisplayName("Valida si el campo correo es invalido")
    @Test
    void validUserRequestDtoWithPasswordEmpty(){
        String EMPTY_PASSWORD = "";
        requestDto = new UserRequestDto(GOOD_NAME,GOOD_SURNAME, GOOD_DOCUMENT, GOOD_PHONE,TODAY,GOOD_EMAIL, EMPTY_PASSWORD);

        Set<ConstraintViolation<UserRequestDto>> violations = validator.validate(requestDto);

        assertEquals(1, violations.size());

        for (ConstraintViolation<UserRequestDto> violation : violations) {
            System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
        }
    }

    @DisplayName("Todo el formulario esta bien")
    @Test
    void validUserRequestDtoGood(){
        requestDto = new UserRequestDto(GOOD_NAME,GOOD_SURNAME, GOOD_DOCUMENT, GOOD_PHONE,TODAY,GOOD_EMAIL,PASSWORD);

        Set<ConstraintViolation<UserRequestDto>> violations = validator.validate(requestDto);

        assertEquals(0, violations.size());

        for (ConstraintViolation<UserRequestDto> violation : violations) {
            System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
        }
    }

    @DisplayName("Todo el formulario esta bien con indicador")
    @Test
    void validUserRequestDtoGoodWithIndicator(){
        String GOOD_PHONE_WITH_INDICATOR = "+573001122211";
        requestDto = new UserRequestDto(GOOD_NAME,GOOD_SURNAME, GOOD_DOCUMENT, GOOD_PHONE_WITH_INDICATOR,TODAY,GOOD_EMAIL,PASSWORD);

        Set<ConstraintViolation<UserRequestDto>> violations = validator.validate(requestDto);

        assertEquals(0, violations.size());

        for (ConstraintViolation<UserRequestDto> violation : violations) {
            System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
        }
    }

    @Test
    void getName() {
        assertEquals(GOOD_NAME,requestDto.getName());
    }

    @Test
    void getSurname() {
        assertEquals(GOOD_SURNAME,requestDto.getSurname());
    }

    @Test
    void getDniNumber() {
        assertEquals(GOOD_DOCUMENT,requestDto.getDniNumber());
    }

    @Test
    void getPhone() {
        assertEquals(GOOD_PHONE,requestDto.getPhone());
    }

    @Test
    void getBirthdate() {
        assertEquals(TODAY, requestDto.getBirthdate());
    }

    @Test
    void getEmail() {
        assertEquals(GOOD_EMAIL,requestDto.getEmail());
    }

    @Test
    void getPassword() {
        assertEquals(PASSWORD, requestDto.getPassword());
    }
}
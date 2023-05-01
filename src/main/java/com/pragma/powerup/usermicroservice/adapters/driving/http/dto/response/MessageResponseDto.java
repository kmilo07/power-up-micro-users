package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response;

public class MessageResponseDto {

    String message;

    public MessageResponseDto(String mensaje) {
        this.message = mensaje;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

package com.example.newadderessbook.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressException extends RuntimeException{
    private String message;

    public AddressException(String message) {
        this.message=message;
    }
}

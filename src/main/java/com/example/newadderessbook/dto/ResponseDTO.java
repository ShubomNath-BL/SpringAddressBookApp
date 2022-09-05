package com.example.newadderessbook.dto;

import com.example.newadderessbook.entity.AddressEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
public class ResponseDTO {
    private String message;
    private Object obj;

    public ResponseDTO(String string, AddressEntity response) {
        this.message = string;
        this.obj = response;
    }

    public ResponseDTO(String string1, Optional<AddressEntity> response) {
        this.message = string1;
        this.obj = response;
    }

    public ResponseDTO(String string2, List<AddressEntity> response) {
        this.message = string2;
        this.obj = response;
    }
}

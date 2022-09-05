package com.example.newadderessbook.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@NoArgsConstructor
public class AddressDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Invalid Name")
    private String fullName;
    @Pattern(regexp = "^[1-9]{2}[0-9]{10}$", message = "Invalid Phone number")
    private String phoneNumber;
//    @NotBlank(message = "email should not be blank")
    private List<String> email;
    @NotBlank(message = "address should not be blank")
    private String address;
    @NotBlank(message = "city should not be blank")
    private String city;
    @NotBlank(message = "state should not be blank")
    private String state;
//    @Pattern(regexp = "^[0-9]{5,}$", message = "Invalid Zip Code")
    private String zipCode;
}

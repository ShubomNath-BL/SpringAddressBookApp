package com.example.newadderessbook.entity;

import com.example.newadderessbook.dto.AddressDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
    private String fullName;
    private String phoneNumber;
    private String address;

    @ElementCollection
    @CollectionTable (name = "city", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "city")
    private List<String> city;
    private String state;
    private String zipCode;

    private String email;

    public AddressEntity(AddressDTO address) {
        this.fullName = address.getFullName();
        this.phoneNumber = address.getPhoneNumber();
        this.email = address.getEmail();
        this.address = address.getAddress();
        this.city = address.getCity();
        this.state = address.getState();
        this.zipCode = address.getZipCode();
    }
}

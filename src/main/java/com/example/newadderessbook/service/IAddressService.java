package com.example.newadderessbook.service;

import com.example.newadderessbook.dto.AddressDTO;
import com.example.newadderessbook.entity.AddressEntity;

import java.util.List;
import java.util.Optional;

public interface IAddressService {
    public String welcomeMessage();

    public AddressEntity saveData(AddressDTO address);

    public Optional<AddressEntity> getById(long id);

    public List<AddressEntity> getAllData();

    public AddressEntity editData(AddressDTO address, long id);

    public AddressEntity deleteData(long id);

    public List<AddressEntity> getUserByEmail(String email);

    public String addRecord(AddressDTO adress) throws Exception;

    public List<AddressEntity> retrieveData(String token);
}

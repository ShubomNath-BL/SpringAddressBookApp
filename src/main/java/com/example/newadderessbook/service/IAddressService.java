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

    public void deleteData(long id);

    public List<AddressEntity> getUserByCity(String city);

    public String addRecord(AddressDTO adress) throws Exception;

    public List<AddressEntity> retrieveData(String token);

    public AddressEntity findByToken(String token);
}

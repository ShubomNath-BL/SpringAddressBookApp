package com.example.newadderessbook.service;

import com.example.newadderessbook.dto.AddressDTO;
import com.example.newadderessbook.entity.AddressEntity;
import com.example.newadderessbook.repo.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService implements IAddressService{

    @Autowired
    Repo repository;
    public String welcomeMessage(){
        return "Welcome to the Address book";
    }

    public AddressEntity saveData(AddressDTO address){
        AddressEntity newAddress = new AddressEntity(address);
        repository.save(newAddress);
        return newAddress;
    }

    public Optional<AddressEntity> getById(long id){
        return repository.findById(id);
    }

    public List<AddressEntity> getAllData(){
        List<AddressEntity> result = repository.findAll();
        return result;
    }

    public AddressEntity editData(AddressDTO address, long id){
        AddressEntity addressEntity = repository.findById(id).orElse(null);
        if(addressEntity != null){
            addressEntity.setFullName(address.getFullName());
            addressEntity.setPhoneNumber(address.getPhoneNumber());
            addressEntity.setAddress(address.getAddress());
            addressEntity.setCity(address.getCity());
            addressEntity.setState(address.getState());
            addressEntity.setEmail(address.getEmail());
            addressEntity.setZipCode(address.getZipCode());
            return repository.save(addressEntity);
        }
        else return null;
    }

    public AddressEntity deleteData(long id){
        repository.deleteById(id);
        return null;
    }

    public List<AddressEntity> getUserByEmail(String email){
        return repository.findByEmail(email);
    }
}

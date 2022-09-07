package com.example.newadderessbook.service;

import com.example.newadderessbook.dto.AddressDTO;
import com.example.newadderessbook.entity.AddressEntity;
import com.example.newadderessbook.exception.AddressException;
import com.example.newadderessbook.repo.Repo;
import com.example.newadderessbook.util.EmailSenderService;
import com.example.newadderessbook.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService implements IAddressService{

    @Autowired
    Repo repository;

    @Autowired
    TokenUtil tokenUtil;

    @Autowired
    EmailSenderService sender;
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

    @Override
    public void deleteData(long id){
        Optional<AddressEntity> newAddress = repository.findById(id);
        if(newAddress.isPresent()){
            repository.deleteById(id);
            sender.sendEmail(newAddress.get().getEmail(),"TestMail...!","Hello... Your data has been deleted");
        }else {
            throw new AddressException("Id not found....!");
        }
    }

    public List<AddressEntity> getUserByCity(String city){
        return repository.findByCity(city);
    }

    public String addRecord(AddressDTO adress) throws Exception{
        AddressEntity newAddress = new AddressEntity(adress);
        repository.save(newAddress);
        String token = tokenUtil.createToken(newAddress.getUserId());
        sender.sendEmail(String.valueOf(newAddress.getEmail()),"TestMail...!","Hello..."+newAddress.getFullName()+" http://localhost:8080/findByToken/"+token);

        return token;
    }

    public List<AddressEntity> retrieveData(String token){
        long id = tokenUtil.decodeToken(token);
        Optional<AddressEntity> isUserExist = repository.findById(id);
        if(isUserExist.isPresent()){
            List<AddressEntity> list = repository.findAll();
            return list;
        }
        else {
            System.out.println("Token not found");
            return null;
        }
    }

    @Override
    public AddressEntity findByToken(String token) {
        long id = tokenUtil.decodeToken(token);
        Optional<AddressEntity> addressEntity = repository.findById(id);
        if(addressEntity.isPresent()){
            return addressEntity.get();
        }else {
            throw new AddressException("Id not found");
        }
    }
}

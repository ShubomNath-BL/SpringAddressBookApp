package com.example.newadderessbook.controller;

import com.example.newadderessbook.dto.AddressDTO;
import com.example.newadderessbook.dto.ResponseDTO;
import com.example.newadderessbook.entity.AddressEntity;
import com.example.newadderessbook.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    IAddressService service;

    @GetMapping("/greet")
    public String welcome(){
        return service.welcomeMessage();
    }

    @PostMapping("/insert")
    public ResponseEntity<ResponseDTO> insertUser(@Valid @RequestBody AddressDTO address){
        AddressEntity response = service.saveData(address);
        ResponseDTO responseDTO = new ResponseDTO("Data inserted successfully", response);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ResponseDTO> getUserById(@PathVariable long id){
        Optional<AddressEntity> response = service.getById(id);
        ResponseDTO responseDTO = new ResponseDTO("User related to id are ", response);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<ResponseDTO> getAllUser(){
        List<AddressEntity> response = service.getAllData();
        ResponseDTO responseDTO = new ResponseDTO("List of all user: ", response);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<ResponseDTO> updateUser(@RequestBody AddressDTO address, @PathVariable long id){
        AddressEntity addressData = service.editData(address, id);
        ResponseDTO responseDTO = new ResponseDTO("Edit user data: ", addressData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public AddressEntity deleteUserData(@PathVariable long id){
        return service.deleteData(id);
    }

    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<ResponseDTO> getUserByEmail(@PathVariable String email){
        List<AddressEntity> addressList = service.getUserByEmail(email);
        ResponseDTO responseDTO = new ResponseDTO("User details with given email id is: ", addressList);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
}

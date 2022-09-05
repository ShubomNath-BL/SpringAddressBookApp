package com.example.newadderessbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NewAdderessBookApplication {

    public static void main(String[] args) {

        System.out.println("Welcome to the Address Book");
        SpringApplication.run(NewAdderessBookApplication.class, args);

    }

}

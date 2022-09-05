package com.example.newadderessbook;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class NewAdderessBookApplication {

    public static void main(String[] args) {

        SpringApplication.run(NewAdderessBookApplication.class, args);
        System.out.println("Welcome to the Address Book");
        System.out.println("---------------------------------------");
        log.info("Hello dear logger........!");
    }

}

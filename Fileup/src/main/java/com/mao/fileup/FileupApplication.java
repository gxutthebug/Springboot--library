package com.mao.fileup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FileupApplication {

    public static void main(String[] args) {
        System.out.println("/"); //  /
        System.out.println("\\"); //  \
        System.out.println("//"); // //
        SpringApplication.run(FileupApplication.class, args);
    }

}

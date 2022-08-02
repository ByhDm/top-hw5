package com.example.tophw5.entity;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Restaurant {
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    private String description;
    private LocalDate creationDate;

//    public Restaurant(String name, String phoneNumber, String email, String description, LocalDate creationDate) {
//        this.name = name;
//        this.phoneNumber = phoneNumber;
//        this.email = email;
//        this.description = description;
//        this.creationDate = creationDate;
//    }

}

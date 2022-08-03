package com.example.tophw5.entity;

import com.example.tophw5.validation.constraint.ValidPhoneNumber;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Restaurant {

    private Long id;

    @NotBlank(message = "Заданное сообщение")
    private String name;

    @ValidPhoneNumber
    private String phoneNumber;

    private String email;
    private String description;
    private LocalDate date;

}

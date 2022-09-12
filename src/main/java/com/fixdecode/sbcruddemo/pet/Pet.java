package com.fixdecode.sbcruddemo.pet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "pet")
@NoArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Every pets must have a name!")
    private String name;
    @NotBlank(message = "Every pets color must be specified!")
    private String color;

    public Pet(String name, String color) {
        this.name = name;
        this.color = color;
    }
}

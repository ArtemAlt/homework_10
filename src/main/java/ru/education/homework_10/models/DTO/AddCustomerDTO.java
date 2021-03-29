package ru.education.homework_10.models.DTO;

import lombok.Data;

@Data
public class AddCustomerDTO {

    private String name;

    private String password;

    private Long role;
}

package ru.education.homework_10.models.DTO;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartDTO {

    private Long id;

    private String customer;

    private String product;

}


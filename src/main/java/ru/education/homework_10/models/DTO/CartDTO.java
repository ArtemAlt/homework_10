package ru.education.homework_10.models.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String customer;
    @Getter
    @Setter
    private String product;


}


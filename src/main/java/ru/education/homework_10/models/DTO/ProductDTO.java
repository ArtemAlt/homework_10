package ru.education.homework_10.models.DTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO {

    private Long id;

    private String name;

    private int price;

    private String productCategory;

}

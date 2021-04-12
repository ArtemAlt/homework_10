package ru.education.homework_10.models.DTO;

import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductCategoryDTO {

    private Long id;

    private String name;

    private List<String> productList;
}

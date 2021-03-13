package ru.education.homework_10.models.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.education.homework_10.models.Entity.ProductCategory;

import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private int price;
    @Getter
    @Setter
    private String productCategory;

}

package ru.education.homework_10.models.DTO;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDTO {

    private Long id;

    private String name;

    private List<String> productList;


}

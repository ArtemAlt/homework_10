package ru.education.homework_10.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "products_category")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "productCategory")
    private List<Product> productList;

    public List<String> getProductListName() {
        return this.productList.stream().map(p -> p.getName()).collect(Collectors.toList());
    }

}

package ru.education.homework_10.models.Entity;

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
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter
    @Setter
    private Long id;
    @Column(name = "name")
    @Getter
    @Setter
    private String name;
    @OneToMany(mappedBy = "productCategory")
    @Getter
    @Setter
    private List<Product> productList;

    public List<String> getProductListName() {
        return this.productList.stream().map(p -> p.getName()).collect(Collectors.toList());//todo- это должно делаться автоматически
    }

}

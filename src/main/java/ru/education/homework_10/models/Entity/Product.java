package ru.education.homework_10.models.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "id")
    private Long id;
    @Getter
    @Setter
    @Column(name = "name")
    private String name;
    @Getter
    @Setter
    @Column(name = "price")
    private int price;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategory productCategory;
    @Getter
    @Setter
    @ManyToMany
    @JoinTable(name = "order_items",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    private List<Orders> ordersList;

    public String getProductCategoryName() {
        return this.getProductCategory().getName();//todo - мне кажется что это должно быть иначе
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                '}';
    }
}

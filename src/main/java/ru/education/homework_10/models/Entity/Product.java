package ru.education.homework_10.models.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name="id")
    private Long id;
    @Getter
    @Setter
    @Column(name="name")
    private String name;
    @Getter
    @Setter
    @Column(name="price")
    private int price;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name="category_id")
    private ProductCategory productCategory;

    public String getProductCategoryName() {
        return this.getProductCategory().getName();//todo - мне кажется что это должно быть иначе
    }
}

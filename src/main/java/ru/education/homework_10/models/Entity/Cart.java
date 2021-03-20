package ru.education.homework_10.models.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name="cart")
@AllArgsConstructor
@NoArgsConstructor

public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name="id")
    private Long id;
    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name="customer_id")
    private Customer customer;
    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name="product_id")
    private Product product;

    public String getCartCustomer(){
        return this.customer.getName();
    }
    public String getCartProduct(){
        return this.product.getName();
    }
}

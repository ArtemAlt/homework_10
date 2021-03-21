package ru.education.homework_10.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer currentCustomer;

    @ManyToMany
    @JoinTable(
            name = "order_items",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> productList;


    public Orders(List<Cart> carts,Customer customer) {
        this.setCurrentCustomer(customer);
        log.info("Constructor order customer name " +this.getCurrentCustomer().getName());
        List<Product> cartProductList = carts.stream().map(Cart::getProduct).collect(Collectors.toList());
        log.info("Constructor order card products list " + cartProductList.size());
        this.setProductList(cartProductList);
        log.info("Constructor created -" + this.toString());
    }

    //todo - скорее всего я что-то не так понял
    public String getCustomerName() {
        return this.currentCustomer.getName();
    }

    public List<String> getCustomerProductList() {
        return this.productList.stream()
                .map(Product::getName)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", currentCustomer=" + currentCustomer.getName() +
                ", productList=" + productList.stream().map(Product::toString) +
                '}';
    }
}

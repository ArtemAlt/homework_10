package ru.education.homework_10.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.education.homework_10.models.entity.Cart;
import ru.education.homework_10.models.entity.Customer;

import java.util.List;


@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
    List<Cart> findAllByCustomer(Customer customer);



}

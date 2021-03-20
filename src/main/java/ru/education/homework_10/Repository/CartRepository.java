package ru.education.homework_10.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.education.homework_10.models.Entity.Cart;
import ru.education.homework_10.models.Entity.Customer;
import ru.education.homework_10.models.Entity.Orders;

import java.util.List;


@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
    List<Cart> findAllByCustomer(Customer customer);



}

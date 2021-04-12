package ru.education.homework_10.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.education.homework_10.models.entity.Customer;
import ru.education.homework_10.models.entity.Orders;


@Repository
public interface OrderRepository extends JpaRepository<Orders,Long>, JpaSpecificationExecutor<Orders> {
    Orders findByCurrentCustomer(Customer customer);
}

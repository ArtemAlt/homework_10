package ru.education.homework_10.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.education.homework_10.models.entity.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findByName(String name);
}

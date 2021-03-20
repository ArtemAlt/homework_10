package ru.education.homework_10.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.education.homework_10.models.Entity.Customer;
import ru.education.homework_10.models.Entity.Product;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findByName(String name);
}

package ru.education.homework_10.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.education.homework_10.models.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}

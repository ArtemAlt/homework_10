package ru.education.homework_10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.education.homework_10.models.entity.ProductCategory;

@Repository
public interface CategoryRepository extends JpaRepository<ProductCategory,Long> {
    ProductCategory findByNameLike(String name);
}

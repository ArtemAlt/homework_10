package ru.education.homework_10.repository.Specifications;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.MultiValueMap;
import ru.education.homework_10.models.entity.Product;
@Slf4j
public class ProductSpecification {
    private static Specification<Product> priceGreaterOrEquals(int minPrice) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
    }

    private static Specification<Product> nameLike(String name) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("name"),String.format("%%%s%%", name));
    }

    private static Specification<Product> categoryLike(String name) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("productCategory"),String.format("%%%s%%", name));
    }

    public static Specification<Product> build(MultiValueMap<String, String> params) {
        Specification<Product> spec = Specification.where(null);
        if (params.containsKey("minPrice") && !params.getFirst("minPrice").isEmpty()) {
            spec = spec.and(ProductSpecification.priceGreaterOrEquals(Integer.parseInt(params.getFirst("minPrice"))));
        }
        if (params.containsKey("name") && !params.getFirst("name").isEmpty()) {
            log.info("NAME request "+params.getFirst("name"));
            spec = spec.and(ProductSpecification.nameLike(params.getFirst("name")));
        }
        if (params.containsKey("productCategory") && !params.getFirst("productCategory").isEmpty()) {
            log.info("CATEGORY request "+params.containsKey("productCategory") + " "+ params.getFirst("productCategory"));
            spec = spec.and(ProductSpecification.categoryLike(params.getFirst("productCategory")));
        }
        return spec;
    }

}

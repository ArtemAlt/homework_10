package ru.education.homework_10.Services.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.education.homework_10.models.DTO.ProductDTO;
import ru.education.homework_10.models.Entity.Product;

@Component
public class ProductMapper {
    ModelMapper mapper = new ModelMapper();
    public ProductDTO toDTO(Product product) {
        mapper.typeMap(Product.class, ProductDTO.class)
                .addMapping(Product::getProductCategoryName, ProductDTO::setProductCategory);
        return mapper.map(product, ProductDTO.class);
    }
}

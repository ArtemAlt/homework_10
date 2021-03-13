package ru.education.homework_10.Services.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.education.homework_10.models.DTO.ProductCategoryDTO;
import ru.education.homework_10.models.Entity.ProductCategory;


@Component
public class CategoryMapper {
    ModelMapper mapper = new ModelMapper();
    public ProductCategoryDTO toDTO(ProductCategory category) {
        mapper.typeMap(ProductCategory.class, ProductCategoryDTO.class)
                .addMapping(ProductCategory::getProductListName, ProductCategoryDTO::setProductList);
        return mapper.map(category, ProductCategoryDTO.class);
    }
}

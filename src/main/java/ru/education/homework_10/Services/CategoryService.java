package ru.education.homework_10.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.education.homework_10.Repository.CategoryRepository;
import ru.education.homework_10.Services.mappers.CategoryMapper;
import ru.education.homework_10.models.DTO.ProductCategoryDTO;
import ru.education.homework_10.models.Entity.ProductCategory;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository repository;
    @Autowired
    CategoryMapper mapper;

    public List<ProductCategoryDTO> findAll(){
        return repository.findAll().stream().map(c->mapper.toDTO(c)).collect(Collectors.toList());
    }
    public ProductCategory findByName (String name){
        return repository.findByNameLike(name);
    }
}

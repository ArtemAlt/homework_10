package ru.education.homework_10.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.education.homework_10.Services.CategoryService;
import ru.education.homework_10.Services.ProductService;
import ru.education.homework_10.models.DTO.ProductCategoryDTO;
import ru.education.homework_10.models.Entity.ProductCategory;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    @Autowired
    CategoryService service;
    @GetMapping
    public List<ProductCategoryDTO> findAll(){
        return service.findAll();
    }
}

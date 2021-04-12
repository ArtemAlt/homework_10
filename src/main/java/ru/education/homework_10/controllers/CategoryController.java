package ru.education.homework_10.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.education.homework_10.services.CategoryService;
import ru.education.homework_10.models.DTO.ProductCategoryDTO;

import java.util.List;

@RestController
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/api/v1/category")
public class CategoryController {
    @Autowired
    CategoryService service;
    @GetMapping
    public List<ProductCategoryDTO> findAll(){
        return service.findAll();
    }
}

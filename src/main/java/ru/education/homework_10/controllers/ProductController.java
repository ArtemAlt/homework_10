package ru.education.homework_10.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import ru.education.homework_10.repository.Specifications.ProductSpecification;
import ru.education.homework_10.services.CategoryService;
import ru.education.homework_10.models.DTO.ProductDTO;
import ru.education.homework_10.models.entity.Product;
import ru.education.homework_10.services.ProductService;

@Slf4j
@RestController
@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    ProductService service;
    @Autowired
    CategoryService catService;
    @GetMapping("/find/{name}") // ищет точное соответствие
    public ProductDTO findByName(@PathVariable String name){
        return service.findProductByNameDTO(name);
    }
    @GetMapping("/add")
    public void addProduct(@ModelAttribute Product product){
        service.saveProduct(product);
    }
    

    @GetMapping
    public Page<ProductDTO> findAll(@RequestParam MultiValueMap<String, String> param,
                                    @RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "10") int size) {
        return service.findAll(ProductSpecification.build(param),page,size);
    }
    @GetMapping("/category")
    public Page<ProductDTO> findByCategory(@RequestParam MultiValueMap<String, String> param,
                                           @RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "10") int size){
        return service.findAllByCategoryName(ProductSpecification.build(param),page,size);
    }

    @GetMapping("/pageable")
    public Page<ProductDTO> findAll(@RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "10") int size) {
        return service.findAllPage(page, size);
    }
}

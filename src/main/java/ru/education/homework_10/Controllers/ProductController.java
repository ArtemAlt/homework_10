package ru.education.homework_10.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.education.homework_10.models.DTO.ProductDTO;
import ru.education.homework_10.models.Entity.Product;
import ru.education.homework_10.Services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    ProductService service;

    @GetMapping
    public List<ProductDTO> findAll(){
        return service.findAll();
    }
}

package ru.education.homework_10.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.education.homework_10.Services.mappers.ProductMapper;
import ru.education.homework_10.models.DTO.ProductDTO;
import ru.education.homework_10.models.Entity.Product;
import ru.education.homework_10.Repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    ProductRepository repository;
    @Autowired
    ProductMapper mapper;

    public List<ProductDTO> findAll(){

        return repository.findAll().stream().map(p->mapper.toDTO(p)).collect(Collectors.toList());
    }
}

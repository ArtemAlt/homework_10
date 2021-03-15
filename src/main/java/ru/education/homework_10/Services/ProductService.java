package ru.education.homework_10.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.education.homework_10.Services.mappers.ProductMapper;
import ru.education.homework_10.models.DTO.ProductDTO;
import ru.education.homework_10.models.Entity.Product;
import ru.education.homework_10.Repository.ProductRepository;
import ru.education.homework_10.models.Entity.ProductCategory;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    ProductRepository repository;
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductMapper mapper;
    public Product findProductByName (String name){
        return repository.findByName(name);
    }
    public ProductDTO findProductByNameDTO (String name){
        return mapper.toDTO(repository.findByName(name));
    }
    public List<Product> getTenProducts(){
        return repository.findAll();
    }

    public Page<ProductDTO> findAll(Specification<Product> spec,int page,int size){
        return repository.findAll(spec,PageRequest.of(page,size))
                .map(p->mapper.toDTO(p));
    }

    public Page<ProductDTO> findAllPage(int page, int size) {
        return repository.findAll(PageRequest.of(page, size)).map(p -> mapper.toDTO(p));
    }
    public Page<ProductDTO> findAllByCategoryName(Specification<Product> spec, int page, int size){
        return repository.findAllByProductCategoryLike(spec,PageRequest.of(page, size))
                .map(p -> mapper.toDTO(p));
    }

    public void saveProduct(Product product) {
        ProductCategory category = categoryService.findByName(product.getProductCategoryName());
        product.setProductCategory(category);
        repository.saveAndFlush(product);
    }
}

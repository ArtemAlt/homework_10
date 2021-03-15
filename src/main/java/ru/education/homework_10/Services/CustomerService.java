package ru.education.homework_10.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.education.homework_10.Repository.CustomerRepository;
import ru.education.homework_10.Repository.ProductRepository;
import ru.education.homework_10.Services.mappers.ProductMapper;
import ru.education.homework_10.models.DTO.ProductDTO;
import ru.education.homework_10.models.Entity.Customer;
import ru.education.homework_10.models.Entity.Product;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository repository;



    public Customer findCustomer(String customer) {
        return repository.findByName(customer);
    }

    public void saveCustomer(Customer customer) {
        repository.saveAndFlush(customer);
    }
}

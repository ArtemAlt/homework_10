package ru.education.homework_10.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.education.homework_10.Services.CustomerService;
import ru.education.homework_10.Services.OrderService;
import ru.education.homework_10.models.DTO.ProductCategoryDTO;
import ru.education.homework_10.models.Entity.Customer;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    @Autowired
    CustomerService service;
    @GetMapping("/add")
    public void saveCustomer(@ModelAttribute Customer customer){
        service.saveCustomer(customer);
    }


}

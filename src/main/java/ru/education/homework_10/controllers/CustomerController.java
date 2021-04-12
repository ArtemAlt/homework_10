package ru.education.homework_10.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.education.homework_10.configuration.jwt.JwtProvider;
import ru.education.homework_10.models.DTO.AddCustomerDTO;
import ru.education.homework_10.models.DTO.AuthCustomerDTO;
import ru.education.homework_10.services.CustomerService;
import ru.education.homework_10.models.entity.Customer;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    CustomerService service;

    @Autowired
    JwtProvider provider;

    @PostMapping("/add")
    public String saveCustomer(@RequestBody AddCustomerDTO dto){
        service.saveCustomer(dto);
        return "New Customer by name " + dto.getName()+" added";
    }

    @PostMapping("/auth")
    public String authCustomer (@RequestBody AuthCustomerDTO dto){
        Customer c = service.findByLoginAndPassword(dto.getName(),dto.getPassword());
        String token = provider.generateToken(dto.getName());
        return "Bearer "+token;
    }


}

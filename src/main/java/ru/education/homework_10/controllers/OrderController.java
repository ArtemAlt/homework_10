package ru.education.homework_10.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.education.homework_10.services.OrderService;
import ru.education.homework_10.models.DTO.OrderDTO;

import java.security.Principal;
import java.util.List;

@RestController
@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
@RequestMapping("/api/v1/orders")
public class OrderController {
    @Autowired
    OrderService service;


    @GetMapping("/confirmOrder")
    public String makeOrder (Principal p){
        service.saveNewOrder(p.getName());
        return "Order for "+p.getName()+" confirmed";
    }

    @GetMapping("/all")
    public List<OrderDTO> findAll(){
        return service.findAll();
    }

    @GetMapping("/myOrders")
    public OrderDTO findOrderByCustomerName(Principal p){
        return service.findOrderByCustomerName(p.getName());
    }

}

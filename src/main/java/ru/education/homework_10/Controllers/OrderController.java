package ru.education.homework_10.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.education.homework_10.Services.CategoryService;
import ru.education.homework_10.Services.CustomerService;
import ru.education.homework_10.Services.OrderService;
import ru.education.homework_10.Services.ProductService;
import ru.education.homework_10.models.DTO.OrderDTO;
import ru.education.homework_10.models.DTO.ProductCategoryDTO;
import ru.education.homework_10.models.Entity.Customer;
import ru.education.homework_10.models.Entity.Orders;
import ru.education.homework_10.models.Entity.Product;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    @Autowired
    OrderService service;


    @GetMapping("/makeOrder/{name}")
    public void makeOrder (@PathVariable String name){
      service.saveNewOrder(name);
    }
    @GetMapping("/all")
    public List<OrderDTO> findAll(){
        return service.findAll();
    }

    @GetMapping("/show/{name}")
    public OrderDTO findOrderByCustomerName(@PathVariable String name){
        return service.findOrderByCustomerName(name);
    }

}

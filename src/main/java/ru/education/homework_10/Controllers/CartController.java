package ru.education.homework_10.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.education.homework_10.Services.CartService;
import ru.education.homework_10.models.DTO.CartDTO;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {
    @Autowired
    CartService service;

    @GetMapping("/add")
    public void addProductToCustomerCart(@RequestParam String name, String product) {
        service.addToCart(name, product);
    }
    @GetMapping("/show/{name}")
    public List<CartDTO> showCustomerCarts(@PathVariable String name){
        return service.showCustomerCarts(name);
    }


}

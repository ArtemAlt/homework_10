package ru.education.homework_10.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.education.homework_10.services.CartService;
import ru.education.homework_10.models.DTO.CartDTO;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
@Slf4j
public class CartController {
    @Autowired
    CartService service;

    @GetMapping("/add")
    public String  addProductToCustomerCart(@RequestParam  String productName, Principal principal) {
        log.info("Request from principal - "+principal.getName());
        service.addToCart(principal.getName(), productName);
        return "Add product - "+productName+" for customer - "+principal.getName()+" cart";
    }
    @GetMapping("/show")
    public List<CartDTO> showCustomerCarts(Principal principal){
        log.info("Request from principal - "+principal.getName());
        return service.showCustomerCarts(principal.getName());
    }


}

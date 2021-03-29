package ru.education.homework_10.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.education.homework_10.repository.CartRepository;
import ru.education.homework_10.services.mappers.CartMapper;
import ru.education.homework_10.models.DTO.CartDTO;
import ru.education.homework_10.models.entity.Cart;
import ru.education.homework_10.models.entity.Customer;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CartService {
    @Autowired
    CartRepository repository;

    @Autowired
    CartMapper mapper;

    @Autowired
    CustomerService customerService;

    @Autowired
    ProductService productService;

    public void addToCart(String customer, String product) {
        Cart cart = new Cart();
        cart.setCustomer(customerService.findCustomer(customer));
        cart.setProduct(productService.findProductByName(product));
        repository.saveAndFlush(cart);
    }

    public List<Cart> getCustomerCarts(String name) {
        Customer customer = customerService.findCustomer(name);
        log.info("NEW ORDER REQUEST customer name" + customer.getName());
        return repository.findAllByCustomer(customer);
    }

    public List<CartDTO> showCustomerCarts(String name) {
        return repository.findAllByCustomer(customerService.findCustomer(name))
                .stream().map(cart -> mapper.toDTO(cart))
                .collect(Collectors.toList());
    }

    public void deleteCatrByCustomer(Customer customer) {
        List<Cart> batch = repository.findAllByCustomer(customer);
        log.info("Delete cart by customer name " + batch.toString() + " size " + batch.size());
        repository.deleteInBatch(batch);
    }
}

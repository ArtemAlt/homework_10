package ru.education.homework_10.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.education.homework_10.Repository.CartRepository;
import ru.education.homework_10.Repository.OrderRepository;
import ru.education.homework_10.Services.mappers.CartMapper;
import ru.education.homework_10.Services.mappers.OrderMapper;
import ru.education.homework_10.models.DTO.CartDTO;
import ru.education.homework_10.models.DTO.OrderDTO;
import ru.education.homework_10.models.Entity.Cart;
import ru.education.homework_10.models.Entity.Customer;
import ru.education.homework_10.models.Entity.Orders;
import ru.education.homework_10.models.Entity.Product;

import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@Service
public class CartService {
    //todo - слишком много всег в одном месте
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
        log.info("NEW ORDER REQUEST customer name"+customer.getName());
        return repository.findAllByCustomer(customer);
    }

    public List<CartDTO> showCustomerCarts(String name) {
        return repository.findAllByCustomer(customerService.findCustomer(name))
                .stream().map(cart ->mapper.toDTO(cart))
                .collect(Collectors.toList());
    }


    public void deleteCatrByCustomer(Customer customer) {
        List<Cart> batch = repository.findAllByCustomer(customer);
        log.info("Delete cart by customer name "+batch.toString()+" size "+ batch.size());
        repository.deleteInBatch(batch);
    }
}

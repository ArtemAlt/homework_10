package ru.education.homework_10.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.education.homework_10.repository.OrderRepository;
import ru.education.homework_10.services.mappers.OrderMapper;
import ru.education.homework_10.models.DTO.OrderDTO;
import ru.education.homework_10.models.entity.Cart;
import ru.education.homework_10.models.entity.Customer;
import ru.education.homework_10.models.entity.Orders;

import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@Service
public class OrderService {
    @Autowired
    OrderRepository repository;
    @Autowired
    CartService cartService;
    @Autowired
    CustomerService customerService;
    @Autowired
    OrderMapper mapper;

    public void saveNewOrder(String name){
        List<Cart> carts= cartService.getCustomerCarts(name);
        Customer customer = customerService.findCustomer(name);
        log.info("Order service request new order customer "+ customer.getName());
        repository.save(new Orders(carts,customer));
        cartService.deleteCatrByCustomer(customer);
    }


    public List<OrderDTO> findAll() {
        return repository.findAll().stream().map(orders -> mapper.toDTO(orders)).collect(Collectors.toList());
    }

    public OrderDTO findOrderByCustomerName(String name) {
        Customer customer = customerService.findCustomer(name);
        return mapper.toDTO(repository.findByCurrentCustomer(customer));
    }
}

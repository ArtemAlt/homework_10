package ru.education.homework_10.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.education.homework_10.Repository.OrderRepository;
import ru.education.homework_10.Repository.ProductRepository;
import ru.education.homework_10.Services.mappers.OrderMapper;
import ru.education.homework_10.Services.mappers.ProductMapper;
import ru.education.homework_10.models.DTO.OrderDTO;
import ru.education.homework_10.models.DTO.ProductDTO;
import ru.education.homework_10.models.Entity.Cart;
import ru.education.homework_10.models.Entity.Customer;
import ru.education.homework_10.models.Entity.Orders;
import ru.education.homework_10.models.Entity.Product;

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
        Customer customer = customerService.findCustomer(name);//todo - реализация не очень, можно у входных карт забрать
        log.info("Order service request new order customer "+ customer.getName());

//        order.createOrderFromCards(carts,customer);
//        log.info("Order details - "+mapper.toDTO(order));
//        log.info("Order before save - "+ order.toString());
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

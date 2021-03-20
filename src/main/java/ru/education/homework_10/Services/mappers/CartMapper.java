package ru.education.homework_10.Services.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.education.homework_10.models.DTO.CartDTO;
import ru.education.homework_10.models.DTO.OrderDTO;
import ru.education.homework_10.models.Entity.Cart;
import ru.education.homework_10.models.Entity.Orders;

@Component
public class CartMapper {
    ModelMapper mapper = new ModelMapper();

    public CartDTO toDTO(Cart cart) {
        mapper.typeMap(Cart.class, CartDTO.class)
                .addMapping(Cart::getCartCustomer, CartDTO::setCustomer)
                .addMapping(Cart::getCartProduct, CartDTO::setProduct);
        return mapper.map(cart, CartDTO.class);
    }


}

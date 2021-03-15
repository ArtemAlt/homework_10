package ru.education.homework_10.Services.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.education.homework_10.models.DTO.OrderDTO;
import ru.education.homework_10.models.DTO.ProductDTO;
import ru.education.homework_10.models.Entity.Orders;
import ru.education.homework_10.models.Entity.Product;

@Component
public class OrderMapper {
    ModelMapper mapper = new ModelMapper();

    public OrderDTO toDTO(Orders order) {
        mapper.typeMap(Orders.class, OrderDTO.class)
                .addMapping(Orders::getCustomerName, OrderDTO::setName)
                .addMapping(Orders::getCustomerProductList, OrderDTO::setProductList);
        return mapper.map(order, OrderDTO.class);
    }


}

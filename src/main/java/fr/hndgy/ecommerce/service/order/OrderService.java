package fr.hndgy.ecommerce.service.order;

import java.util.List;

import fr.hndgy.ecommerce.dto.OrderProductDto;
import fr.hndgy.ecommerce.exception.ResourceNotFoundException;
import fr.hndgy.ecommerce.model.Order;

public interface OrderService {
    Iterable<Order> getAllOrders();
    Order create(List<OrderProductDto> list) throws ResourceNotFoundException;
    Order update(Order order);
}

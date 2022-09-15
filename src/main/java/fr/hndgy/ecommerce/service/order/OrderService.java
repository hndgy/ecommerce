package fr.hndgy.ecommerce.service.order;

import java.util.List;

import fr.hndgy.ecommerce.dto.ProductOrder;
import fr.hndgy.ecommerce.model.Order;

public interface OrderService {
    Iterable<Order> getAllOrders();
    Order create(List<ProductOrder> list);
    Order update(Order order);
}

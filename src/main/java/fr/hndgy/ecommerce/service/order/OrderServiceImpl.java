package fr.hndgy.ecommerce.service.order;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import fr.hndgy.ecommerce.dto.ProductOrder;
import fr.hndgy.ecommerce.exception.RessourceNotFoundException;
import fr.hndgy.ecommerce.model.Order;
import fr.hndgy.ecommerce.model.OrderProduct;
import fr.hndgy.ecommerce.model.OrderStatus;
import fr.hndgy.ecommerce.repository.OrderRepository;
import fr.hndgy.ecommerce.repository.ProductRepository;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    
    public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    
    @Override
    public Iterable<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order create(List<ProductOrder> productOrders) {

        var order = new Order();
        order.setDateCreated(LocalDateTime.now());
        var listOrderProd = productOrders.stream().map((o) -> new OrderProduct(order, productRepository.findById(o.productId()).get(),o.quantity())).collect(Collectors.toList());
        order.setOrderProducts(listOrderProd);
        order.setDateCreated(LocalDateTime.now());

        order.setStatus(OrderStatus.PENDING);
        return orderRepository.save(order);
    }

    @Override
    public Order update(Order order) {
        return orderRepository.save(order);
    }

}

package fr.hndgy.ecommerce.service.order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import fr.hndgy.ecommerce.dto.OrderProductDto;
import fr.hndgy.ecommerce.exception.ResourceNotFoundException;
import fr.hndgy.ecommerce.model.Order;
import fr.hndgy.ecommerce.model.OrderProduct;
import fr.hndgy.ecommerce.model.OrderStatus;
import fr.hndgy.ecommerce.repository.OrderProductRepository;
import fr.hndgy.ecommerce.repository.OrderRepository;
import fr.hndgy.ecommerce.repository.ProductRepository;
import fr.hndgy.ecommerce.service.orderProduct.OrderProductService;
import fr.hndgy.ecommerce.service.product.ProductService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final OrderProductService orderProductService;
    private final ProductService productService;
    
    public OrderServiceImpl(OrderRepository orderRepository, OrderProductService orderProductService, ProductService productService) {
        this.orderRepository = orderRepository;
        this.orderProductService = orderProductService;
        this.productService = productService;
    }

    
    @Override
    public Iterable<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order create(List<OrderProductDto> productOrders) throws ResourceNotFoundException{

        var order = new Order();
        order.setDateCreated(LocalDateTime.now());

        order.setDateCreated(LocalDateTime.now());

        order.setStatus(OrderStatus.PENDING);

        var savedOrder = orderRepository.save(order);

        var listOrderProd = new ArrayList<OrderProduct>();

        for (var po : productOrders) {
            var product = this.productService.getProduct(po.productId());
            var orderProduct = new OrderProduct(savedOrder, product, po.quantity());
            var savedOP = orderProductService.create(orderProduct);
            listOrderProd.add(savedOP);
        }

        savedOrder.setOrderProducts(listOrderProd);
        update(savedOrder);

        return savedOrder;
    }

    @Override
    public Order update(Order order) {
        return orderRepository.save(order);
    }

}

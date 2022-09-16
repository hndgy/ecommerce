package fr.hndgy.ecommerce.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.hndgy.ecommerce.dto.OrderForm;
import fr.hndgy.ecommerce.exception.ResourceNotFoundException;
import fr.hndgy.ecommerce.model.Order;
import fr.hndgy.ecommerce.service.order.OrderService;

@RestController
@RequestMapping("api/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping({"/",""})
    public ResponseEntity<Order> createOrder(@RequestBody OrderForm orderForm) throws ResourceNotFoundException{
        var order = this.orderService.create(orderForm.productOrders());
        return ResponseEntity.created(URI.create("uri")).body(order);
    }


    @GetMapping({"/", ""})
    public Iterable<Order> getAllOrders(){
        return this.orderService.getAllOrders();
    }
}

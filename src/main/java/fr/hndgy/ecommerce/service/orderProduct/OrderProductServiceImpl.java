package fr.hndgy.ecommerce.service.orderProduct;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import fr.hndgy.ecommerce.model.OrderProduct;
import fr.hndgy.ecommerce.repository.OrderProductRepository;

@Service
@Transactional
public class OrderProductServiceImpl implements OrderProductService {

    private final OrderProductRepository orderProductRepository;

    public OrderProductServiceImpl(OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }

    @Override
    public OrderProduct create(OrderProduct orderProduct) {
        return orderProductRepository.save(orderProduct);
    }
    
}

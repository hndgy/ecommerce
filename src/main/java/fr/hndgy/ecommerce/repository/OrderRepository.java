package fr.hndgy.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.hndgy.ecommerce.model.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {
    
}

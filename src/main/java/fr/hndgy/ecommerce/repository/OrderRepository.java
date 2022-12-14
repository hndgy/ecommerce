package fr.hndgy.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.hndgy.ecommerce.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    
}

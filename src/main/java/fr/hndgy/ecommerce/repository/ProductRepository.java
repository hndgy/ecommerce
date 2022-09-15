package fr.hndgy.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.hndgy.ecommerce.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    
}

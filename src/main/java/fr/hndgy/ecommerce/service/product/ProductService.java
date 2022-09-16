package fr.hndgy.ecommerce.service.product;

import fr.hndgy.ecommerce.exception.ResourceNotFoundException;
import fr.hndgy.ecommerce.model.Product;

public interface ProductService {
    Iterable<Product> getAllProducts();
    Product getProduct(Long id) throws ResourceNotFoundException;
    Product save(Product product);

}

package fr.hndgy.ecommerce.service.product;

import fr.hndgy.ecommerce.exception.RessourceNotFoundException;
import fr.hndgy.ecommerce.model.Product;

public interface ProductService {
    Iterable<Product> getAllProducts();
    Product getProduct(Long id) throws RessourceNotFoundException;
    Product save(Product product);

}

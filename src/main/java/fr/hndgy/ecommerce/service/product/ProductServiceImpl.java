package fr.hndgy.ecommerce.service.product;

import org.springframework.stereotype.Service;

import fr.hndgy.ecommerce.exception.RessourceNotFoundException;
import fr.hndgy.ecommerce.model.Product;
import fr.hndgy.ecommerce.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    

    
    @Override
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) throws RessourceNotFoundException {
    
        return productRepository.findById(id).orElseThrow(() -> new RessourceNotFoundException());
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }
    
}

package fr.hndgy.ecommerce.service.product;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import fr.hndgy.ecommerce.exception.ResourceNotFoundException;
import fr.hndgy.ecommerce.model.Product;
import fr.hndgy.ecommerce.repository.ProductRepository;

@Service
@Transactional
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
    public Product getProduct(Long id) throws ResourceNotFoundException {
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }
    
}

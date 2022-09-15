package fr.hndgy.ecommerce.controller;

import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.hndgy.ecommerce.model.Product;
import fr.hndgy.ecommerce.service.product.ProductService;

@RestController
@RequestMapping("api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping({"","/"})
    public @NotNull Iterable<Product> getProducts(){
        return productService.getAllProducts();
    }
}

package com.vodqa.productservice.web.services;

import com.vodqa.productservice.web.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById(Integer productId) {
        Optional<Product> result = productRepository.findById(productId);
        return result.orElse(null);
    }

    public List<Product> getListOfProductsByIds(List<Integer> productIds) {
        List<Product> products = new ArrayList<>();
        productRepository.findAllById(productIds).forEach(products::add);
        return products;
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }
}

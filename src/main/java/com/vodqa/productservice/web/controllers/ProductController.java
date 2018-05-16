package com.vodqa.productservice.web.controllers;

import com.vodqa.productservice.web.models.Product;
import com.vodqa.productservice.web.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/products/{productId}")
    public Product getProduct(@PathVariable String productId) {
        return productService.getProductById(productId);
    }

    @GetMapping(value = "/products")
    public List<Product> getProducts(@RequestParam List<String> productIds) {
        return productService.getListOfProductsByIds(productIds);
    }
}

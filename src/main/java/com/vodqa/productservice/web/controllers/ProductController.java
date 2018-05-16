package com.vodqa.productservice.web.controllers;

import com.vodqa.productservice.web.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @GetMapping(value = "/products/{productId}")
    public Product getProduct(@PathVariable String productId) {
        return new Product(productId, "Shoe", 345);
    }

    @GetMapping(value = "/products")
    public List<Product> getProducts(@RequestParam List<String> productIds) {
        List<Product> products = new ArrayList<>();
        productIds.forEach(id -> products.add(new Product(id, "Shoe", 234)));
        return products;
    }
}

package com.vodqa.productservice.web.services;

import com.vodqa.productservice.web.models.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductRepository {
    List<Product> products = new ArrayList<Product>(Arrays.asList(new Product(123, "Chair", 20),
            new Product(124, "Table", 35),
            new Product(125, "Sofa", 70)));

    public Optional<Product> findById(Integer productId) {
        return products.stream().filter((product) -> product.getId().equals(productId)).findFirst();
    }

    public List<Product> findAllById(List<Integer> productIds) {
        return products.stream().filter((product) -> productIds.contains(product.getId())).collect(Collectors.toList());
    }

    public Product save(Product product) {
        products.add(product);
        return product;
    }

    public List<Product> findAll() {
        return products;
    }
}

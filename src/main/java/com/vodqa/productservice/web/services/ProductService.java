package com.vodqa.productservice.web.services;

import com.vodqa.productservice.web.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    public Product getProductById(String productId) {
        return new Product(productId, "Chair", 230);
    }

    public List<Product> getListOfProductsByIds(List<String> productIds) {
        List<Product> products = new ArrayList<>();
        productIds.forEach(id -> products.add(new Product(id, "Table", 450)));
        return products;
    }
}

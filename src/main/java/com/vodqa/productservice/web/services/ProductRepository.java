package com.vodqa.productservice.web.services;

import com.vodqa.productservice.web.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer>{

}

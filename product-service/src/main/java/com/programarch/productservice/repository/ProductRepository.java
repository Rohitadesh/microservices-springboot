package com.programarch.productservice.repository;

import com.programarch.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface ProductRepository extends MongoRepository<Product,String>{

    
}

package com.programarch.productservice.service;

import java.util.List;

// import com 
import org.springframework.stereotype.Service;

import com.programarch.productservice.dto.ProductRequest;
import com.programarch.productservice.dto.ProductResponse;
import com.programarch.productservice.model.Product;
// import com.programarch.productservice.model.Product.ProductBuilder;
import com.programarch.productservice.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    // public ProductService(ProductRepository productRepository){
    //     this.productRepository=productRepository;
    // }
    public void createProduct(ProductRequest productRequest){
         Product product = Product.builder()
            .name(productRequest.getName())
            .description(productRequest.getDescription())
            .price(productRequest.getPrice())
            .build();
        
        productRepository.save(product);
        
       
    log.info("Product {} is saved", product.getId());
        
    }
   public List<ProductResponse> getAllProduct() {
    List<Product> products = productRepository.findAll();
    return products.stream()
            .map(this::mapToProductResponse)
            .toList();
}

private ProductResponse mapToProductResponse(Product product) {
    return ProductResponse.builder()
            .id(product.getId())
            .name(product.getName())
            .description(product.getDescription())
            .price(product.getPrice())
            .build();
}


}

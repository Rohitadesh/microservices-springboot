package com.programarch.productservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.programarch.productservice.dto.ProductRequest;
import com.programarch.productservice.dto.ProductResponse;
import com.programarch.productservice.service.ProductService;

import lombok.RequiredArgsConstructor;
import java.util.*;
@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    
    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
    }

    @GetMapping
   @ResponseStatus(HttpStatus.OK)
   public List<ProductResponse> getAllProduct(){
    return productService.getAllProduct();
   }
}

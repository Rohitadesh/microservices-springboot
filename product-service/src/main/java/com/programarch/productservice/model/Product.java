package com.programarch.productservice.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.programarch.productservice.dto.ProductResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
// import lombok.Getter;
import lombok.NoArgsConstructor;
// import lombok.Setter;


@Document(collection = "products") 
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    private String id; 

    private String name;
    private String description;
    private BigDecimal price;
}
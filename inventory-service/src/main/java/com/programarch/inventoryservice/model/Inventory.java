package com.programarch.inventoryservice.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="inventory")
//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skuCode;
    private Integer quantity;

//    public String getSkuCode(){
//        return skuCode;
//    }

}

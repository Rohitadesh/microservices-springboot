package com.programarch.inventoryservice.repository;

import com.programarch.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import  java.util.*;
public interface InventoryRepository extends JpaRepository<Inventory,Long> {
    Optional<Inventory> findBySkuCodeIn(List<String> skuCode);

//    Collection<Object> findBySkuCodeIn(List<String> skuCode);
}

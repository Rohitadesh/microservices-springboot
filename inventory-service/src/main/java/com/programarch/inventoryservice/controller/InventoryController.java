package com.programarch.inventoryservice.controller;


import com.programarch.inventoryservice.dto.InventoryResponse;
import com.programarch.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
        private  final InventoryService inventoryService;
        @GetMapping("/{skuCode}")
        @ResponseStatus(HttpStatus.OK)
        public List<InventoryResponse> isInStock(@PathVariable("sku-code") List<String> skuCode){
            return inventoryService.isInStock(skuCode);
        }

}

package com.programarch.orderservice.service;


import com.programarch.orderservice.config.WebClientConfig;
import com.programarch.orderservice.dto.OrderLineItemsDto;
import com.programarch.orderservice.dto.OrderRequest;
import com.programarch.orderservice.model.Order;
import com.programarch.orderservice.model.OrderLineItems;
import com.programarch.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private  final WebClient webClient;
    private  final OrderRepository orderRepository;
    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsList().stream()
                .map(orderLineItemsDto -> mapToDto(orderLineItemsDto))
                .toList();

       boolean result= webClient.get().uri("http://localhost:8082/api/inventory")
                        .retrieve().bodyToMono(Boolean.class).block();

        order.setOrderLineItemsList(orderLineItems);
        if(result){
            orderRepository.save(order);
        }
        else{
            throw  new IllegalArgumentException("Product is in stock,please try again later");
        }
    }

    public OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto){
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        return orderLineItems;

    }

}

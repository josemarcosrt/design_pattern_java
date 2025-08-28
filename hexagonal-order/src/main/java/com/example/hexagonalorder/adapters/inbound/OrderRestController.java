package com.example.hexagonalorder.adapters.inbound;

import com.example.hexagonalorder.domain.Order;
import com.example.hexagonalorder.domain.OrderService;

public class OrderRestController {

    private final OrderService service;

    public OrderRestController(OrderService service) {
        this.service = service;
    }

    // Simulação de endpoint REST
    public void createOrderEndpoint(String id, String product, int quantity) {
        Order order = new Order(id, product, quantity);
        service.createOrder(order);
    }
}

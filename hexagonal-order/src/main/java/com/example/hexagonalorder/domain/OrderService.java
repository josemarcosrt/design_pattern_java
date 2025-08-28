package com.example.hexagonalorder.domain;

import com.example.hexagonalorder.domain.ports.OrderRepositoryPort;
import com.example.hexagonalorder.domain.ports.NotificationPort;

public class OrderService {

    private final OrderRepositoryPort repository;
    private final NotificationPort notification;

    public OrderService(OrderRepositoryPort repository, NotificationPort notification) {
        this.repository = repository;
        this.notification = notification;
    }

    public void createOrder(Order order) {
        if (!order.isValid()) {
            throw new IllegalArgumentException("Pedido inválido!");
        }
        repository.save(order);
        notification.notify(order);
    }
}

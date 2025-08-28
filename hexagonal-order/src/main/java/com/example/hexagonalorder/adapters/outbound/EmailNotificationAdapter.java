package com.example.hexagonalorder.adapters.outbound;

import com.example.hexagonalorder.domain.Order;
import com.example.hexagonalorder.domain.ports.NotificationPort;

public class EmailNotificationAdapter implements NotificationPort {
    @Override
    public void notify(Order order) {
        System.out.println("📧 Enviando e-mail do pedido: " + order.getId());
    }
}

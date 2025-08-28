package com.example.hexagonalorder.adapters.outbound;

import com.example.hexagonalorder.domain.Order;
import com.example.hexagonalorder.domain.ports.OrderRepositoryPort;

public class DatabaseOrderRepositoryAdapter implements OrderRepositoryPort {
    @Override
    public void save(Order order) {
        System.out.println("💾 Salvando pedido no banco: " + order.getId());
    }
}

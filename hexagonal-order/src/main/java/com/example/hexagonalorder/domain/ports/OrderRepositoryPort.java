package com.example.hexagonalorder.domain.ports;

import com.example.hexagonalorder.domain.Order;

public interface OrderRepositoryPort {
    void save(Order order);
}

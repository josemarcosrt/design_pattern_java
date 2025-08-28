package com.example.hexagonalorder.domain.ports;

import com.example.hexagonalorder.domain.Order;

public interface NotificationPort {
    void notify(Order order);
}

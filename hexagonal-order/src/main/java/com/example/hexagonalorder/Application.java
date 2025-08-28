package com.example.hexagonalorder;

import com.example.hexagonalorder.adapters.inbound.OrderRestController;
import com.example.hexagonalorder.adapters.outbound.DatabaseOrderRepositoryAdapter;
import com.example.hexagonalorder.adapters.outbound.EmailNotificationAdapter;
import com.example.hexagonalorder.domain.OrderService;

public class Application {
    public static void main(String[] args) {
        OrderService orderService = new OrderService(
                new DatabaseOrderRepositoryAdapter(),
                new EmailNotificationAdapter()
        );

        OrderRestController controller = new OrderRestController(orderService);

        controller.createOrderEndpoint("1", "Notebook", 2);
        controller.createOrderEndpoint("2", "Cadeira Gamer", 0); // gera exceção
    }
}

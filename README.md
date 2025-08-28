 <pre>
        <code>
           hexagonal-order/
               └── src/main/java/com/example/hexagonalorder/
                   ├── domain/
                   │    ├── Order.java
                   │    ├── OrderService.java
                   │    ├── ports/
                   │    │    ├── NotificationPort.java
                   │    │    └── OrderRepositoryPort.java
                   │
                   ├── adapters/
                   │    ├── inbound/
                   │    │    └── OrderRestController.java
                   │    └── outbound/
                   │         ├── DatabaseOrderRepositoryAdapter.java
                   │         └── EmailNotificationAdapter.java
                   │
                   └── Application.java
        </code>
</pre>


     <img width="1536" height="1024" alt="Padrão de Arquitetura Hexagonal" src="https://github.com/user-attachments/assets/f6d1bc0a-4b2b-4bc5-ba92-30c60f7ba5b2" />

Imagine um caso simples:
- O domínio precisa criar um pedido
- Salvar em um repositório (pode ser BD, memória, API externa…)
- Notificar o cliente por e-mail ou WhatsApp

1. Camada de Negócio (Domínio)
   - Order 
2. Port (Interface) - Define o que o domínio precisa, sem depender de implementação concreta:
   - OrderRepositoryPort
   - NotificationPort 
3 Serviço de Negócio - Usa apenas as ports:
   - OrderService
4. Adapters (Implementações)
    - DatabaseOrderRepositoryAdapter
    - EmailNotificationAdapter

5. Adapter para entrada (ex.: REST Controller)
    - OrderRestController

   Benefícios
   1. Proteção da Camada de Negócio
      O domínio não conhece frameworks, banco ou APIs externas.
      Ele só conhece ports (OrderRepositoryPort, NotificationPort).
      Se amanhã trocar banco por MongoDB, ou e-mail por WhatsApp, a regra de negócio não muda — só troca o adapter.

   2. Testabilidade
     Para testar, você cria mocks/fakes dos ports:
     <pre>
         <code>
               public class InMemoryOrderRepository implements OrderRepositoryPort {
                  private final List<Order> orders = new ArrayList<>();
                  public void save(Order order) { orders.add(order); }
                  public List<Order> getOrders() { return orders; }
              }
              
              public class FakeNotificationAdapter implements NotificationPort {
                  public void notify(Order order) {
                      System.out.println("Notificação fake para teste: " + order.getId());
                  }
              }
         </code>
    </pre>
No teste, você passa esses fakes para o OrderService e consegue validar a lógica sem depender de BD ou rede.

   3. Integração de Novos Funcionamentos

     Quer trocar de Email para WhatsApp? Basta criar um novo adapter WhatsAppNotificationAdapter implementando NotificationPort.
     Quer salvar em Kafka ao invés de BD? Cria KafkaOrderRepositoryAdapter.
     Nenhuma mudança no OrderService (regra de negócio).

Resumindo

     A Arquitetura Hexagonal (Ports & Adapters) traz:
     
     Independência de frameworks e infra → domínio não conhece detalhes externos
     Testabilidade → fácil simular adapters com fakes/mocks
     Flexibilidade → trocar/adicionar integrações sem mexer no core
     Proteção da regra de negócio → foco só em lógica, sem ifs de infra espalhados



 

   


package pl.gornik;

import pl.gornik.enums.OrderStatus;
import pl.gornik.products.Product;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int lastOrderId = 0;

    private final int orderId;
    private final Client client;
    private final List<Product> products;
    private OrderStatus status;
    private final LocalDateTime orderDate;

    public Order(Client client, List<Product> clientProducts) {
        this.client = client;
        this.products = new ArrayList<>(clientProducts);
        this.status = OrderStatus.NEW;
        this.orderDate = LocalDateTime.now();

        client.addOrder(this);
        this.orderId = ++lastOrderId;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void displayOrder() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        String formattedOrderDate = orderDate.format(formatter);

        System.out.println();
        System.out.println("--- Zamówienie " + orderId + " ---");
        System.out.println("Klient: " + client.getName() + " " + client.getSurname());
        System.out.println("Email: " + client.getEmail());
        System.out.println("Data zamówienia: " + formattedOrderDate);
        System.out.println("Status: " + status);
        System.out.println("Produkty:");
        for (Product product : products) {
            product.showcaseProduct();
            System.out.println();
        }
    }
}
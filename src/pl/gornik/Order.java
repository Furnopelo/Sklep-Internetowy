package pl.gornik;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Client client;
    private List<Product> products = new ArrayList<>();
    private OrderStatus status;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

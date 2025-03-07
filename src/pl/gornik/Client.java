package pl.gornik;

import pl.gornik.products.Product;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String name;
    private String surname;
    private String email;
    private List<Product> cart = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public List<Product> getCart() {
        return cart;
    }

    public void addProductToCart (Product product) {
        cart.add(product);
        System.out.println("Produkt został pomyślnie dodany do koszyka.");
    }

    public void removeProductFromCart (Product product) {
        if (cart.contains(product)) {
            cart.remove(product);
            System.out.println("Produkt został pomyślnie usunięty z koszyka.");
        }
        else System.out.println("Nie ma takiego produktu w koszyku.");
    }

    public double calculateTotalCartPrice() {
        double total = 0;
        for (Product product : cart) {
            total += product.getPrice();
        }
        return total;
    }

    public void showcaseCart() {
        if (cart.isEmpty()) System.out.println("Nie masz żadnych produktów w koszyku.");
        else {
            System.out.println("Produkty w koszyku: ");
            for (Product product : cart) {
                product.showcaseProduct();
                System.out.print("\n");
            }
        }
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void showcaseOrders() {
        if (orders.isEmpty()) {
            System.out.println();
            System.out.println("Nie masz żadnych zamówień.");
        }
        else {
            for (Order order : orders) {
                order.displayOrder();
            }
        }
    }

    public Client(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
}
